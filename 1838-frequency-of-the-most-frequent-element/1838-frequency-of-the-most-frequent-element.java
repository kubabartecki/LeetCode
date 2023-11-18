class Solution {
    public int maxFrequency(int[] nums, int k) {
        int l = 0, r = 0;
        int result = 1;
        int windowSum = 0;
        Arrays.sort(nums);

        while (r < nums.length) {
            windowSum += nums[r];
            int windowSize = r - l + 1;

            while (nums[r] * windowSize - windowSum > k) {
                windowSum -= nums[l++];
                --windowSize;
            }
            result = Math.max(result, windowSize);
            ++r;
        }
        return result;
    }
}