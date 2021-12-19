import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {

    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        int len = words.length;
        if (len == 0) {
            return res;
        }

        Trie trie = new Trie(words);

        Deque<String> path = new ArrayDeque<>();
        for (String word : words) {
            int wordSize = word.length();
            path.addLast(word);
            dfs(wordSize, trie, res, path);
            path.removeLast();
        }
        return res;

    }

    private void dfs(int wordSize, Trie trie, List<List<String>> ans, Deque<String> path) {
        if (path.size() == wordSize) {
            ans.add(new ArrayList<>(path));
            return;
        }

        int i = path.size();
        StringBuilder prefix = new StringBuilder();
        for (String s : path) {
            prefix.append(s.charAt(i));
        }

        List<String> startWith = trie.findByPrefix(prefix.toString());
        for (String s : startWith) {
            path.addLast(s);
            dfs(wordSize, trie, ans, path);
            path.removeLast();
        }
    }


    class TrieNode {
        List<String> startWith;
        TrieNode[] children;

        TrieNode() {
            startWith = new ArrayList<>();
            children = new TrieNode[26];
        }
    }

    class Trie {
        TrieNode root;

        Trie(String[] words) {
            root = new TrieNode();
            for (String w : words) {
                TrieNode cur = root;
                for (char ch : w.toCharArray()) {
                    int idx = ch - 'a';
                    if (cur.children[idx] == null)
                        cur.children[idx] = new TrieNode();
                    cur.children[idx].startWith.add(w);
                    cur = cur.children[idx];
                }
            }
        }

        List<String> findByPrefix(String prefix) {
            List<String> ans = new ArrayList<>();
            TrieNode cur = root;
            for (char ch : prefix.toCharArray()) {
                int idx = ch - 'a';
                if (cur.children[idx] == null)
                    return ans;

                cur = cur.children[idx];
            }
            ans.addAll(cur.startWith);
            return ans;
        }
    }
}