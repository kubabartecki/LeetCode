class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n < 1) {
            return false;
        }
        return Integer.bitCount(n) == 1;
    }
}
