import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private Map<Integer, ListNode> map;

    /**
     * 双链表结点类
     */
    private class ListNode {

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
        dummyHead = new ListNode(-1, -1);
        dummyTail = new ListNode(-1, -1);
        // 初始化链表为 head <-> tail

        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
    }

    /**
     * 如果存在，把当前结点移动到双向链表的头部
     *
     * @param key
     * @return
     */
    public int get(int key) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            int val = node.value;

            // 把当前 node 移动到双向链表的头部
            moveNode2Head(key);
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
            // 1、更新 value
            map.get(key).value = value;
            // 2、把当前 node 移动到双向链表的头部
            moveNode2Head(key);
            return;
        }

        // 放元素的操作是一样的

        if (map.size() == capacity) {
            // 如果满了
            ListNode oldTail = removeTail();

            // 设计 key 就是为了在这里删除
            map.remove(oldTail.key);
        }

        // 然后添加元素
        ListNode newNode = new ListNode(key, value);
        map.put(key, newNode);
        addNode2Head(newNode);
    }

    // 为了突出主干逻辑，下面是 3 个公用的方法

    /**
     * 删除双链表尾部结点
     */
    private ListNode removeTail() {
        ListNode oldTail = dummyTail.pre;
        ListNode newTail = oldTail.pre;

        // 两侧结点建立连接
        newTail.next = dummyTail;
        dummyTail.pre = newTail;

        // 释放引用
        oldTail.pre = null;
        oldTail.next = null;

        return oldTail;
    }

    /**
     * 把当前 key 指向的结点移到双向链表的头部
     *
     * @param key
     */
    private void moveNode2Head(int key) {
        // 1、先把 node 拿出来
        ListNode node = map.get(key);

        // 2、原来 node 的前驱和后继接上
        node.pre.next = node.next;
        node.next.pre = node.pre;

        // 3、再把 node 放在末尾
        addNode2Head(node);
    }

    /**
     * 在双链表的头部新增一个结点
     *
     * @param newNode
     */
    private void addNode2Head(ListNode newNode) {
        // 1、当前头结点
        ListNode oldHead = dummyHead.next;

        // 2、末尾结点的后继指向新结点
        oldHead.pre = newNode;

        // 3、设置新结点的前驱和后继
        newNode.pre = dummyHead;
        newNode.next = oldHead;

        // 4、更改虚拟头结点的后继结点
        dummyHead.next = newNode;
    }
}