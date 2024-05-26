class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String longest = "";

        for (int i = 0; i < n; ++i) {
            char letter = s.charAt(i);
            StringBuilder str = new StringBuilder(String.valueOf(letter));
            int left = i;
            int right = i;
            while (left > 0 && letter == s.charAt(left - 1)) {
                --left;
                str.append(letter);
            }
            while (right < n - 1 && letter == s.charAt(right + 1)) {
                ++right;
                str.append(letter);
            }
            for (--left, ++right; left >= 0 && right < n; --left, ++right) {
                if (!(s.charAt(left) == s.charAt(right))) {
                    if (longest.length() < str.length()) {
                        longest = str.toString();
                    }
                    break;
                }
                char nextLetter = s.charAt(left);
                str.insert(0, nextLetter);
                str.append(nextLetter);
            }
            if (longest.length() < str.length()) {
                longest = str.toString();
            }
        }
        return longest;
    }
}
