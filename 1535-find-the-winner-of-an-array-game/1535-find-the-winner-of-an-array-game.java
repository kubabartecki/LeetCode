class Solution {
    public int getWinner(int[] arr, int k) {
        int winner = arr[0];
        int winCount = 0;
        int curr = 1;
        while (winCount < k && curr < arr.length) {
            if (winner > arr[curr]) ++winCount;
            else {
                winner = arr[curr];
                winCount = 1;
            }
            ++curr;
        }
        return winner;
    }
}