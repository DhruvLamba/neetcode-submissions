class Solution {
    public int maxProfit(int[] prices) {
        int maxp=0;
        int min=prices[0];
        for(int sell: prices){
            maxp=Math.max(maxp,sell-min);
            min=Math.min(min,sell);
        }
        return maxp;
            
    }
}

