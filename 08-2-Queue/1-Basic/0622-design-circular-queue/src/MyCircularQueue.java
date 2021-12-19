public class MyCircularQueue {

    private int[] arr;
    private int capacity;
    /**
     * front 指向当前队列中最早入队的元素
     */
    private int front;
    /**
     * rear 指向下一个添加到队尾的元素
     */
    private int rear;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        // 始终保持 1 个位置不存有效元素，是为了避免判断队列为空和队列为满的条件冲突
        capacity = k + 1;
        arr = new int[capacity];
        front = 0;
        rear = 0;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        // 队尾为满不可以入队
        if (isFull()) {
            return false;
        }
        arr[rear] = value;
        rear = (rear + 1) % capacity;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        // 队尾为空不可以出队
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % capacity;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        // 队列非空才可以取出队头
        if (isEmpty()) {
            return -1;
        }
        return arr[front];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        // 队列非空才可以取出队尾
        if (isEmpty()) {
            return -1;
        }
        // 有数组下标的计算一定要考虑是否越界
        return arr[(rear - 1 + capacity) % capacity];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        // 有数组下标的计算一定要考虑是否越界
        return (rear + 1) % capacity == front;
    }
}