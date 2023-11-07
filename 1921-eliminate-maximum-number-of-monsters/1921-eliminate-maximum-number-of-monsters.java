class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        for (int i = 0; i < dist.length; ++i) {
            dist[i] = dist[i] / speed[i] + (dist[i] % speed[i] == 0? 0 : 1);
        }
        Arrays.sort(dist);

        for (int i = 0; i < dist.length; ++i) {
            if(dist[i] == i) return i;
        }
        return dist.length;
    }
}