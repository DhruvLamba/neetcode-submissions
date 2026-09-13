class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] one=s1.toCharArray();
        Arrays.sort(one);
        String main=new String(one);
        int left=0;
        for(int right=s1.length()-1;right<s2.length();right++){
            char[] word=s2.substring(left,right+1).toCharArray();
            Arrays.sort(word);
            String sorted=new String(word);
            if(sorted.equals(main)){
                return true;
            }
            else{
                left++;
            }
        }
        return false;
    }
}
