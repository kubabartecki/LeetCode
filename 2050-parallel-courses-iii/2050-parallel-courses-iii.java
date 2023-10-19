class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        Map<Integer, List<Integer>> routes = new HashMap<>();
        int [] prevNodeCount = new int [n + 1];
        for(int [] relation : relations){
            routes.computeIfAbsent(relation[0], k -> new ArrayList<>()).add(relation[1]);
            prevNodeCount[relation[1]]++;
        }

        int [] timeSum = new int [n + 1];
        System.arraycopy(time, 0, timeSum, 1, n);
        Queue<Integer> queue = new LinkedList();

        for(int i = 1; i <= n; ++i){
            if(prevNodeCount[i] == 0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int starting = queue.poll();
            if(routes.containsKey(starting)){
                for(int dest : routes.get(starting)){
                    timeSum[dest] = Math.max(timeSum[dest], timeSum[starting] + time[dest - 1]);
                    prevNodeCount[dest]--;
                    if(prevNodeCount[dest] == 0 && routes.containsKey(dest)) queue.add(dest);
                }
            }
        }

        int max = timeSum[0];
        for(int maxTime : timeSum){
            max = Math.max(max, maxTime);
        }
        return max;
    }
}