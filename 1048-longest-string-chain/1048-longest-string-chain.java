class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Map<String, Integer> wordsCount = new HashMap<>();
        int maxChain = 0;
        for (String word: words) {
            int longestNow = 0;
            for (int j = 0; j < word.length(); ++j) {
                StringBuilder sub = new StringBuilder(word);
                sub.deleteCharAt(j);
                String subStr = sub.toString();
                longestNow = Math.max(wordsCount.getOrDefault(subStr, 0) + 1, longestNow);
            }
            wordsCount.put(word, longestNow);
            maxChain = Math.max(maxChain, longestNow);
        }

        return maxChain;
    }
}