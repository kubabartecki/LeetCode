class KthLargest {
    private PriorityQueue<Integer> nums;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = new PriorityQueue<>(k);
        for (int num : nums) {
            this.add(num);
        }
    }
    
    public int add(int val) {
        nums.offer(val);
        if (nums.size() > k) {
            nums.poll();
        }
        return nums.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */