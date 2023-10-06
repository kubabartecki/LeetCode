class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int max1 = 0, counter1 = 0;
        int max2 = 0, counter2 = 0;

        for( int num: nums){
            if(num == max1) counter1++;
            else if (num == max2) counter2++;
            else if (counter1 == 0) {
                max1 = num;
                counter1 = 1;
            } else if (counter2 == 0) {
                max2 = num;
                counter2 = 1;
            } else {
                counter1--;
                counter2--;
            }
        }

        counter1 = counter2 = 0;
        for (int num : nums) {
            if(num == max1) counter1++;
            else if(num == max2) counter2++;
        }
        List<Integer> result = new ArrayList<>();
        int treshold = nums.length / 3;
        if(counter1 > treshold) result.add(max1);
        if(counter2 > treshold) result.add(max2);
        return result;
    }
}