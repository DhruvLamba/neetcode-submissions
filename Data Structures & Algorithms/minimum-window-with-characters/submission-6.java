public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Frequency map for target string t
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : t.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int requiredChars = t.length();
        int minLen = Integer.MAX_VALUE;
        int startIndex = 0;

        while (right < s.length()) {
            char rChar = s.charAt(right);

            // If rChar is needed, decrement overall required count
            if (counts.containsKey(rChar)) {
                if (counts.get(rChar) > 0) {
                    requiredChars--;
                }
                counts.put(rChar, counts.get(rChar) - 1);
            }
            right++;

            // Shrink window from the left once all characters are matched
            while (requiredChars == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    startIndex = left;
                }

                char lChar = s.charAt(left);
                if (counts.containsKey(lChar)) {
                    counts.put(lChar, counts.get(lChar) + 1);
                    // If count goes above 0, window no longer satisfies target requirements
                    if (counts.get(lChar) > 0) {
                        requiredChars++;
                    }
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLen);
    }
}