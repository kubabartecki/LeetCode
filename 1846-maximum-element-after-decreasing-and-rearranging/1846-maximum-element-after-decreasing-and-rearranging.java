class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        int result = 0;
        int [] numCount = new int [n];
        for (int i = 0; i < n; ++i) {
            ++numCount[Math.min(arr[i] - 1, n - 1)];
        }

        for (int i = n - 1; i > 0; --i) {
            if (numCount[i] > 0) {
                ++result;
                numCount[i - 1] += numCount[i] - 1;
            }
        }
        
        return result + (numCount[0] > 0 ? 1 : 0);

    }
}