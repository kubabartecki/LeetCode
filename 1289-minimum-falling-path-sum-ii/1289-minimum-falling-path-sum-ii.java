class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n - 1; ++i) {
            int min1 = 20_000;
            int min1Index = 0;
            int min2 = 20_000;
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] < min1) {
                    min2 = min1;
                    min1 = grid[i][j];
                    min1Index = j;
                } else if (grid[i][j] < min2) {
                    min2 = grid[i][j];
                }
            }
            for (int j = 0; j < n; ++j) {
                if (j == min1Index) {
                    grid[i + 1][j] += min2;
                    continue;
                }
                grid[i + 1][j] += min1;
            }
        }
        return Arrays.stream(grid[n - 1]).min().getAsInt();
    }
}
