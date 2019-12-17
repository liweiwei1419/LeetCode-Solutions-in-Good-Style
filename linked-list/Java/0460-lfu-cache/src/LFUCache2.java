import java.util.HashMap;
import java.util.TreeSet;

public class LFUCache2 {

    private static long TIME = 0;

    private long getTime(){
        return TIME++;
    }

    private class TreeNode implements Comparable<TreeNode> {
        private int key;
        private int val;
        private int freq;
        private long tick;

        public TreeNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1;
            this.tick = getTime();
        }

        /**
         * 如果 freq 和 tick 一样，就能找到这个元素，将其删除
         * @param other
         * @return
         */
        @Override
        public int compareTo(TreeNode other) {
            // 按照 freq 升序排序
            if (this.freq != other.freq) {
                return this.freq - other.freq;
            }
            // 在 freq 相同的情况下，按照时间戳升序排序
            if (this.tick - other.tick < 0) {
                return -1;
            } else if (this.tick - other.tick == 0) {
                return 0;
            }
            return 1;
        }
    }

    private HashMap<Integer, TreeNode> map;
    private int capacity;
    private int size;
    /**
     * 能够帮助我们完成按自定义需求排序的功能
     */
    private TreeSet<TreeNode> treeSet;

    public LFUCache2(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.treeSet = new TreeSet<>();
    }

    private void update(TreeNode treeNode) {
        // 更新的时候，TreeSet 会自己根据自定义规则调整吗，答案是不会
        // 所以，我们要先移除
        assert treeSet.contains(treeNode);
        treeSet.remove(treeNode);

        // 频率加 1
        treeNode.freq++;
        // 时间戳更新
        treeNode.tick = getTime();

        treeSet.add(treeNode);
    }

    public int get(int key) {
        if (capacity == 0) {
            return -1;
        }
        if (!map.containsKey(key)) {
            return -1;
        }
        TreeNode treeNode = map.get(key);
        int ret = treeNode.val;
        update(treeNode);
        return ret;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (map.containsKey(key)) {
            TreeNode treeNode = map.get(key);
            treeNode.val = value;
            update(treeNode);
            return;
        }
        // 在没有包含的情况下，就是给缓存新增元素
        if (size == capacity) {
            // 移除最少使用的 k-v 对
            TreeNode first = treeSet.pollFirst();
            assert first != null;
            this.map.remove(first.key);
            size--;
        }
        // 新增
        TreeNode treeNode = new TreeNode(key, value);
        this.map.put(key, treeNode);
        this.treeSet.add(treeNode);
        this.size++;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("cur size = ");
        stringBuilder.append(this.size);
        stringBuilder.append(", ");

        for (TreeNode node : treeSet) {
            stringBuilder.append(" [key = ");
            stringBuilder.append(node.key);
            stringBuilder.append(",val = ");
            stringBuilder.append(node.val);
            stringBuilder.append(",freq = ");
            stringBuilder.append(node.freq);
            stringBuilder.append(",tick = ");
            stringBuilder.append(node.tick);
            stringBuilder.append("] ");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        int capacity = 2;
        LFUCache2 lfuCache = new LFUCache2(capacity);

        // System.out.println("放入 1");
        lfuCache.put(1, 1);
        // System.out.println(lfuCache);

        // System.out.println("放入 2");
        lfuCache.put(2, 2);
        // System.out.println(lfuCache);


        // System.out.println("获取 1");
        int ret = lfuCache.get(1);       // 返回 1
        System.out.println(ret);
        // System.out.println(lfuCache);


        // System.out.println("放入 3");
        lfuCache.put(3, 3);    // 去除 key 2
        // System.out.println(lfuCache);

        ret = lfuCache.get(2);       // 返回 -1 (未找到key 2)
        System.out.println(ret);
        ret = lfuCache.get(3);       // 返回 3
        System.out.println(ret);

        lfuCache.put(4, 4);    // 去除 key 1
        ret = lfuCache.get(1);       // 返回 -1 (未找到 key 1)
        System.out.println(ret);

        ret = lfuCache.get(3);       // 返回 3
        System.out.println(ret);

        ret = lfuCache.get(4); // 返回 4
        System.out.println(ret);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */