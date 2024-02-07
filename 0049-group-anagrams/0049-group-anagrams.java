class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramGroup = new HashMap<>();
        for (String anagram: strs) {
            String anagramCode = sortedStringCode(anagram);
            anagramGroup.computeIfAbsent(anagramCode, sL -> new ArrayList<>());
            anagramGroup.get(anagramCode).add(anagram);
        }
        return new ArrayList<>(anagramGroup.values());
    }
    
    public String sortedStringCode(String str) {
        int count[] = new int[26];
        for (char letter: str.toCharArray()) {
            ++count[letter - 'a'];
        }
        StringBuilder strB = new StringBuilder();
        for (int i = 0; i < 26; ++i) {
            if (count[i] == 0) continue;
            strB.append((char)'a' + i).append(count[i]);
        }
        return strB.toString();
    }
}
