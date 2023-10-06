class Solution {
    public int singleNumber(int[] nums) {
        int found = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (map.get(num) == null) {
                map.put(num, 1);
            }
            else{
                map.put(num, map.get(num) + 1);
            }
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue() == 1){
                found = entry.getKey();
                break;
            }
        }
        return found;
    }
}