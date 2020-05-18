import java.util.ArrayDeque;
import java.util.Deque;

public class MaxQueue {

    private Deque<Integer> queue;
    private Deque<Integer> helper;

    public MaxQueue() {
        queue = new ArrayDeque<>();
        helper = new ArrayDeque<>();
    }

    public int max_value() {
        if (queue.isEmpty()) {
            return -1;
        }
        return helper.peekFirst();
    }

    public void push_back(int value) {
        queue.addLast(value);
        while (!helper.isEmpty() && value > helper.peekLast()) {
            helper.removeLast();
        }
        helper.addLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        int head = queue.removeFirst();
        if (helper.peekFirst() == head) {
            helper.removeFirst();
        }
        return head;
    }
}
