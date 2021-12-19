import java.util.HashMap;
import java.util.Map;

public class Trie {

    /**
     * 内部类，不必对外声明
     */
    private class Node {

        /**
         * 因为这里不涉及排序操作，用数组也是可以的
         */
        public Map<Character, Node> next;

        /**
         * isWord 表示沿着根结点往下走，走到这个结点的时候是否是一个单词的结尾
         */
        public boolean isWord;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new HashMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;

    public Trie() {
        // 在构造函数里声明 trie 的根结点
        root = new Node();
    }

    public void insert(String word) {
        // root 是当前 Trie 对象的属性
        Node currNode = root;

        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (currNode.next.get(c) == null) {
                currNode.next.put(c, new Node());
            }
            currNode = currNode.next.get(c);
        }

        if (!currNode.isWord) {
            currNode.isWord = true;
        }
    }

    public boolean search(String word) {
        Node currNode = root;
        Character currC;
        for (int i = 0; i < word.length(); i++) {
            currC = word.charAt(i);
            if (currNode.next.get(currC) == null) {
                return false;
            }
            currNode = currNode.next.get(currC);
        }
        return currNode.isWord;
    }

    public boolean startsWith(String prefix) {
        Character c;
        Node currNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            c = prefix.charAt(i);
            if (currNode.next.get(c) == null) {
                return false;
            }
            currNode = currNode.next.get(c);
        }
        // 只需要判断从树的根结点是不是很顺利地都能匹配单词的每一个字符，所以，能走到这里来，就返回 True
        return true;
    }
}