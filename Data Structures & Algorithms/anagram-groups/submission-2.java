public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> main= new HashMap<>();
        for(String s:strs){
            char[] sorted= s.toCharArray();
            Arrays.sort(sorted);
            String add=new String(sorted);
            main.putIfAbsent(add,new ArrayList<>());
            main.get(add).add(s);
        }
        return new ArrayList<>(main.values());
    }
}