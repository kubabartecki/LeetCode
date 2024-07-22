class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> height2Name = new HashMap<>();
        for (int i = 0; i < heights.length; ++i) {
            height2Name.put(heights[i], names[i]);
        }

        Arrays.sort(heights);
        for(int i = 0; i < heights.length / 2; ++i) {
            int help = heights[i];
            heights[i] = heights[heights.length - 1 - i];
            heights[heights.length - 1 - i] = help;
        }
        for (int i = 0; i < heights.length; ++i) {
            names[i] = height2Name.get(heights[i]);
        }
        return names;
    }
}
