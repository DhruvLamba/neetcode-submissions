class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> ans=new HashMap<>();
        int res[]={-1,-1};
        for(int i=0;i<nums.length;i++){
            ans.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int diff=target-nums[i];
            if(ans.containsKey(diff) && ans.get(diff)!=i){
                res[0]=i;
                res[1]=ans.get(diff);
                return res;
            }
        }
        return res;
    }
}
