class Solution {
    public int maxProfit(int[] prices) {
       
        
        int totalProfit = 0;
        int left = 0;

        for (int i = 1; i < prices.length; i++){
             int right = i;
             int currProfit = 0;

             if (prices[right] > prices[left]){
                currProfit = prices[right] - prices[left];
                totalProfit = Math.max(totalProfit, currProfit);
             } else {
                left = right;
             }

            }
        return totalProfit;
    }
}