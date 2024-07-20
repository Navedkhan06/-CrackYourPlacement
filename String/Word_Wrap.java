class Solution
{
  public int solveWordWrap (int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE); 
        dp[n] = 0;
        for(int i=n-1; i>=0; i--) {
            int sum = 0;
            for(int j=i; j<n && sum + nums[j]<=k; j++) {
                sum += nums[j];
                int spaces = (j != n-1) ? k-sum : 0;
                dp[i] = Math.min(dp[i], spaces*spaces+dp[j+1]);
                sum++;
            }
        } 
        return dp[0];
    }
}