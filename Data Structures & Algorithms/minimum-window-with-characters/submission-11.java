public class Solution {

    public static String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length(); 
        if (n < m) return "";
        int[] hash = new int[256];
        for (char c : t.toCharArray()) {
            hash[c]++;
        }
        int cnt = 0; 
        int l = 0, r = 0;
        int minLen = Integer.MAX_VALUE;
        int sInd = -1;
        while (r < s.length()) {
            if (hash[s.charAt(r)] > 0) {
                cnt = cnt + 1;
            }
            hash[s.charAt(r)]--;
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
}