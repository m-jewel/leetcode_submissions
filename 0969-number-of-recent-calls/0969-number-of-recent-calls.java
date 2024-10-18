import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {
    private Queue<Integer> queue;

    // Constructor to initialize the queue
    public RecentCounter() {
        queue = new LinkedList<>();
    }
    
    // Method to add the current ping and return the number of valid pings in the last 3000ms
    public int ping(int t) {
        // Add the current ping time to the queue
        queue.add(t);

        // Remove pings that are outside the [t - 3000, t] range
        while (!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.poll();  // Remove the oldest ping
        }

        // The size of the queue is the number of valid pings
        return queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
