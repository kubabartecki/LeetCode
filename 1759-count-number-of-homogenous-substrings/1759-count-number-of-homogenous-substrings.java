class Solution {
    public int countHomogenous(String s) {
        int result = 0;
        int counter = 0;
        char prev = s.charAt(0);

        for (char letter : s.toCharArray()) {
            if (letter == prev) ++counter;
            else {
                counter = 1;
                prev = letter;
            }
            result += counter;
            result %= 1_000_000_007;
        }
        return result;
    }
}