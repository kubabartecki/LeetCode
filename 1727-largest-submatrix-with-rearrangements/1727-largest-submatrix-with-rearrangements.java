class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int rowLen = matrix[0].length;
        for (int i = 1; i < matrix.length; ++i) {
            for (int j = 0; j < rowLen; ++j) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }
        }
        int result = 0;
        for (int [] row : matrix) {
            Arrays.sort(row);
            for (int j = 0; j < rowLen; ++j) {
                int newSubMatrix = row[j] * (rowLen - j);
                if (result < newSubMatrix) {
                    result = newSubMatrix;
                }
            }
        }
        return result;
    }
}