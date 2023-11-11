class Graph {
    private List<List<int[]>> edges;

    public Graph(int n, int[][] edges) {
        this.edges = new ArrayList<>(n);

        for (int i = 0; i < n; ++i) {
            this.edges.add(new ArrayList<>());
        }
        for (int [] edge : edges) {
            addEdge(edge);
        }
    }
    
    public void addEdge(int[] edge) {
        int [] edgeArr = {edge[1], edge[2]};
        this.edges.get(edge[0]).add(edgeArr);
    }
    
    public int shortestPath(int node1, int node2) {
        PriorityQueue<int []> minPaths = new PriorityQueue<>(
            Comparator.comparingInt(k -> k[1])
        );
        int [] paths = new int [this.edges.size()];
        Arrays.fill(paths, Integer.MAX_VALUE);
        paths[node1] = 0;

        int [] rootNode = {node1, 0};
        minPaths.offer(rootNode);
        while (!minPaths.isEmpty()) {
            int [] currNode = minPaths.poll();

            // to skip if some other path have been found in the meanwhile
            if (currNode[1] > paths[currNode[0]])
                continue;

            if (currNode[0] == node2)
                return currNode[1];
            
            for (int [] node : this.edges.get(currNode[0])) {
                int newCost =  node[1] + currNode[1];
                
                if (newCost < paths[node[0]]) {
                    paths[node[0]] = newCost;
                    int [] nodeArr = {node[0], newCost};
                    minPaths.offer(nodeArr);
                }
            }
        }
        return -1;
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */