public class Solution3 {

    // 方法二：字典树

    private int longestLen = 0;
    private String ansLongerWord = "";

    public String longestWord(String[] words) {
        TrieNode root = new TrieNode();
        for (String s : words) {
            TrieNode cur = root;
            for (char c : s.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
            }
            cur.isEnd = true;
            cur.word = s;
        }

        dfs(root, 0);
        return ansLongerWord;
    }

    public void dfs(TrieNode root, int depth) {
        // 当前节点为空，或者当前节点（非根节点）不是单词的结尾时，return 剪枝
        if (root == null || (depth > 0 && !root.isEnd)) {
            return;
        }

        // 每次搜索更新最大深度和最长单词
        if (depth > longestLen) {
            longestLen = depth;
            ansLongerWord = root.word;
        }

        for (TrieNode node : root.children) {
            if (node != null) {
                dfs(node, depth + 1);
            }
        }
    }

    private class TrieNode {
        String word;
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }
}