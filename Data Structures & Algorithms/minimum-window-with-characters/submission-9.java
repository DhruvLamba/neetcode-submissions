public class Solution {

    public static String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length(); // number of characters we need to match (not distinct, total)

        if (n < m) return "";

        int[] hash = new int[256];
        for (char c : t.toCharArray()) {
            hash[c]++;
        }

        int cnt = 0;      // count = 3 (or m) -> counts how many chars matched so far
        int l = 0, r = 0;
        int minLen = Integer.MAX_VALUE;
        int sInd = -1;

        while (r < s.length()) {

            // if hash[s[r]] > 0, it means this char is still needed
            if (hash[s.charAt(r)] > 0) {
                cnt = cnt + 1;
            }
            hash[s.charAt(r)]--;

            // once cnt == m, window is valid -> shrink from left
            while (cnt == m) {

                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    sInd = l;
                }

                hash[s.charAt(l)]++;
                if (hash[s.charAt(l)] > 0) {
                    cnt = cnt - 1;
                }

                l++;
            }

            r = r + 1;
        }

        return sInd == -1 ? "" : s.substring(sInd, sInd + minLen);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println("Minimum window substring: " + minWindow(s, t));
    }
}