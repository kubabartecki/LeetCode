class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int max = 0;
        for (int num : set) {
            if (set.contains(num - 1)) {
                continue;
            }
            int counter = 1;
            while (set.contains(++num)) {
                ++counter;
            }
            max = max < counter ? counter : max;
        }

        return max;
    }
}
