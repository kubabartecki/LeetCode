class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder strB = new StringBuilder();
        for (int i = 0; i < nums.length; ++i) {
            strB.append((nums[i].charAt(i) == '0')? "1" : "0"); 
        }
        return strB.toString();
    }
}