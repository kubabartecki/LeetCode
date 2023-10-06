class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int [] result = new int[nums.length];
        int face = 0;
        int back = nums.length - 1;

        for (int num :
                nums) {
            if(num % 2 == 0){
                result[face++] = num;
            } else {
                result[back--] = num;
            }
        }
        return result;
    }
}