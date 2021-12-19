import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

    // 官方题解

    public String longestWord(String[] words) {
        Trie trie = new Trie();
        int index = 1;
        for (String word : words) {
            trie.insert(word, index);
            index++;
        }
        trie.words = words;
        return trie.dfs();
    }

    private class Trie {
        private class Node {
            char c;
            Map<Character, Node> children = new HashMap<>();
            int end;

            public Node(char c) {
                this.c = c;
            }
        }


        private Node root;
        private String[] words;

        public Trie() {
            root = new Node('0');
        }

        public void insert(String word, int index) {
            Node cur = root;
            for (char c : word.toCharArray()) {
                cur.children.putIfAbsent(c, new Node(c));
                cur = cur.children.get(c);
            }
            cur.end = index;
        }

        // dfs 用栈实现
        public String dfs() {
            String ans = "";
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while (!stack.empty()) {
                Node node = stack.pop();
                if (node.end > 0 || node == root) {
                    if (node != root) {
                        String word = words[node.end - 1];
                        if (word.length() > ans.length() ||
                                word.length() == ans.length() && word.compareTo(ans) < 0) {
                            ans = word;
                        }
                    }
                    for (Node nei : node.children.values()) {
                        stack.push(nei);
                    }
                }
            }
            return ans;
        }
    }
}
