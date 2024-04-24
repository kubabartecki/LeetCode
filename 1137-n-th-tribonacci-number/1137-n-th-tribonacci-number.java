class Solution {
    public int tribonacci(int n) {
        int [] lastFib = {0, 1, 1};
        for (int i = 3; i <= n; ++i) {
            lastFib[i % 3] += lastFib[(i - 1) % 3] + lastFib[(i - 2) % 3];
        }
        return lastFib[n % 3]; 
    }
}
