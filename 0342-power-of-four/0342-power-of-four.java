class Solution {
    public boolean isPowerOfFour(int n) {
        if(n <= 0) return false;
        while((n & 0b11) == 0){
            n >>= 2;
        }
        return n == 1 ? true : false;
    }
}