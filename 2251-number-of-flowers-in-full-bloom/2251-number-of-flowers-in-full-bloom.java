class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int [] num = new int [people.length];
        int [] starts = new int [flowers.length];
        int [] ends = new int [flowers.length];

        for (int i = 0; i < flowers.length; i++) {
            starts[i] = flowers[i][0];
            ends[i] = flowers[i][1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        for(int i = 0; i < people.length; ++i){
            int start = binSearchLeft(starts, people[i]);
            int end = binSearchRight(ends, people[i]);
            num[i] = start - end;
        }
        return num;
    }

    public int binSearchLeft(int [] arr, int target){
        int l = 0;
        int r = arr.length;

        while(l < r){
            int mid = l + (r - l) / 2;
            if(arr[mid] <= target){
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public int binSearchRight(int [] arr, int target){
        int l = 0;
        int r = arr.length;

        while(l < r){
            int mid = l + (r - l) / 2;
            if(arr[mid] < target){
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}