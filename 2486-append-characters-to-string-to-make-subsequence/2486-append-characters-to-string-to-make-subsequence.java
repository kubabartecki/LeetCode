class Solution {
    public int appendCharacters(String s, String t) {
        int i = 0;
        int n = t.length();
        for (char letter : s.toCharArray()) {
            if (letter == t.charAt(i)) {
                ++i;
            }
            if (i == n) {
                return 0;
            }
        }
        return n - i;
    }
}
