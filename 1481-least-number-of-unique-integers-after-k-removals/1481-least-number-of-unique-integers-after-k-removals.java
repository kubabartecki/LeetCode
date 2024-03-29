class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        int freq[] = new int[100_001];
        for (int num: arr) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for (int c: count.values()) {
            ++res;
            ++freq[c];
        }
        for (int i = 1; i < 100_001; ++i) {
            if (freq[i] == 0) {
                continue;
            }
            int availablePoints = Math.min(k, freq[i] * i);
            k -= availablePoints;
            res -= availablePoints / i;
            if (k == 0) {
                break;
            }
        }
        return res;
    }
}
