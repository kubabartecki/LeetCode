class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> prevDiffs = new PriorityQueue<Integer>();
        for (int i = 0; i < heights.length - 1; ++i) {
            int heightDiff = heights[i + 1] - heights[i];
            if (heightDiff <= 0) {
                // jump off
                continue; 
            }
            prevDiffs.offer(heightDiff);
            if (prevDiffs.size() > ladders) {
                // out of ladders
                bricks -= prevDiffs.poll();
            }
            if (bricks < 0) {
                // not enought bricks
                return i;
            }
        }
        return heights.length - 1;
    }
}
