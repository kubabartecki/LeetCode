class Solution {
    public int getWinner(int[] arr, int k) {
        int winnerIndex = 0;
        int winCount = 0;
        int curr = 0;
        while (winCount < k && winCount < arr.length - 1) {
            if (curr == winnerIndex) ++curr;
            curr %= arr.length;
            if (arr[winnerIndex] > arr[curr]) ++winCount;
            else {
                winnerIndex = curr;
                winCount = 1;
            }
            ++curr;
        }
        return arr[winnerIndex];
    }
}