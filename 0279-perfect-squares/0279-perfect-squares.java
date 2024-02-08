class Solution {
    public int numSquares(int n) {
        List<Integer> perfectSquares = new ArrayList<>();
        int perfectSquare = 0; // sth less than 1
        for (int i = 1; perfectSquare < n; ++i) {
            perfectSquare = i * i;
            perfectSquares.add(perfectSquare);
        }
        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int pS: perfectSquares) {
            for (int i = 0; i <= n; ++i) {
                if (i + pS <= n) {
                    dp[i + pS] = Math.min(dp[i + pS], dp[i] + 1);
                }
            }
        }
        return dp[n];
    }
}
