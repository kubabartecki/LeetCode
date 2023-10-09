class Solution {
    public int[] searchRange(int[] nums, int target) {
        int leftIndex = binSearch(nums, target, true);
        if(-1 == leftIndex) return new int[]{-1, -1};

        int rightIndex = binSearch(nums, target, false);
        return new int[]{leftIndex, rightIndex};
    }

    public int binSearch(int [] nums, int target, boolean findLeft){
        int index = -1;
        int l = 0, r = nums.length - 1;

        while( l <= r ){
            int mid = l + (r - l) / 2;
            if(nums[mid] == target){
                index = mid;
                if(findLeft){
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else if(nums[mid] < target){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return index;
    }
}