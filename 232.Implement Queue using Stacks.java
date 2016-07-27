class MyQueue {
    // Push element x to the back of queue.
    private Stack<Integer> stack = new Stack<Integer>();
    private Stack<Integer> tmp = new Stack<Integer>();
    
    public void push(int x) {
        while (!stack.isEmpty()) tmp.push(stack.pop());
        stack.push(x);
        while (!tmp.isEmpty()) stack.push(tmp.pop());
    }

    // Removes the element from in front of queue.
    public void pop() {
        stack.pop();
    }

    // Get the front element.
    public int peek() {
        return stack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.isEmpty();
    }
}