class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int MAX_NUMBER = 1000;
        int [] counter = new int [MAX_NUMBER + 1]; 
        for (int num : nums1) {
            ++counter[num];
        }
        List<Integer> resultList = new ArrayList<>();
        for (int num : nums2) {
            if (counter[num] > 0) {
                resultList.add(num);
                --counter[num];
            }
        }

        return resultList.stream().mapToInt(Number::intValue).toArray();
    }
}
