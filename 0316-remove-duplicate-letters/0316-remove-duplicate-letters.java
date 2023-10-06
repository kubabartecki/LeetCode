class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Integer> stack = new Stack<>();
        boolean [] seen = new boolean[26];
        int [] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < s.length(); i++){
            int curr = s.charAt(i) - 'a';
            if(seen[curr]) continue; // already used
            while(!stack.isEmpty() && curr < stack.peek() && lastIndex[stack.peek()] > i){
                seen[stack.pop()] = false;
            }
            stack.push(curr);
            seen[curr] = true;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while(!stack.isEmpty()){
            stringBuilder.append((char) (stack.pop() + 'a')); //jak dziala bez (char) -> zapisze int w stringu
        }
        return stringBuilder.reverse().toString();
    }
}