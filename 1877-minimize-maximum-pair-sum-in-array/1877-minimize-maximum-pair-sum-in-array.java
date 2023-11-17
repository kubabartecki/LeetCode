class Solution {
    public int minPairSum(int[] nums) {
        int minMaxSumPairMAxMineSummax = 0;
        int minNum = Integer.MAX_VALUE;
        int maxNum = Integer.MIN_VALUE;
        int [] numCount = new int [100001];
        for (int num : nums) {
            // if is 1-2 ms faster than Math.min
            // but maybe it depends on the frequency of changes
            if (minNum > num) minNum = num;
            if (maxNum < num) maxNum = num;
            ++numCount[num];
        }

        while (minNum <= maxNum) {
            if (numCount[minNum] == 0) ++minNum;
            else if (numCount[maxNum] == 0) --maxNum;
            else {
                int sum = minNum + maxNum;
                if (minMaxSumPairMAxMineSummax < sum)
                    minMaxSumPairMAxMineSummax = sum;
                --numCount[minNum];
                --numCount[maxNum];
            }
        }
        
        return minMaxSumPairMAxMineSummax;
    }
}