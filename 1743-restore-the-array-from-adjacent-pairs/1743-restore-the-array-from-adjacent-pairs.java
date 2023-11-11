class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> neighbours = new HashMap<>();
        int pairsNum = adjacentPairs.length;

        for (int [] pair : adjacentPairs) {
            neighbours.putIfAbsent(pair[0], new ArrayList<>());
            neighbours.putIfAbsent(pair[1], new ArrayList<>());
            neighbours.get(pair[0]).add(pair[1]);
            neighbours.get(pair[1]).add(pair[0]);
        }
        int [] original = new int [pairsNum + 1];
        for (Map.Entry<Integer, List<Integer>> numAdj : neighbours.entrySet()) {
            if (numAdj.getValue().size() < 2) {
                original[0] = numAdj.getKey();
                original[1] = numAdj.getValue().get(0);
                break;
            }
        }
        
        for (int i = 2; i <= pairsNum; ++i) {
            List<Integer> numAdj = neighbours.get(original[i - 1]);
            original[i] = numAdj.get(0) == original[i - 2] ?
                numAdj.get(1) : numAdj.get(0);
        }
        return original;
    }
}