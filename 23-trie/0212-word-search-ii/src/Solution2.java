import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    private static final int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private int rows;
    private int cols;

    public List<String> findWords(char[][] board, String[] words) {
        this.rows = board.length;
        this.cols = board[0].length;

        // 第 1 步：插入所有单词
        TrieTree trieTree = new TrieTree();
        for (String word : words) {
            trieTree.insert(word);
        }

        // 第 2 步：深度优先遍历
        List<String> res = new ArrayList<>();
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (trieTree.root.next[board[i][j] - 'a'] != null) {
                    dfs(board, visited, i, j, trieTree.root, res);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] board, boolean[][] visited, int i, int j, TrieNode currNode, List<String> ans) {
        char c = board[i][j];
        currNode = currNode.next[c - 'a'];
        if (currNode.val != null) {
            ans.add(currNode.val);
            currNode.val = null;
            // 注意：前缀树这里不能 return; 必须继续搜索
        }

        visited[i][j] = true;
        for (int[] direction : DIRECTIONS) {
            int newX = i + direction[0];
            int newY = j + direction[1];
            if (inArea(newX, newY) && !visited[newX][newY] && currNode.next[board[newX][newY] - 'a'] != null) {
                dfs(board, visited, newX, newY, currNode, ans);
            }
        }
        visited[i][j] = false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    private class TrieNode {
        private String val;
        private TrieNode[] next;

        public TrieNode() {
            next = new TrieNode[26];
        }
    }

    private class TrieTree {

        private TrieNode root = new TrieNode();

        public void insert(String word) {
            TrieNode node = root;

            char[] charArray = word.toCharArray();
            for (char c : charArray) {
                if (node.next[c - 'a'] == null) {
                    node.next[c - 'a'] = new TrieNode();
                }
                node = node.next[c - 'a'];
            }
            node.val = word;
        }
    }
}