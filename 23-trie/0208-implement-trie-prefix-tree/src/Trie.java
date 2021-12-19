import java.util.HashMap;
import java.util.Map;


public class Trie {

    private Node root;

    private class Node {
        private boolean isWord;
        private Map<Character, Node> next;

        public Node() {
            this.isWord = false;
            this.next = new HashMap<>();
        }
    }

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        // 根节点不表示任何字符
        root = new Node();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Node curNode = root;
        int len = word.length();
        char[] charArray = word.toCharArray();
        for (int i = 0; i < len; i++) {
            Character c = charArray[i];
            if (!curNode.next.containsKey(c)) {
                curNode.next.put(c, new Node());
            }
            curNode = curNode.next.get(c);
        }
        // 如果之前没有设置过，才设置成 true
        if (!curNode.isWord) {
            curNode.isWord = true;
        }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Node curNode = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (curNode.next.containsKey(c)) {
                curNode = curNode.next.get(c);
            } else {
                // 中途就出错了
                return false;
            }
        }
        // 到了末尾还要判断一下
        return curNode.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Node curNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            Character c = prefix.charAt(i);
            if (curNode.next.containsKey(c)) {
                curNode = curNode.next.get(c);
            } else {
                return false;
            }
        }
        // 能走完就说明有这个前缀
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        // 返回 true
        boolean search1 = trie.search("apple");
        System.out.println(search1);
        // 返回 false
        boolean search2 = trie.search("app");
        System.out.println(search2);
        // 返回 true
        boolean startsWith = trie.startsWith("app");
        System.out.println(startsWith);
        trie.insert("app");
        // 返回 true
        boolean search3 = trie.search("app");
        System.out.println(search3);
    }
}