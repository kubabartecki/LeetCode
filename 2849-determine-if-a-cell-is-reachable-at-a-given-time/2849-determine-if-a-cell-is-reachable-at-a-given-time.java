class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int xDist = Math.abs(fx - sx);
        int yDist = Math.abs(fy - sy);
        int diagonals = Math.min(xDist, yDist);
        int remaining = (xDist - diagonals) + (yDist - diagonals);
        int minMoves = diagonals + remaining;
        if (minMoves > t) return false;
        else if (minMoves == t) return true;
        else if (minMoves + 1 == t) {
            if (minMoves > 0) return true;
            else return false;
        }
        return true;
    }
}