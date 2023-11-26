class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result = new ArrayList<>();
        for (int q = 0; q < l.length; ++q) {
            result.add(isSeqArithmetic(Arrays.copyOfRange(nums, l[q], r[q] + 1)));
        }
        return result;
    }

    private boolean isSeqArithmetic(int [] seq) {
        int max  = Integer.MIN_VALUE;
        int min  = Integer.MAX_VALUE;

        for (int num : seq) {
            if (max < num) max = num;
            if (min > num) min = num;
        }

        int n = seq.length;
        // to be certain that calculating r wont leave remainder
        // helpful in visited array to not go beyond indices 
        if ((max-min) % (n-1) != 0) {
            return false;
        }             
        int r = (max - min) / (n - 1);
        if (r == 0) return true;

        boolean [] visited = new boolean [n];
        for (int num : seq) {
            int diff = num - min;
            if (diff % r != 0) {
                return false;
            } else {
                int propIndex = diff / r;
                if (visited[propIndex]) {
                    return false;
                }
                visited[propIndex] = true;
            }
        }
        return true;
    }
}