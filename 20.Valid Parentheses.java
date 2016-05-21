public class Solution {
    public boolean isValid(String s) {
        if (s == null || s == "") return true;
        Stack<Character> par = new Stack<Character>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                par.push(c);
                continue;
            }
            if (c == ')' && (par.isEmpty() || par.pop() != '(')) return false;
            if (c == ']' && (par.isEmpty() || par.pop() != '[')) return false;
            if (c == '}' && (par.isEmpty() || par.pop() != '{')) return false;
        }
        return par.isEmpty();
    }
}