class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> mht = new ArrayList<>();
        if (n == 1) {
            mht.add(0);
            return mht;
        }
        List<Integer> [] tree = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            tree[i] = new ArrayList<Integer>();
        }
        int [] degree = new int [n];
        for (int [] edge : edges) {
            tree[edge[0]].add(edge[1]);
            tree[edge[1]].add(edge[0]);
            ++degree[edge[0]];
            ++degree[edge[1]];
        }

        Queue<Integer> leaves = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            if (degree[i] == 1) {
                leaves.offer(i);
            }
        }
        int used = 0;
        while (n - used > 2) {
            int oldSize = leaves.size();
            used += oldSize;
            for (int i = 0; i < oldSize; ++i) {
                int leaf = leaves.poll();
                for (int node : tree[leaf]) {
                    if (--degree[node] == 1) {
                        leaves.offer(node);
                    }
                }
            }
        }
        mht.addAll(leaves);
        return mht;
    }
}
