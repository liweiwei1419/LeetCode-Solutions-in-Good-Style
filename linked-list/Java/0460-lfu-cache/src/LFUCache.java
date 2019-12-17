import java.util.HashMap;
import java.util.LinkedList;

public class LFUCache {

    private class ListNode {
        private int key;
        private int val;
        private int freq;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ListNode listNode = (ListNode) o;
            return key == listNode.key;
        }
    }

    private LinkedList<ListNode>[] cache;
    private int capacity;
    private int size;
    private HashMap<Integer, ListNode> map;
    private static final int MAX_FREQ = 1000;

    public LFUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        cache = new LinkedList[MAX_FREQ];
        for (int i = 1; i < MAX_FREQ; i++) {
            cache[i] = new LinkedList<>();
        }
        map = new HashMap<>(capacity);
    }

    private void update(ListNode listNode) {
        int freq = listNode.freq;
        listNode.freq++;

        LinkedList linkedList = cache[freq++];
        linkedList.remove(listNode);
        // 时间复杂度最小
        cache[freq].addFirst(listNode);
    }

    public int get(int key) {
        if (capacity == 0) {
            return -1;
        }
        if (!map.containsKey(key)) {
            return -1;
        }
        assert map.containsKey(key);

        ListNode curNode = map.get(key);
        update(curNode);
        return curNode.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (map.containsKey(key)) {
            ListNode curNode = map.get(key);
            curNode.val = value;
            update(curNode);
            return;
        }
        // 不存在的时候
        if (size == capacity) {
            // 删除频率最小的那个链表的最后一个元素
            for (int i = 1; i < MAX_FREQ; i++) {
                if (cache[i].size() != 0) {
                    ListNode listNode = cache[i].removeLast();
                    map.remove(listNode.key);
                    size--;
                    break;
                }
            }
        }
        ListNode newListNode = new ListNode(key, value);
        cache[1].addFirst(newListNode);
        map.put(key, newListNode);
        size++;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */