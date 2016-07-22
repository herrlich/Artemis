public class MinStack {

    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minstack = new Stack<Integer>();
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        if (stack.isEmpty() || x <= minstack.peek()) minstack.push(x);
        stack.push(x);
    }
    
    public void pop() {
        if (stack.pop().equals(minstack.peek())) minstack.pop(); 
        //it's very important to use equals here, since the return values are all objects
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minstack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */