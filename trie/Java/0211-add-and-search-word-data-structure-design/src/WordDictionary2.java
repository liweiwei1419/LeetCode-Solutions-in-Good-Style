import java.util.HashMap;
import java.util.Map;

public class WordDictionary2 {

    private Node root;

    private class Node {
        private boolean isWord;
        private Map<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new HashMap<>();
        }

        public Node() {
            this(false);
        }
    }

    /**
     * Initialize your data structure here.
     */
    public WordDictionary2() {
        this.root = new Node();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        Node curr = root;
        Character c;
        for (int i = 0; i < word.length(); i++) {
            c = word.charAt(i);
            if (curr.next.get(c) == null) {
                curr.next.put(c, new Node());
            }
            curr = curr.next.get(c);
        }
        curr.isWord = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return match(root, word, 0);
    }

    // 不要循环和递归一起用
    private boolean match(Node node, String word, int index) {
        // 递归终止条件比较容易忘记
        if (index == word.length()) {
            return node.isWord;
        }
        Character currC = word.charAt(index);
        if (currC == '.') {
            for (Character c : node.next.keySet()) {
                if(match(node.next.get(c), word, index + 1)){
                    return true;
                }
            }
            return false;
        } else {// currC!='.'
            if (node.next.get(currC) == null) {
                return false;
            }
            return match(node.next.get(currC), word, index + 1);
        }
    }

    public static void main(String[] args) {
        WordDictionary2 wordDictionary2 = new WordDictionary2();
        wordDictionary2.addWord("a");
        wordDictionary2.addWord("a");
        boolean search = wordDictionary2.search(".");
        System.out.println(search);
        boolean search1 = wordDictionary2.search("a");
        System.out.println(search1);
        boolean search2 = wordDictionary2.search("aa");
        System.out.println(search2);
        boolean search3 = wordDictionary2.search("a");
        System.out.println(search3);
        boolean search4 = wordDictionary2.search(".a");
        System.out.println(search4);
        boolean search5 = wordDictionary2.search("a.");
        System.out.println(search5);
    }
}
