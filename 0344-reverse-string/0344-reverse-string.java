class Solution {
    public void reverseString(char[] s) {
        int n = s.length - 1;
        int i = 0, j = n;
        
        while(i < j) {
            char tmp = s[i];
            s[i++] = s[j];
            s[j--] = tmp;
        }
    }
}
