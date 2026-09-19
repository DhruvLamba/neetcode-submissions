class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> seen=new Stack<>();
        int[] res=new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            if(seen.isEmpty()){
                seen.push(i);
                continue;
            }
            while(!seen.isEmpty() && temperatures[i]>temperatures[seen.peek()] ){
                res[seen.peek()]=i-seen.peek();
                seen.pop();
            }
            seen.push(i);
        }
        return res;
    }
}
