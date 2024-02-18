class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> prevDiffs = new PriorityQueue<Integer>();
        for (int i = 0; i < heights.length - 1; ++i) {
            int heightDiff = heights[i + 1] - heights[i];
            if (heightDiff <= 0) {
                // jump off
                continue; 
            } else if (ladders > 0) {
                // use all of the ladders if available
                --ladders;
                prevDiffs.offer(heightDiff);
                continue;
            } else if (!prevDiffs.isEmpty() && heightDiff > prevDiffs.peek()) {
                // exchange bricks to ladder for new bigger height
                bricks -= prevDiffs.poll();
                prevDiffs.offer(heightDiff);
            } else {
                // use bricks
                bricks -= heightDiff;
            }
            if (bricks < 0) {
                // not enought bricks
                return i;
            }
        }
        return heights.length - 1;
    }
}
