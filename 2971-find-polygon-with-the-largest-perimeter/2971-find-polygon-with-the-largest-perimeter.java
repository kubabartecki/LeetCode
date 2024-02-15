class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long maxPerimeter = -1;
        long shorterSidesSum = nums[0];
        for (int i = 1; i < nums.length - 1; ++i) {
            shorterSidesSum += nums[i];
            if (shorterSidesSum > nums[i + 1]) {
                maxPerimeter = shorterSidesSum + nums[i + 1];
            }
        }
        return maxPerimeter;
    }
}
