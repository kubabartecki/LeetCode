class Solution {
    public String sortVowels(String s) {
        String vowels = "AEIOUaeiou";
        int [] vowelsCount = new int [10];
        char [] letters = s.toCharArray();
        for (char letter : s.toCharArray()) {
            int vowelIndex = vowels.indexOf(letter);
            if (vowelIndex != -1) ++vowelsCount[vowelIndex];
        }

        int currentVowel = 0;
        for (int i = 0; i < letters.length; ++i) {
            if (vowels.indexOf(letters[i]) != -1) {
                for (int j = currentVowel; j < 10; ++j) {
                    if (vowelsCount[j] == 0) ++currentVowel;
                    else {
                        --vowelsCount[j];
                        break;
                    }
                }
                letters[i] = vowels.charAt(currentVowel);
            }
        }
        return String.valueOf(letters);
    }
}