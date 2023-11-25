class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int timeForCollecting = 1;
        // indexes of last house visited by M P G
        int [] lastPick = new int [3];
        int result = 0;

        Map<Character, Integer> materialToIndex = new HashMap<>();
        materialToIndex.put('M', 0);
        materialToIndex.put('P', 1);
        materialToIndex.put('G', 2);

        for (int i = 0; i < garbage.length; ++i) {
            String houseGarbage = garbage[i];
            for (char g : houseGarbage.toCharArray()) {
                ++result;
                lastPick[materialToIndex.get(g)] = i;
            }
        }
        // prefix sum for travel time
        for (int i = 0; i < travel.length - 1; ++i) {
            travel[i + 1] += travel[i];
        }
        // add travel time
        for (int i = 0; i < 3; ++i) {
            if (lastPick[i] > 0) {
                result += travel[lastPick[i] - 1];
            }
        }
        return result;
    }
}