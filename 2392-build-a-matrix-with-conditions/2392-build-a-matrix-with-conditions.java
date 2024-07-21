class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> rowOrder = topologicalSort(k, rowConditions);
        List<Integer> colOrder = topologicalSort(k, colConditions);
        if (rowOrder.isEmpty() || colOrder.isEmpty()) {
            return new int [0][0];
        }

        int [] num2rowIndex = new int [k + 1];
        int [] num2colIndex = new int [k + 1];
        for (int i = 0; i < k; ++i) {
            num2rowIndex[rowOrder.get(i)] = i;
            num2colIndex[colOrder.get(i)] = i;
        }

        int [][] matrix = new int [k][k];
        for (int i = 1; i <= k; ++i) {
            matrix[num2rowIndex[i]][num2colIndex[i]] = i;
        }
        return matrix;
    }

    private List<Integer> topologicalSort(int k, int[][] conditions) {
        // returns an empty array if it is not possible to form order

        // prepare conditoins structure
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int [] condition : conditions) {
            graph.computeIfAbsent(condition[0], key -> new ArrayList<>())
                .add(condition[1]);
        }

        List<Integer> order = new ArrayList<>();
        
        // to avoid visiting node multiple times
        Set<Integer> visited = new HashSet<>();
        // to avoid graph cycles (case where conditions are inconsitent)
        Set<Integer> inUse = new HashSet<>();
        for (int i = 1; i <= k; ++i) {
            if (!dfs(i, graph, order, visited, inUse)) {
                return new ArrayList<>();
            }
        }

        Collections.reverse(order);
        return order;
    }

    private boolean dfs (int node, Map<Integer, List<Integer>> graph,
        List<Integer> order, Set<Integer> visited, Set<Integer> inUse) {
        if (inUse.contains(node)) {
            return false;
        }
        if (visited.contains(node)) {
            return true;
        }

        inUse.add(node);
        visited.add(node);

        for (int neighbour : graph.getOrDefault(node, new ArrayList<>())) {
            if (!dfs(neighbour, graph, order, visited, inUse)) {
                return false;
            }
        }
        order.add(node);

        inUse.remove(node);
        return true;
    }
}
