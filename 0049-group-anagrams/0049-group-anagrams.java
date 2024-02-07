class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramGroup = new HashMap<>();
        for (String anagram: strs) {
            String sortedLetters = anagram.chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString();
            anagramGroup.computeIfAbsent(sortedLetters, sL -> new ArrayList<>());
            anagramGroup.get(sortedLetters).add(anagram);
        }
        return new ArrayList<>(anagramGroup.values());
    }
}
