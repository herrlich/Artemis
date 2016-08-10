Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

For example,

MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3



public class MovingAverage {
    
    private Queue<Integer> queue;
    private int size;
    private int sum;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new LinkedList<Integer>();
        this.size = size;
        sum = 0;
    }
    
    public double next(int val) {
        if (queue.size() < size) {
            sum += val;
            queue.offer(val);
        }
        else {
            int tmp = queue.poll();
            sum = sum - tmp + val;
            queue.offer(val);
        }
        return (double)sum / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */