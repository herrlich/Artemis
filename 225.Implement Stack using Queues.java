class MyStack {
    // Push element x onto stack.
    Queue<Integer> queue = new LinkedList<Integer>();
    public void push(int x) {
        queue.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        int len = queue.size() - 1;
        for (int i = 0; i < len; ++i) {
            queue.offer(queue.poll());
        }
        queue.poll();
    }

    // Get the top element.
    public int top() {
        int len = queue.size() - 1;
        for (int i = 0; i < len; ++i) {
            queue.offer(queue.poll());
        }
        int res = queue.poll();
        queue.offer(res);
        return res;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.size() == 0;
    }
}

------------------------------------------------------------------------
class MyStack {
	List<Integer> queue = new ArrayList<Integer>();
	
    // Push element x onto stack.
    public void push(int x) {
    	List<Integer> tmp = new ArrayList<Integer>();
        while (!queue.isEmpty()) tmp.add(queue.remove(0));
        queue.add(x);
        while (!tmp.isEmpty()) queue.add(tmp.remove(0));
    }

    // Removes the element on top of the stack.
    public void pop() {
        queue.remove(0);
    }

    // Get the top element.
    public int top() {
        return queue.get(0);
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}