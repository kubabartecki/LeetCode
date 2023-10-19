class Solution {
    public boolean backspaceCompare(String s, String t) {
        return stringFormation(s).equals(stringFormation(t));
    }

    public Stack<Character> stringFormation(String str){
        Stack<Character> stack = new Stack<>();
        for(char letter: str.toCharArray()){
            if(letter == '#'){
                if(!stack.isEmpty()) stack.pop();
            } else {
                stack.push(letter);
            }
        }
        return stack;
    }
}