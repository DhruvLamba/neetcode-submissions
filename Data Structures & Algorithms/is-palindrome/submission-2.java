class Solution {
    public boolean isPalindrome(String s) {
        if(s.length()==0){
            return true;
        }
        String result = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        char[] newar=result.toCharArray();
        int i=0;
        int j=newar.length-1;
        while(i<j){
            if(newar[i]!=newar[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}