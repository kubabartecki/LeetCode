class Solution {
    private double[][] glasses = new double[100][100]; // could be only 2 rows (prev and current) !
    public double champagneTower(int poured, int query_row, int query_glass) {
        glasses[0][0] = poured;
        for (int i = 0; i < query_row; i++) {
            for (int j = j = Math.max(0, query_glass - (query_row - i)); j < i + 1 && j < query_glass + 1; j++) {
                double toFall = Math.max(glasses[i][j] - 1.0, 0.0);
                double half = toFall / 2;
                glasses[i + 1][j] += half;
                glasses[i + 1][j + 1] += half;
            }
        }
        return Math.min(glasses[query_row][query_glass], 1.0);
    }
}