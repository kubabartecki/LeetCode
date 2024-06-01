class Solution {
    public int[] singleNumber(int[] nums) {
        int [] result = new int [2];
        int diff = 0;
        
        // XOR all nums, so the doubled ones will disappear
        // so the remaining part will contain (resul1 XOR result2)
        for (int num : nums) {
            diff ^= num;
        }

        // now in diff we have all bits, on which result1 and result 2 are different
        // what we can do is get one bit from diff
        // we can get e.g. first one from the right
        // example:
        // when diff = 010100
        // 1. negate all bits -> 101011
        // 2. add one -> 101011 + 000001 = 101100 (which is de facto -diff)
        // 3. apply AND operation -> 010100 & 101100 -> 000100
        diff &= -diff;
        
        // now when we found some 1 bit that is different on numbers that we search
        // we can separate our search in 2 groups:
        // 1. numbers that have that bit NOT SET
        // 2. numbers that have that bit SET
        // now in each group we will have only one number that not repeats twice
        // so XOR on each group should give result numbers
        for (int num : nums) {
            if ((num & diff) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }

        return result;
    }
}
