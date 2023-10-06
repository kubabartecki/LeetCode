public class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] minMaxEffort = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                minMaxEffort[i][j] = Integer.MAX_VALUE;
            }
        }
        minMaxEffort[0][0] = 0;

        // edges to check // [effort, x ,y] list
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        minHeap.add(new int[]{0, 0, 0});

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while(!minHeap.isEmpty()){
            int[] top = minHeap.poll();
            int effort = top[0], x = top[1], y = top[2];

            // some node could add better proposal in the meanwhile
            if(effort > minMaxEffort[x][y]) continue;

            // we can say this is end condition coz efforts are sorted in priority queue,
            // so first we get the smallest efforts
            // and if u wonder there could be other possible ways, they HAVE 100% bigger effort coz queue is sorted
            if(x == rows - 1 && y == cols - 1) return effort;

            for (int[] direction:
                 directions) {
                int nx = x + direction[0], ny = y + direction[1];
                if(nx >= 0 && ny >= 0 && nx < rows && ny < cols){
                    int new_effort = Math.max(effort, Math.abs(heights[x][y] - heights[nx][ny]));
                    if(new_effort < minMaxEffort[nx][ny]){
                        minHeap.add(new int[]{new_effort, nx, ny});
                        minMaxEffort[nx][ny] = new_effort;
                    }
                }
            }
        }
        return -1;
    }
}