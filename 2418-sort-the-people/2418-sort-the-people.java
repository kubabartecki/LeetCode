class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, Integer> heightIndex = new HashMap<>();
        for (int i = 0; i < heights.length; ++i) {
            heightIndex.put(heights[i], i);
        }

        return Arrays.stream(heights)
            .boxed()
            .sorted(Collections.reverseOrder())
            .map(height -> names[heightIndex.get(height)])
            .toArray(String[]::new);
    }
}
