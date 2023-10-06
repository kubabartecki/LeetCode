class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(k == 0 || nums.length == 0) return 0;
        PriorityQueue<Integer> largests = new PriorityQueue<>();
        for (int i = 0; i < k; ++i) {
            largests.offer(nums[i]);
        }
        for (int i = k; i < nums.length; ++i) {
            if (nums[i] > largests.peek()) {
                largests.poll();
                largests.offer(nums[i]);
            }
        }
        return largests.peek();
    }
}