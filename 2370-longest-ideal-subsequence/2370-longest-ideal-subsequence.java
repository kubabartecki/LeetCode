class Solution {
    public int longestIdealString(String s, int k) {
        int [] dp = new int [26];
        for (char letter : s.toCharArray()) {
            int letterIndex = letter - 'a';
            int max = 0;
            for(int i = Math.max(0, letterIndex - k);
                i <= Math.min(25, letterIndex + k);
                ++i
            ) {
                max = Math.max(max, dp[i] + 1);
            }
            dp[letterIndex] = max;
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
