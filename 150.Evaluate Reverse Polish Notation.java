public class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < tokens.length; ++i) {
            if (tokens[i].equals("+")) {
                stack.push(stack.pop() + stack.pop());
                continue;
            }
            if (tokens[i].equals("*")) {
                stack.push(stack.pop() * stack.pop());
                continue;
            }
            if (tokens[i].equals("-")) {
                int num1 = stack.pop();
                stack.push(stack.pop() - num1);
                continue;
            }
            if (tokens[i].equals("/")) {
                int num1 = stack.pop();
                stack.push(stack.pop() / num1);
                continue;
            }
            stack.push(Integer.parseInt(tokens[i]));
        }
        return stack.pop();
    }
}