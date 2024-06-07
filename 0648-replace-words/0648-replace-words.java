class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> dictionarySet = new HashSet<>(dictionary);
        List<String> rootSentence = new ArrayList<>();
        for (String word : sentence.split(" ")) {
            StringBuilder sb = new StringBuilder();
            boolean isFound = false;
            for (int i = 0; i < word.length(); ++i) {
                sb.append(word.charAt(i));
                if (dictionarySet.contains(sb.toString())) {
                    rootSentence.add(sb.toString());
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                rootSentence.add(sb.toString());
            }
        }
        return rootSentence.stream()
            .collect(Collectors.joining(" "));
    }
}
