class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int low = prices[0];

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < low) {
                low = prices[i];
            }

            if (prices[i] - low > 0) {
                profit += prices[i] - low;
                low = prices[i];
            }
        }

        return profit;
    }
}