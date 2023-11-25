class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<List<Integer>> diagNums = new ArrayList<>();
        int n = nums.size();
        int elemsNum = 0;

        for (int i = 0; i < n; ++i) {
            int rowSize = nums.get(i).size();
            elemsNum += rowSize;
            while (diagNums.size() < rowSize + i) {
                diagNums.add(new ArrayList<>());
            }
            for (int j = 0; j < rowSize; ++j) {
                diagNums.get(i + j).add(nums.get(i).get(j));
            }
        }
        // read reverse
        int resultIndex = 0;
        int [] result = new int [elemsNum];
        
        for (List<Integer> diagRow : diagNums) {
            for (int num = diagRow.size() - 1; num >= 0; --num) {
                result[resultIndex++] = diagRow.get(num);
            }
        }

        return result;

    }
}