class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            row.add((int)((long) row.get(i - 1) * (long)(rowIndex - i + 1) / (long)i));
        }

        return row;
    }
}