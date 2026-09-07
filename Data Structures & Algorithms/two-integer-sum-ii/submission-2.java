class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i=0;int j=numbers.length-1;
        while(i<j){
            int curr=numbers[i]+numbers[j];
            if(curr<target){
                i++;
            }
            if(curr>target){
                j--;
            }
            if(curr==target){
                return new int[]{i+1,j+1};
            }
        }
        return new int[0];
    }
}
