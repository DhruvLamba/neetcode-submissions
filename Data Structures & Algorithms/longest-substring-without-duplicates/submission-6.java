class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> seen=new HashMap<>();
        int start=0;
        int maxlen=0;
        for(int end=0;end<s.length();end++){
            char c=s.charAt(end);
            if(seen.containsKey(c) && seen.get(c)>=start){
                start=seen.get(c)+1;
            }
            seen.put(c, end);
            maxlen=Math.max(maxlen,end-start+1);
        }
        return maxlen;
    }
}
