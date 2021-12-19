public class MyHashMap {

    private class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            next = null;
        }
    }


    // 冲突解决：拉链法（本题用拉链法）和开放地址法
    // 本设计：拉链法，在哈希表中的每个位置上，用链表存储所有映射到该位置的元素。
    // 最好要画图理解这个方法

    private int size = 10;

    private Node[] hashTable;


    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        hashTable = new Node[size];
    }

    /**
     * 可能需要遍历，遍历完成以后都没有找到合适的 key，就放在最后
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        Node node = hashTable[key % size];
        Node pre = node;
        // 如果找不到，就初始化一个结点
        if (node == null) {
            hashTable[key % size] = new Node(key, value);
            return;
        }
        // 有冲突，就接到后面
        while (node != null) {
            // 有一样的 key ，就更新 value
            if (node.key == key) {
                node.value = value;
                return;
            }
            // 否则一个结点一个结点找下去
            pre = node;
            node = node.next;
        }
        pre.next = new Node(key, value);

    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        Node node = hashTable[key % size];

        while (node != null) {
            if (node.key == key) {
                return node.value;
            }
            node = node.next;
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        Node node = hashTable[key % size];
        Node pre = node;
        while (node != null) {
            if (node.key == key) {
                // 如果要删除的元素正好在开始
                if (pre.key == node.key) {
                    hashTable[key % size] = node.next;
                } else {
                    pre.next = node.next;
                }
            }
            pre = node;
            node = node.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */