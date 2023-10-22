class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int currMin = nums[k];
        int maxVal = nums[k];
        int l = k, r = k;
    
        while(l > 0 || r < n - 1){
            if(l == 0 || (r < n - 1 && nums[r + 1] > nums[l - 1])) ++r;
            else --l;

            currMin = Math.min(currMin, Math.min(nums[l], nums[r]));
            maxVal = Math.max(maxVal, currMin * (r - l + 1));
        }
        return maxVal;
    }
}