class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        Map<Integer, List<Integer>> buses = new HashMap<>();
        Map<Integer, Boolean> usedBus = new HashMap<>();
        
        for (int i = 0; i < routes.length; ++i) {
            usedBus.putIfAbsent(i, false);
            for (int j = 0; j < routes[i].length; ++j) {
                buses.putIfAbsent(routes[i][j], new ArrayList<>());
                buses.get(routes[i][j]).add(i);
            }
        }

        Queue<Integer> nextStop = new LinkedList<>();
        nextStop.offer(source);
        
        int busesNum = 0;
        while (!nextStop.isEmpty()) {
            int size = nextStop.size();
            while (size-- > 0) {
                int stop = nextStop.poll();
                if (stop == target) return busesNum;
                for (int bus : buses.get(stop)) {
                    if (usedBus.get(bus)) continue;
                    else {
                        for (int busStop : routes[bus]) {
                            nextStop.offer(busStop);
                        }
                        usedBus.put(bus, true);
                    }
                }
            }
            ++busesNum;
        }
        return -1;
    }
}