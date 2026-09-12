class Solution {
    public int characterReplacement(String s, int k) {
        int left=0;
        int res=0;
        int maxf=0;
        int[] count=new int[26];
        for(int right=left;right<s.length();right++){
            int id=s.charAt(right)-'A';
            count[id]++;
            maxf=Math.max(count[id],maxf);
            int window=right-left+1;
            int l=window-maxf;
            if (l > k) {                
                count[s.charAt(left) - 'A']--;
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
