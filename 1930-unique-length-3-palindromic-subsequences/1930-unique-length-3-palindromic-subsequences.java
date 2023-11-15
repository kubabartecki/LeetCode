class Solution {
    public int countPalindromicSubsequence(String s) {
        int [] minIndex = new int [26];
        Arrays.fill(minIndex, Integer.MAX_VALUE);
        int [] maxIndex = new int [26];
        Arrays.fill(maxIndex, Integer.MIN_VALUE);

        for (int i = 0; i < s.length(); ++i) {
            int letterIndex = s.charAt(i) - 'a';
            if (minIndex[letterIndex] > i) minIndex[letterIndex] = i;
            if (maxIndex[letterIndex] < i) maxIndex[letterIndex] = i;
        }

        int result = 0;
        for (int i = 0; i < 26; ++i) {
            Set<Character> lettersBetween = new HashSet<>();
            for (int j = minIndex[i] + 1; j < maxIndex[i]; ++j) {
                lettersBetween.add(s.charAt(j));
            }
            result += lettersBetween.size();
        }
        return result;
    }
}