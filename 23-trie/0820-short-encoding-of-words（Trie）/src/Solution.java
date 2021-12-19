import java.util.Arrays;

public class Solution {

    public int minimumLengthEncoding(String[] words) {
        int len = words.length;
        if (len == 1) {
            return words[0].length() + 1;
        }

        // 预处理
        // 先插入长度大的字符串，再插入长度小的字符串
        Arrays.sort(words, (o1, o2) -> -o1.length() + o2.length());

        Trie trie = new Trie();
        int res = 0;
        for (String word : words) {
            int curLen = trie.insert(word);
            if (curLen != 0) {
                res += (curLen + 1);
            }
        }
        return res;
    }


    private class Trie {

        private Node root;

        private class Node {
            private Node[] next;
            // 你可以假设所有的输入都是由小写字母 a-z 构成的。
            public Node() {
                next = new Node[26];
            }
        }

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new Node();
        }

        /**
         * Inserts a word into the trie.
         */
        public int insert(String word) {
            int len = word.length();
            char[] charArray = word.toCharArray();

            Node curNode = root;
            boolean ifNewBranch = false;
            for (int i = len - 1; i >= 0; i--) {
                int index = charArray[i] - 'a';
                Node next = curNode.next[index];
                if (next == null) {
                    ifNewBranch = true;
                    curNode.next[index] = new Node();
                }
                curNode = curNode.next[index];
            }

            if (ifNewBranch) {
                return len;
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        // String[] words = {"time", "me", "bell"};
        String[] words = {"time"};
        Solution solution = new Solution();
        int res = solution.minimumLengthEncoding(words);
        System.out.println(res);
    }
}
