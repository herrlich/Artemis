public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') stack.push(c);
            else {
                if (stack.isEmpty()) return false;
                char tmp = stack.pop();
                if (c == ')' && tmp != '(') return false;
                if (c == ']' && tmp != '[') return false;
                if (c == '}' && tmp != '{') return false;
            }
        }
        if (stack.isEmpty()) return true;
        else return false;
    }
}