class Solution {
    public int trap(int[] height) {
        int left=0;
        int right=0;
        int i=0;
        int j=height.length-1;
        int area=0;
        while(i<j){
            left=Math.max(left,height[i]);
            right=Math.max(right,height[j]);
            if(left<right){
                area+=(left-height[i]);
                i++;
            }
            else{
                area+=(right-height[j]);
                j--;
            }
        }
        return area;
    }
}
