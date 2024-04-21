class Solution {
    private int [] root;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        root = new int [n];
        for (int i = 0; i < n; ++i) {
            root[i] = i;
        }
        for (int [] edge : edges) {
            union(edge[0], edge[1]);
        }
        return find(source) == find(destination);
    }

    private int find (int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    private void union (int x, int y) {
        x = find(x);
        y = find(y);
        root[y] = x;
    }
}
