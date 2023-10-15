class Solution {
    public int numWays(int steps, int arrLen) {
        int range = Math.min(arrLen, steps / 2 + 1);
        int [][] dp = new int [steps + 1][range];

        int mod = 1_000_000_007;
        dp[0][0] = 1;

        for(int i = 1; i <= steps; ++i){
            for(int j = 0; j < range; ++j){
                // we can reach current place in 3 ways
                // stay
                dp[i][j] = dp[i - 1][j];
                // move right from prev place
                if(j > 0) dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % mod;
                // move left from prev place
                if(j < range - 1)  dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % mod;
            }
        } 
        return dp[steps][0];
    }
}