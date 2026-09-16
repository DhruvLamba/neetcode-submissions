public class Solution {

    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Step 1: Build frequency map of characters needed from t
        HashMap<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        // count = number of DISTINCT characters we still need to fully satisfy
        // (if t has 3 unique chars, count starts at 3)
        int count = need.size();

        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        // Window frequency map
        HashMap<Character, Integer> window = new HashMap<>();

        while (right < s.length()) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            // If this char's window count now exactly matches what's needed,
            // one requirement is satisfied -> decrement count
            if (need.containsKey(c) && window.get(c).intValue() == need.get(c).intValue()) {
                count--;
            }

            // When count == 0, all distinct characters are satisfied -> try shrinking
            while (count == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }

                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);

                // If removing this char breaks a satisfied requirement, increment count
                if (need.containsKey(leftChar) && window.get(leftChar) < need.get(leftChar)) {
                    count++;
                }

                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC"; // 3 distinct characters -> count initializes to 3

        String result = minWindow(s, t);
        System.out.println("Minimum window substring: " + result);
    }
}