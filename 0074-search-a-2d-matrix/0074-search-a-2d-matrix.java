class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean isThere = false;
        int m = matrix.length;
        int n = matrix[0].length;
        search1:
        for (int[] ints : matrix) {
            if (target > ints[n - 1]) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (target == ints[j]) {
                    isThere = true;
                    break search1;
                }
            }
        }
        return isThere;
    }
}