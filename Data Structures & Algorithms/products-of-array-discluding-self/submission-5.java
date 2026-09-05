class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res=new int[nums.length];
        int count=0;
        int total=1;
        for(int k=0;k<nums.length;k++){
            if(nums[k]!=0){
                total*=nums[k];
            }
            else{
                count++;
            }
        }
        if(count>=2){
            return res;
        }
        for(int i=0;i<nums.length;i++){
            if(count>0){
                if(nums[i]==0){
                    res[i]=total;
                }
                else{
                    res[i]=0;
                }
            }
            else{res[i]=total/nums[i];}
            
        }
        return res;
    }
} 
