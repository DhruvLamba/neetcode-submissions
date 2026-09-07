class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
        {
            return false;
        }
        int[] count=new int[26];
        for(char i:s.toCharArray()){
            count[i -'a']++;
        }
        for(char j:t.toCharArray()){
            count[j -'a']--;
        }
        for(int val:count){
            if(val!=0){
                return false;
            }
        }
        return true;
    }
}
