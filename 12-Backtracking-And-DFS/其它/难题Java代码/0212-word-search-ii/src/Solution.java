import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    // 参考资料：
    // https://leetcode.com/problems/word-search-ii/discuss/148041/Clean-Java-Code-Trie

    //         x-1, y
    // x, y-1  x, y    x, y+1
    //         x+1,y
    private static final int[][] directions = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    private class TrieNode {
        private TrieNode[] next;
        private boolean isEnd;
        private String word;

        public TrieNode() {
            next = new TrieNode[26];
            isEnd = false;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            return res;
        }
        int row = board.length;
        if (row == 0) {
            return res;
        }
        int col = board[0].length;
        TrieNode root = new TrieNode();
        boolean[][] visited = new boolean[row][col];
        for (String word : words) {
            TrieNode curNode = root;
            for (char c : word.toCharArray()) {
                if (curNode.next[c - 'a'] == null) {
                    curNode.next[c - 'a'] = new TrieNode();
                }
                curNode = curNode.next[c - 'a'];
            }
            if (!curNode.isEnd) {
                curNode.isEnd = true;
                curNode.word = word;
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dfs(board, visited, i, j, row, col, root, res);
            }
        }
        // 最后要去重
        Set<String> set = new HashSet(res);
        res = new ArrayList<>(set);
        return res;
    }

    /**
     * @param board   字符面板
     * @param visited 记录当前坐标是否被访问过
     * @param i       横坐标
     * @param j       纵坐标
     * @param row     横坐标的最大值
     * @param col     纵坐标的最大值
     * @param node    当前字典树结点
     * @param res     结果集
     */
    private void dfs(char[][] board, boolean[][] visited, int i, int j, int row, int col, TrieNode node, List<String> res) {
        if (node.isEnd) {
            res.add(node.word);
        }
        if (inArea(i, j, row, col) && !visited[i][j]) {
            TrieNode nextNode = node.next[board[i][j] - 'a'];
            // 特别注意这个访问的位置
            visited[i][j] = true;
            if (nextNode != null) {
                for (int k = 0; k < 4; k++) {
                    int newX = i + directions[k][0];
                    int newY = j + directions[k][1];
                    dfs(board, visited, newX, newY, row, col, nextNode, res);
                }
            }
            // 特别注意这个访问的位置
            visited[i][j] = false;
        }
    }

    private boolean inArea(int i, int j, int row, int col) {
        return i >= 0 && i < row && j >= 0 && j < col;
    }

    public static void main(String[] args) {
        String[] words = {"oath", "pea", "eat", "rain"};
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}};
        Solution solution = new Solution();
        List<String> solutionWords = solution.findWords(board, words);
        System.out.println(solutionWords);
    }
}