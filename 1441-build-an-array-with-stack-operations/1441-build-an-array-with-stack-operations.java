class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> operations = new ArrayList<>();
        int j = 1;
        for(int i = 0; i < target.length; ++i, ++j) {
            while (j != target[i]) {
                ++j;
                operations.add("Push");
                operations.add("Pop");
            }
            operations.add("Push");
        }
        
        return operations;
    }
}