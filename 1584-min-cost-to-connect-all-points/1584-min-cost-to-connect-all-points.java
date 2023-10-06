class Solution {
    public static int manhattan_dist(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }

    public int minCostConnectPoints(int[][] points) {
        int sum = 0;
        Map<Integer, List<List<Integer>>> adj = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0])); // comparing by cost
        for (int i = 0; i < points.length; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int i = 0; i < points.length; i++) {     // This could be in Prims but to clear out
            int[] points1 = points[i];
            for (int j = i + 1; j < points.length; j++) {
                int distance = manhattan_dist(points1, points[j]);
                adj.get(i).add(List.of(distance, j));
                adj.get(j).add(List.of(distance, i));
            }
        }

        // Prim
        minHeap.add(new int[]{0, 0}); // first point in points array
        while (visited.size() != points.length) {
            int[] minCost = minHeap.poll();
            int cost = minCost[0];
            int point = minCost[1];
            if (visited.contains(point)) continue;
            sum += cost;
            visited.add(point);
            for (List<Integer> neiList :
                    adj.get(point)) {
                if (!visited.contains(neiList.get(1)))
                    minHeap.add(new int[]{neiList.get(0), neiList.get(1)});
            }
        }
        return sum;
    }
}