class Solution {
    public String minWindow(String s, String t) {
        if(s.length()==0 || t.length()==0 || s.length()<t.length()){
            return "";
        }
        int[] hash=new int[256];
        for(char f:t.toCharArray()){
            hash[f]++;
        }
        int left=0;
        int right=0;
        int minlen=Integer.MAX_VALUE;
        int n=s.length();
        int m=t.length();
        int ct=0;
        int st=-1;
        while(right<n){
            char c=s.charAt(right);
            if(hash[c]>0){
                ct=ct+1;
            }
            hash[c]--;
            while(ct==m){
                if(right-left+1<minlen){
                    minlen=right-left+1;
                    st=left;
                }
                hash[s.charAt(left)]++;
                if(hash[s.charAt(left)]>0){
                    ct=ct-1;
                }
                left++;
            }
            right++;
        }
        if(st==-1){
            return "";
        }
        return s.substring(st,st+minlen);
    }
}
