class Solution {
    public boolean isPowerOfFour(int n) {
        while(n > 1 && (n & 0b11) == 0){
            n >>= 2;
        }
        return n == 1 ? true : false;
    }
}