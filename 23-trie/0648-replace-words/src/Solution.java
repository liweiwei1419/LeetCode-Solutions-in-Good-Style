import java.util.Arrays;
import java.util.List;

public class Solution {

    // 我自己写的代码，实现了一个字典树 Trie

    private class Trie {

        private Node root;

        private class Node {
            private Node[] next;
            private boolean isEnd;

            public Node() {
                this.next = new Node[26];
                this.isEnd = false;
            }
        }

        public Trie() {
            root = new Node();
        }

        /**
         * insert 方法和一半前缀树无异
         *
         * @param word
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
         * @param word 词根
         * @return 如果是词根，则返回到词根的索引值（不包含该索引），如果不是词根，返回 0
         */
        public int startsWith(String word) {
            int index = 0;
            Node curNode = root;
            for (char c : word.toCharArray()) {
                if (curNode.next[c - 'a'] == null) {
                    return 0;
                }
                curNode = curNode.next[c - 'a'];
                index++;
                if (curNode.isEnd) {
                    return index;
                }
            }
            // 如果是前缀，则返回 0 ，例如：字典里面是 hello，而遍历的单词是 he
            return 0;
        }
    }

    public String replaceWords(List<String> dict, String sentence) {
        if (dict == null || dict.size() == 0 || sentence == null || sentence.length() == 0) {
            return "";
        }
        Trie trie = new Trie();
        for (String word : dict) {
            trie.insert(word);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (String word : sentence.split(" ")) {
            int index = trie.startsWith(word);
            if (index == 0) {
                stringBuilder.append(word);
            } else {
                stringBuilder.append(word.substring(0, index));
            }
            stringBuilder.append(" ");
        }
        // 删除最后一个空格
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> dict = Arrays.asList(new String[]{"cat", "bat", "rat"});
        String sentence = "the cattle was rattled by the battery";
        String replaceWords = solution.replaceWords(dict, sentence);
        System.out.println(replaceWords);
    }
}
