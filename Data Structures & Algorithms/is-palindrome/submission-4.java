class Solution {
    public boolean isPalindrome(String s) {
        if(s.length()==0){
            return true;
        }
        int i=0;
        int j=s.length()-1;
        while(i<j){
            while(i<j && !alpha(s.charAt(i))){
                i++;
            }
            while(j>i && !alpha(s.charAt(j))){
                j--;
            }                   if(Character.toLowerCase(s.charAt(i))!=Character.toLowerCase(s.charAt(j))){
                return false;
            }
            i++;
            j--;
        }
        return true;       

    }

    public boolean alpha(char c){
        return(c>='A' && c<='Z' || c>='a' && c<='z' || c>='0' && c<='9');
    }

}