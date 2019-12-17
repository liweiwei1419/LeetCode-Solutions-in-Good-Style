import java.util.HashMap;
import java.util.LinkedHashMap;


public class LRUCache2 {

    /**
     * 内部类，双向链表结点类
     */
    private class ListNode {
        // 这个 ListNode 的 key 属性猛的一看可能是多余的
        // 但是我们在移除 tail 结点对应的 Hash 表中的键值对的时候，就需要它
        private int key;
        private int val;
        private ListNode prev;
        private ListNode next;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private HashMap<Integer, ListNode> map;
    private int capacity;
    private ListNode head;
    private ListNode tail;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>(capacity);
        this.head = null;
        this.tail = null;
    }

    public int get(int key) {
        if (!this.map.containsKey(key)) {
            return -1;
        }

        ListNode curr = this.map.get(key);
        if (curr == head) {
            return curr.val;
        }
        // 如果不是头结点的话，就把这个结点移动到头结点
        moveToHead(curr);
        return curr.val;
    }

    private void moveToHead(ListNode retNode) {
        // 如果头结点不是返回值所在的结点才操作
        if (retNode == head || retNode == null) {
            return;
        }

        // 下面这两个 if 代码很工整，思路也非常正确
        // 只有对非空结点才能进行属性的操作
        if (retNode.prev != null) {
            retNode.prev.next = retNode.next;
        }
        if (retNode.next != null) {
            retNode.next.prev = retNode.prev;
        }
        // 上面分别改变了前后结点的 next 和 prev 指向
        // 对 retNode 没有改变

        // 尾指针向前移动一位
        if (retNode == tail) {
            tail = retNode.prev;
        }

        // 接下来把 retNode 移动到当前的 head 结点之前
        retNode.prev = null;
        if (head != null) {
            retNode.next = head;
            head.prev = retNode;
        }
        head = retNode;
    }

    /**
     * 移除尾结点
     */
    private void evict() {
        if (tail == null) {
            return;
        }

        ListNode evictedNode = tail;
        // 改变 tail 指针
        tail = evictedNode.prev;
        // 截断引用
        evictedNode.prev = null;

        // 对结点的操作都要判断一下结点是否为空
        if (tail != null) {
            tail.next = null;
        }
        // 只剩下一个结点的时候，head 置空
        if (evictedNode == head) {
            head = null;
        }
        this.map.remove(evictedNode.key);
    }

    /**
     * 注意代码中对结点属性的使用都会加上非空的判断
     *
     * @param node
     */
    private void addNodeToHead(ListNode node) {
        if (node == null) {
            return;
        }
        node.next = head;
        if (head != null) {
            head.prev = node;
        }
        node.prev = null;
        head = node;
        if (tail == null) {
            tail = node;
        }
    }

    public void put(int key, int value) {
        ListNode curr;
        if (this.map.containsKey(key)) {
            curr = this.map.get(key);
            curr.val = value;
            moveToHead(curr);
            return;
        }
        curr = new ListNode(key, value);
        if (this.map.size() == this.capacity) {
            // 如果满了，先把最后最后一个结点以及在 map 中对应的 k-v 对移除掉
            evict();
        }
        addNodeToHead(curr);
        this.map.put(key, curr);
    }


    // 调试使用，非必需
    // 只适用去传入双向链表的 head 结点，打印出双向链表
    // 如果传入非 head 结点，对于调试没有意义

    public void printListNode() {
        System.out.println("map:" + map.keySet());
        System.out.println("head:" + head.key);
        System.out.println("tail:" + tail.key);
        StringBuilder stringBuilder = new StringBuilder();
        ListNode curNode = head;
        stringBuilder.append("NULL");
        stringBuilder.append(" <-> ");
        while (curNode != null) {
            stringBuilder.append("(");
            stringBuilder.append(curNode.key);
            stringBuilder.append(",");
            stringBuilder.append(curNode.val);
            stringBuilder.append(")");
            stringBuilder.append(" <-> ");
            curNode = curNode.next;
        }
        stringBuilder.append("NULL");
        System.out.println(stringBuilder.toString());
        System.out.println();
    }

    public static void main(String[] args) {
        // 缓存容量为 2
        int capacity = 2;
        LRUCache2 lruCache = new LRUCache2(capacity);

        lruCache.put(1, 100);
        lruCache.printListNode();
        lruCache.put(2, 200);
        lruCache.printListNode();

        int value1 = lruCache.get(1);
        System.out.println(value1);
        lruCache.printListNode();


        lruCache.put(3, 300);
        lruCache.printListNode();


        int value2 = lruCache.get(2);
        System.out.println(value2);
        lruCache.printListNode();

        lruCache.put(4, 400);
        lruCache.printListNode();
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,val);
 */