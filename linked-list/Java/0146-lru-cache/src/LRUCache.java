import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private Map<Integer, ListNode> map;

    /**
     * 双链表结点类
     */
    private class ListNode {

        /**
         * 必须要存 key，因为删除 map 里元素的时候要用到
         */
        private Integer key;
        private Integer value;
        /**
         * 前驱结点 precursor
         */
        private ListNode pre;
        /**
         * 后继结点 successor（写成 next 是照顾单链表的表示习惯）
         */
        private ListNode next;

        public ListNode() {
        }

        public ListNode(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;

    /**
     * 虚拟头结点没有前驱
     */
    private ListNode dummyHead;
    /**
     * 虚拟尾结点没有后继
     */
    private ListNode dummyTail;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
        dummyHead = new ListNode();
        dummyTail = new ListNode();
        // 初始化链表为 head <-> tail

        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;

    }

    public int get(int key) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            int val = node.value;

            // 把当前 node 移动到双向链表的最末尾
            moveNode2Tail(key);
            return val;
        } else {
            return -1;
        }

    }

    /**
     * 如果哈希表的容量满了，就要删除一个链表末尾元素，然后在链表头部插入新元素
     *
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // 更新 value
            map.get(key).value = value;
            // 把当前 node 移动到双向链表的最末尾
            moveNode2Tail(key);
            return;
        }

        // 放元素的操作是一样的

        if (map.size() == capacity) {
            // 如果满了，就要删除 head 的 key
            map.remove(dummyHead.next.key);

            // 删除双链表虚拟头结点的下一个结点
            ListNode deleteNode = dummyHead.next;

            // 前后搭桥
            dummyHead.next = deleteNode.next;
            deleteNode.next.pre = dummyHead;

            // 释放引用
            deleteNode.pre = null;
            deleteNode.next = null;
        }


        // 然后添加元素
        ListNode newNode = new ListNode(key, value);
        map.put(key, newNode);
        addNode2Tail(newNode);
    }


    private void moveNode2Tail(int key) {
        // 1、先把 node 拿出来
        ListNode node = map.get(key);

        // 2、原来 node 的前驱和后继接上
        node.pre.next = node.next;
        node.next.pre = node.pre;

        // 3、再把 node 放在末尾
        addNode2Tail(node);
    }

    private void addNode2Tail(ListNode newNode) {
        // 1、当前末尾结点
        ListNode tail = dummyTail.pre;

        // 2、末尾结点的后继指向新结点
        tail.next = newNode;
        // 3、设置新结点的前驱和后继
        newNode.pre = tail;
        newNode.next = dummyTail;

        // 4、更改虚拟尾结点的前驱
        dummyTail.pre = newNode;
    }
}
