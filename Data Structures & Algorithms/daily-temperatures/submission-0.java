class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res=new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            int j=i+1;
            int k=1;
            while(j<temperatures.length){
                if(temperatures[j]>temperatures[i]){
                    res[i]=k;
                    break;
                }
                else{
                    res[i]=0;
                    k++;
                    j++;
                }
            }
        }
        return res;
    }
}
