public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> main= new HashMap<>();
        for(String k:strs){
            String res=anagram(k);
            main.putIfAbsent(res,new ArrayList<>());
            main.get(res).add(k);
        }
        return new ArrayList<>(main.values());
        
    }
    public String anagram(String s){
        int[] count =new int[26];
        for(char t:s.toCharArray()){
            count[t-'a']++;
        }
        return Arrays.toString(count);
    }
}