class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int [] rootHunt = new int [n];
        int root = -1;

        for(int i = 0; i < n; ++i){
            if(leftChild[i] != -1) rootHunt[leftChild[i]]++;
            if(rightChild[i] != -1) rootHunt[rightChild[i]]++;
        }

        for(int i = 0; i < n; ++i){
            if(rootHunt[i] == 0){
                if(root != -1) return false;
                root = i;
            } else if(rootHunt[i] > 1) return false;
        }
        if(root == -1) return false;

        Queue<Integer> nodes = new LinkedList<>();
        boolean [] visited = new boolean [n];
        nodes.offer(root);
        
        while(!nodes.isEmpty()){
            int node = nodes.poll();
            if(visited[node]) return false;
            visited[node] = true;
            if(leftChild[node] != - 1) nodes.offer(leftChild[node]);
            if(rightChild[node] != - 1) nodes.offer(rightChild[node]);
        }
        int nodeCounter = 0;
        for(boolean node : visited){
            if(node) nodeCounter++;
        }

        return nodeCounter == n;
    }
}