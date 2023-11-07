class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        for (int i = 0; i < dist.length; ++i) {
            dist[i] = dist[i] / speed[i] + (dist[i] % speed[i] == 0? 0 : 1);
            speed[i] = 0;
        }

        for (int time : dist) {
            if (time < dist.length) ++speed[time]; 
        }
        
        for (int i = 1; i < dist.length; ++i) {
            speed[i] += speed[i - 1];
            if(speed[i] > i) return i;
        }
        return dist.length;
    }
}