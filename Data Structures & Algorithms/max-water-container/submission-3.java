class Solution {
    public int maxArea(int[] heights) {
        int largest=Integer.MIN_VALUE;
        int i=0;
        int j=heights.length-1;
        while(i<j){
            int area=Math.min(heights[i],heights[j])*(j-i);
            if(heights[i]>heights[j]){
                j--;
            }
            else{
                i++;
            }
            largest=Math.max(largest,area);
        }
        return largest;
    }
}
