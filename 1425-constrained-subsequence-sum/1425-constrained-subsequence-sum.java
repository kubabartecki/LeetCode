class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        // maxSum can't be zero because array can contain all negative values
        // so we get random number f.e at index 0
        // if we come across greater value we will change it
        int maxSum = nums[0];

        // it has decreasing order of sums
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            // we add to the current value potential max sum of elements required to come here
            // this means when nums = 4 | 4 | -10 | 6 , k = 1
            // collecting -10 is not optimal, but necessary to go to 6 and conduct calculations for it
            // this means that, if after this 6 would be greater values that compensates this -10, it will be worth it
            // in other case if after 6 won't be enough positive values -> we take max value from all dp elements
            // so we do not have to include this -10, just take sum at second 4 index.
            nums[i] += !dq.isEmpty() ? nums[dq.peek()] : 0;
            maxSum = Math.max(maxSum, nums[i]);

            while (!dq.isEmpty() && (i - dq.peek() >= k || nums[i] >= nums[dq.peekLast()])) {
                // if in queue are smaller sums than value in single current value, get rid of them
                if (nums[i] >= nums[dq.peekLast()]) dq.pollLast();

                // condition 'i - dq.peekFirst() >= k' is satisfied
                // yes, the first index in queue will have the smallest index
                // this is because we are deleting smaller sums in condition above
                // and what stay in queue are indices with greater sums
                else dq.poll();
            }

            if (nums[i] > 0) {
                // we know that we deleted nums[i] >= nums[dq.peekLast()] elements
                // so nums[i] will contain the smaller value now
                dq.offerLast(i);
            }
        }
        return maxSum;
    }
}