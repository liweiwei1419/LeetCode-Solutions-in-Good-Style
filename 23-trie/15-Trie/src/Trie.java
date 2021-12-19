import java.util.TreeMap;

public class Trie {

    private class Node {
        public boolean isWord;
        // 用哈希表也是可以的，因为这里不涉及排序操作
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void add(String word) {
        // root 是当前 Trie 对象的属性
        Node currNode = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (currNode.next.get(c) == null) {
                currNode.next.put(c, new Node());
            }
            currNode = currNode.next.get(c);
        }
        // 如果已经添加过，才将 size++
        if (!currNode.isWord) {
            currNode.isWord = true;
            size++;
        }
    }

    // 基于 Trie 的查询
    public boolean contains(String word) {
        Node currNode = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (currNode.next.get(c) == null) {
                return false;
            }
            currNode = currNode.next.get(c);
        }
        return currNode.isWord;
    }

    // 是否有某个前缀
    public boolean isPrefix(String prefix) {
        Node currNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            Character c = prefix.charAt(i);
            if (currNode.next.get(c) == null) {
                return false;
            }
            currNode = currNode.next.get(c);
        }
        // 只需要判断从树的根节点是不是很顺利地都能匹配单词的每一个字符
        // 所以，能走到这里来，就返回 True
        return true;
    }
}
