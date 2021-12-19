import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public String replaceWords(List<String> dictionary, String sentence) {
        // 按照单词的长度从小到大排序（为什么）
        // Collections.sort(dictionary, (s1, s2) -> s1.length() - s2.length());
        Collections.sort(dictionary, Comparator.comparingInt(String::length));

        // 建树
        Trie trie = new Trie();
        for (String word : dictionary) {
            trie.insert(word);
        }

        String[] words = sentence.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : words) {
            // 这句话是核心，搜到前缀停下
            stringBuilder.append(trie.search(word)).append(" ");
        }

        int len = stringBuilder.length();
        stringBuilder.deleteCharAt(len - 1);
        return stringBuilder.toString();
    }


    private class Trie {

        private class TrieNode {
            private boolean isWord;
            private TrieNode[] children = new TrieNode[26];

            public TrieNode() {
                this.isWord = false;
            }
        }

        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String s) {
            TrieNode currNode = root;
            for (char c : s.toCharArray()) {
                int index = c - 'a';
                if (currNode.children[index] == null) {
                    currNode.children[index] = new TrieNode();
                }
                currNode = currNode.children[index];
            }
            currNode.isWord = true;
        }

        public String search(String s) {
            TrieNode currNode = root;
            StringBuilder stringBuilder = new StringBuilder();
            char[] charArray = s.toCharArray();
            for (char c : charArray) {
                int index = c - 'a';
                if (currNode.children[index] == null) {
                    return s;
                }
                stringBuilder.append(c);
                currNode = currNode.children[index];
                if (currNode.isWord) {
                    return stringBuilder.toString();
                }
            }
            return s;
        }
    }
}
