class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int islandsNum = 0;
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Queue<int[]> toDiscover = new ArrayDeque<>();

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                if (grid[i][j] == '1') {
                    ++islandsNum;
                    toDiscover.offer(new int [] {i, j});

                    while (!toDiscover.isEmpty()) {
                        int [] cords = toDiscover.poll();
                        
                        if (grid[cords[0]][cords[1]] == '0') {
                            // when there the same cords in the queue
                            // first one changes their grid to 0
                            // so no need to check again
                            continue;
                        }
                        grid[cords[0]][cords[1]] = '0';
                        for (int [] direction : directions) {
                            int nRow = cords[0] + direction[0];
                            int nCol = cords[1] + direction[1];
                            if (nRow < 0 || nCol < 0 || nRow >= rows || nCol >= columns ||
                                grid[nRow][nCol] == '0'
                            ) {
                                continue;
                            }
                            toDiscover.offer(new int [] {nRow, nCol});
                        }
                    }
                }
            }
        }
        return islandsNum;
    }
}
