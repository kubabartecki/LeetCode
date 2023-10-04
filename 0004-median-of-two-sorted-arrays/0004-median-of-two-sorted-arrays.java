class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A, B;
        if (nums1.length > nums2.length) {
            A = nums2;
            B = nums1;
        } else {
            A = nums1;
            B = nums2;
        }
        int total = A.length + B.length;
        int half = (total) / 2;
        int l = 0, r = A.length - 1;
        while (true) {
             int i = Math.floorDiv(l + r, 2);
            int j = half - i - 2;

            int Aleft, Aright, Bleft, Bright;
            Aleft = (i >= 0) ? A[i] : Integer.MIN_VALUE;
            Bleft = (j >= 0) ? B[j] : Integer.MIN_VALUE;
            Aright = (i + 1 < A.length) ? A[i + 1] : Integer.MAX_VALUE;
            Bright = (j + 1 < B.length) ? B[j + 1] : Integer.MAX_VALUE;

            if (Aleft <= Bright && Bleft <= Aright) {
                if (total % 2 == 1){
                    return Math.min(Aright, Bright);
                } else return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
            } else if (Aleft > Bright) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }
    }
}