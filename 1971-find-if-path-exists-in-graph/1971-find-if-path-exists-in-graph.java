class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> connections = new HashMap<>();
        List<Integer> toVisit = new ArrayList<>();
        List<Integer> visited = new ArrayList<>();

        for (int [] edge : edges) {
            connections.putIfAbsent(edge[0], new ArrayList<Integer>());
            connections.putIfAbsent(edge[1], new ArrayList<Integer>());
            connections.get(edge[0]).add(edge[1]);
            connections.get(edge[1]).add(edge[0]);
        }

        toVisit.add(source);
        while (!toVisit.isEmpty()) {
            int vertice = toVisit.remove(0);
            if (visited.contains(vertice)) {
                // in the meanwhile other vertice could check that one
                continue;
            }
            visited.add(vertice);
            if (vertice == destination) {
                return true;
            }
            toVisit.addAll(
                connections.getOrDefault(vertice, Collections.emptyList()).stream()
                    .filter(a -> !visited.contains(a)).collect(Collectors.toList())
            );
        }
        return false;
    }
}
