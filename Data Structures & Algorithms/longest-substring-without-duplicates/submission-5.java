class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        int i=0; 
        int count=0;
        while(i<s.length()){
            int track=0;
            Set<Character> seen=new HashSet<>();
            int j=i;
            while(j<s.length()){
                if(!seen.contains(s.charAt(j))){
                    seen.add(s.charAt(j));
                    track++;
                    j++;
                }
                else{
                    break;
                }
            }
            count=Math.max(count,track);;
            i++;
        }
        return count;
    }
}
