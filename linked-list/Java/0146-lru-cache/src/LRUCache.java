import java.util.HashMap;
import java.util.Map;

/**
 * @author liweiwei1419
 * @date 2019/11/23 12:47 上午
 */
public class LRUCache {

    // 哈希表
    // 双向链表，tail 永远存放最新查询的元素，head 存放最老的，即将要被淘汰的元素

    private class ListNode {
        private int key;
        private int value;
        private ListNode prev;
        private ListNode next;

        public ListNode() {
        }

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Map<Integer, ListNode> hashMap;
    private ListNode dummyHead;
    private ListNode dummyTail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        hashMap = new HashMap<>();

        // 虚拟头结点没有前驱
        dummyHead = new ListNode();
        // 虚拟尾结点没有后继
        dummyTail = new ListNode();

        // 初始化链表为 head <-> tail
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    /**
     * 把最新查询过的元素和最新放入的元素放置在 tail
     *
     * @param key
     */
    private void moveNode2Tail(int key) {
        ListNode node = hashMap.get(key);

        // 先把 node 拿出来
        node.prev.next = node.next;
        node.next.prev = node.prev;

        // 再把 node 放在末尾
        add2Tail(node);
    }

    private void add2Tail(ListNode newNode) {
        ListNode tail = dummyTail.prev;

        tail.next = newNode;
        newNode.prev = tail;
        newNode.next = dummyTail;
        dummyTail.prev = newNode;
    }

    public int get(int key) {
        if (hashMap.containsKey(key)) {
            // 把 key 移动到末尾
            moveNode2Tail(key);
        }
        // 返回 -1 表示未找到
        ListNode res = hashMap.get(key);
        if (res == null) {
            return -1;
        }
        return res.value;
    }

    public void put(int key, int value) {
        if (hashMap.containsKey(key)) {
            hashMap.get(key).value = value;

            // 把 key 移动到末尾
            moveNode2Tail(key);
            return;
        }

        if (hashMap.size() == capacity) {
            // 如果满了，就要删除 head 的 key
            hashMap.remove(dummyHead.next.key);

            // 删除虚拟头结点的下一个结点
            ListNode deleteNode = dummyHead.next;
            dummyHead.next = deleteNode.next;
            deleteNode.next.prev = dummyHead;

            deleteNode.prev = null;
            deleteNode.next = null;
        }

        // 然后添加元素
        ListNode newNode = new ListNode(key, value);
        hashMap.put(key, newNode);
        add2Tail(newNode);
    }
}
