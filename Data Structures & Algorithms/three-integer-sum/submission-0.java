class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer, Integer> map=new HashMap<>();
        List<List<Integer>> main=new ArrayList<>();
        Set<String> seen = new HashSet<>();
        for(int k=0;k<nums.length;k++){
            map.put(nums[k],k);
        }
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int third = 0 - nums[i] - nums[j];
                if(map.containsKey(third) && map.get(third)!=i && map.get(third)!=j){
                    List<Integer> l=new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(third);
                    Collections.sort(l);
                    String k=l.toString();
                    if(!seen.contains(k)){
                        seen.add(k);
                        main.add(l);
                    }
                   
                }
            }
        }
        return main;
    }
}
