public class Trie3 {

    private Node root;

    private class Node {
        private Node[] dict;
        private boolean isWord;

        public Node() {
            // 你可以假设所有的输入都是由小写字母 a-z 构成的
            dict = new Node[26];
            this.isWord = false;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public Trie3() {
        root = new Node();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        int len = word.length();
        Node curNode = root;
        for (int i = 0; i < len; i++) {
            char curChar = word.charAt(i);
            Node next = curNode.dict[curChar - 'a'];
            if (next == null) {
                curNode.dict[curChar - 'a'] = new Node();
            }
            curNode = curNode.dict[curChar - 'a'];
        }
        if (!curNode.isWord) {
            curNode.isWord = true;
        }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        int len = word.length();
        Node curNode = root;

        for (int i = 0; i < len; i++) {
            char curC = word.charAt(i);
            Node next = curNode.dict[curC - 'a'];
            if (next == null) {
                return false;
            } else {
                curNode = next;
            }
        }
        return curNode.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        int len = prefix.length();
        Node curNode = root;
        for (int i = 0; i < len; i++) {
            char curC = prefix.charAt(i);
            Node next = curNode.dict[curC - 'a'];
            if (next == null) {
                return false;
            } else {
                curNode = next;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Trie3 trie3 = new Trie3();
        trie3.insert("helloworld");
        boolean startsWith = trie3.startsWith("hello");
        System.out.println(startsWith);
        boolean search1 = trie3.search("helloworld");
        System.out.println(search1);

        boolean search2 = trie3.search("hello");
        System.out.println(search2);
    }
}
