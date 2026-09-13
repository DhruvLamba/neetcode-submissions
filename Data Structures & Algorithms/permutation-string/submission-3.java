class Solution {
    public boolean isfreq(int[] freq, int[] second){
            for(int i=0;i<26;i++){
                if(freq[i]!=second[i]){
                    return false;
                }
            }
            return true;
        }
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
        int len=s1.length();
        int[] count=new int[26];
        for(int i=0;i<len;i++){
            count[s1.charAt(i)-'a']++;
        }
        for(int j=0;j<s2.length();j++){
            int window=0;
            int idx=j;
            int[] main=new int[26];
            while(window<len && idx<s2.length()){
                main[s2.charAt(idx)-'a']++;
                window++;
                idx++;
            }
            if(isfreq(main,count)){
                return true;
            }
        }
        return false;
    }
}
