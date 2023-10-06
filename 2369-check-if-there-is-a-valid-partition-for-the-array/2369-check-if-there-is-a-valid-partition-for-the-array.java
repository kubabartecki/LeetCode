class Solution {
    public boolean validPartition(int[] nums) {
            if (nums.length < 2) return false;
        else if (nums.length == 2) return nums[0] == nums[1];
        // first index added just to begin alg
        boolean[] validCombination = new boolean[nums.length + 1];
        validCombination[0] = true;
        for (int i = 2; i < nums.length; ++i) {
            if (!validCombination[i - 2]) continue;
            if (nums[i - 2] == nums[i - 1]) {
                validCombination[i] = true;
                if (nums[i - 1] == nums[i]) {
                    validCombination[i + 1] = true;
                }
            }
            if (nums[i - 2] + 1 == nums[i - 1] && nums[i - 1] + 1 == nums[i]) {
                validCombination[i + 1] = true;
            }
        }
        if (nums[nums.length - 2] == nums[nums.length - 1]
                && validCombination[nums.length - 2])
            validCombination[nums.length] = true;
        return validCombination[nums.length];
    }
}