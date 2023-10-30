class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] boxedArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(boxedArr, new BinComparator());
        return Arrays.stream(boxedArr).mapToInt(Integer::intValue).toArray();
    }
}

class BinComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) {
        int onesA = Integer.bitCount(a);
        int onesB = Integer.bitCount(b);
        if(onesA == onesB) return a - b;
        return onesA - onesB;
    }
}