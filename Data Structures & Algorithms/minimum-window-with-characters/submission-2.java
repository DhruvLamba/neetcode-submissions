class Solution {
    public String minWindow(String s, String t) {
        int minLen = Integer.MAX_VALUE;
        String res = "";

        int[] small = new int[128];
        for (char m : t.toCharArray()) {
            small[m]++;
        }

        int[] word = new int[128];
        int i = 0;

        for (int j = 0; j < s.length(); j++) {
            // Add current character to window map
            word[s.charAt(j)]++;

            // Shrink window from the left while it remains valid
            while (isvalid(word, small)) {
                int currentLen = j - i + 1;
                if (currentLen < minLen) {
                    minLen = currentLen;
                    res = s.substring(i, j + 1);
                }

                // Remove leftmost character and shrink window
                word[s.charAt(i)]--;
                i++;
            }
        }
        return res;
    }

    public boolean isvalid(int[] word, int[] small) {
        for (int i = 0; i < 128; i++) {
            if (word[i] < small[i]) {
                return false;
            }
        }
        return true;
    }
}