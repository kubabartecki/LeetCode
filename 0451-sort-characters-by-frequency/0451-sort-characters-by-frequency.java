class Solution {
    public String frequencySort(String s) {
        int count[] = new int [127];
        for (char letter: s.toCharArray()) {
            ++count[letter];
        }
        StringBuilder strB = new StringBuilder();
        while (true) {
            int mostFrequentLetter = 0;
            for(int i = 0; i < 127; ++i) {
                if (count[i] > count[mostFrequentLetter]) {
                    mostFrequentLetter = i;
                }
            }
            if (count[mostFrequentLetter] == 0) {
                break;
            }
            for (int i = 0; i < count[mostFrequentLetter]; ++i) {
                strB.append((char) mostFrequentLetter);
            }
            count[mostFrequentLetter] = 0;
        }
        return strB.toString();   
    }
}