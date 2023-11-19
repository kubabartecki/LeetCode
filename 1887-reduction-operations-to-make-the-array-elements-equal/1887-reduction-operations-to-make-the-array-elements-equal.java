class Solution {
    public int reductionOperations(int[] nums) {
        int operations = 0;
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = n - 1; i > 0; --i) {
            if (nums[i] != nums[i - 1]) {
                operations += n - i;
            }
        }
        return operations;
    }
}