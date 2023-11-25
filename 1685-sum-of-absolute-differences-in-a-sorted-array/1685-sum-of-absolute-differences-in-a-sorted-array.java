class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int [] result = new int [n];
        for (int i = 1; i < n; ++i) {
            result[i] = result[i - 1] + i * (nums[i] - nums[i - 1]);
        }
        int sum = 0;
        for (int i = n - 2; i >= 0 ; --i) {
            sum += (n - i - 1) * (nums[i + 1] - nums[i]);
            result[i] += sum;
        }
        return result;
    }
}