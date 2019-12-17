import java.util.HashMap;
import java.util.LinkedHashMap;

public class LRUCache {

    /**
     * 内部类，双向链表结点类
     */
    private class ListNode {

        // 这个 ListNode 的 key 属性猛的一看可能是多余的
        // 但是我们在移除 tail 结点对应的 Hash 表中的键值对的时候，就需要它
        private int key;

        private int val;
        private ListNode preV;
        private ListNode next;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private HashMap<Integer, ListNode> map;
    private int capacity;
    private int size;
    private ListNode head;
    private ListNode tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 我们在更新的时候，使用先添加再删除的策略，所以多预留一个位置
        this.map = new LinkedHashMap<>(capacity + 1);
        this.head = null;
        this.tail = null;
    }

    //
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        // map 中有，说明这个缓存中有数据，从 ListNode 中拿，并且将这个结点移动到队列的开头
        ListNode retNode = map.get(key);
        int retVal = retNode.val;
        // 移动到头
        moveToHead(retNode);
        return retVal;
    }

    /**
     * 把当前结点移动到双向链表的头部
     *
     * @param retNode
     */
    private void moveToHead(ListNode retNode) {
        // 如果头结点不是返回值所在的结点才操作
        if (head == retNode || retNode == null) {
            return;
        }

        // 处理尾指针，retNode 的前指针和后指针统一处理
        if (retNode == tail) {
            tail = tail.preV;
            if (tail != null) {
                tail.next = null;
            }
        }

        if (retNode.preV != null) {
            retNode.preV.next = retNode.next;
        }

        if (retNode.next != null) {
            retNode.next.preV = retNode.preV;
        }

        retNode.next = head;
        retNode.preV = null;
        if (head != null) {
            head.preV = retNode;
        }
        head = retNode;
    }


    /**
     * 末尾结点释放，tail 指针前移
     */
    private void removeLast() {

        // 根据我们的业务逻辑，head 和 tail 要么都非空，要么都为空，不可能出现一个为空，另一个不为空的情况

        // head == null || tail == null 包括了他们同时为 null 的情况
        if (head == null || tail == null) {
            // throw new IllegalArgumentException("当前双向链表为 null，不能执行这个操作");
            return;
        }

        // 如果当前只有一个结点，那么 head 和 tail 都置为 null ，即清空了这个双向链表
        if (head == tail) {
            head = null;
            tail = null;
            return;
        }
        // 此时双向链表非空，并且 head 和 tail 不重合
        // 只要把 tail 向前移动，即可
        ListNode removeNode = tail;
        tail = tail.preV;
        tail.next = null;
        removeNode.preV = null;
        removeNode.next = null;
    }

    /**
     * 把新结点放在双向链表的开头
     *
     * @param newNode
     */
    private void addFirst(ListNode newNode) {
        if (newNode == null) {
            return;
        }
        newNode.next = head;
        newNode.preV = null;
        if (head != null) {
            head.preV = newNode;
        }
        head = newNode;

        // 考虑一下尾结点（比较容易忽略掉这个情况）
        // 如果链表为空，即一开始的情况，tail == null 的时候，tail 也要赋值
        if (tail == null) {
            tail = newNode;
        }
    }

    public void put(int key, int value) {
        // 如果 map 中有
        // 直接拿出来，更新这个结点的 value，并且把这个结点移动到队列的开头
        if (map.containsKey(key)) {
            // 表示击中缓存
            ListNode curNode = map.get(key);
            curNode.val = value;
            moveToHead(curNode);
            return;
        }
        // 如果 map 中没有
        // 情况1：size = capacaity，map 中移除末尾结点，ListNode 把 tail 移除，并且新结点放在双向链表的开头
        ListNode newNode = new ListNode(key, value);
        map.put(key, newNode);
        if (size == capacity) {
            // 移除 Map 中的末尾结点对应的 key-value 对
            int removeKey = tail.key;
            map.remove(removeKey);
            removeLast();
        } else {
            // 情况2：size < capacaity，size++，map 中添加，把新结点加在双向链表的开头
            assert size < capacity;
            // 把一个新结点添加在链表的开头
            size++;
        }
        addFirst(newNode);
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
        LRUCache lruCache = new LRUCache(capacity);

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
 * obj.put(key,value);
 */