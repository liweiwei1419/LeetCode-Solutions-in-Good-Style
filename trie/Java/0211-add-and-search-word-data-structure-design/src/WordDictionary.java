import java.util.HashMap;
import java.util.Set;

// https://leetcode-cn.com/problems/add-and-search-word-data-structure-design/description/
public class WordDictionary {

    private Node root;

    private class Node {
        private boolean isWord;
        private HashMap<Character, Node> next;

        public Node() {
            this.next = new HashMap<>();
        }
    }

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new Node();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        Node curNode = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (!curNode.next.containsKey(c)) {
                curNode.next.put(c, new Node());
            }
            curNode = curNode.next.get(c);
        }
        if (!curNode.isWord) {
            curNode.isWord = true;
        }
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return search(root, word, 0);
    }

    private boolean search(Node node, String word, int depth) {
        if (depth == word.length()) {
            // 只要能搜索到最后，就表示文本与模式匹配
            // 这一步很容易被忽视
            return node.isWord;
        }
        Character c = word.charAt(depth);
        if (c == '.') {
            Set<Character> keys = node.next.keySet();
            for (Character key : keys) {
                Node nextNode = node.next.get(key);
                if (search(nextNode, word, depth + 1)) {
                    return true;
                }
            }
            // 循环都走完都没有找到，那就说明没有
            return false;
        } else {
            if (!node.next.containsKey(c)) {
                return false;
            }
            return search(node.next.get(c), word, depth + 1);
        }
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        boolean search1 = wordDictionary.search("pad");// -> false
        System.out.println(search1);
        boolean search2 = wordDictionary.search("bad"); // -> true
        System.out.println(search2);
        boolean search3 = wordDictionary.search(".ad"); // -> true
        System.out.println(search3);
        boolean search4 = wordDictionary.search("b.."); //-> true
        System.out.println(search4);
    }
}
