class Solution {
    public int integerBreak(int n) {
        int [] dp = new int [n + 1]; // start from 1
        dp[1] = 1;
        dp[2] = 1;

        for(int i = 2; i <= n; ++i){
            for(int j = i; j >= 1; --j){
                if(i + j <= n){
                    dp[i + j] = Math.max(dp[i + j], Math.max(dp[i], i) * Math.max(j, dp[j]));
                }
            }
        }
        return dp[n];
        
    }
}