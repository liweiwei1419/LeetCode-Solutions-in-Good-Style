public class Trie4 {
    /**
     * Initialize your data structure here.
     */
    public Trie4() {
        root = new Node();
    }

    private Node root;

    private class Node {
        private Node[] next;
        private boolean isEnd;

        public Node() {
            this.next = new Node[26];
            this.isEnd = false;
        }
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Node curNode = root;
        for (char c : word.toCharArray()) {
            if (curNode.next[c - 'a'] == null) {
                curNode.next[c - 'a'] = new Node();
            }
            curNode = curNode.next[c - 'a'];
        }
        if (!curNode.isEnd) {
            curNode.isEnd = true;
        }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Node curNode = root;
        for (char c : word.toCharArray()) {
            if (curNode.next[c - 'a'] == null) {
                return false;
            }
            curNode = curNode.next[c - 'a'];
        }
        return curNode.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Node curNode = root;
        for (char c : prefix.toCharArray()) {
            if (curNode.next[c - 'a'] == null) {
                return false;
            }
            curNode = curNode.next[c - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */