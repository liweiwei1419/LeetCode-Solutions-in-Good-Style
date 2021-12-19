import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    // 这版代码最快

    private static final int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private int rows;
    private int cols;

    private boolean[][] visited;

    private class TrieNode {
        private Map<Character, TrieNode> next = new HashMap<>();
        private String isWord;
    }


    public List<String> findWords(char[][] board, String[] words) {
        // 第 1 步：构建前缀树
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode currNode = root;
            char[] charArray = word.toCharArray();
            for (Character c : charArray) {
                if (!currNode.next.containsKey(c)) {
                    currNode.next.put(c, new TrieNode());
                }
                currNode = currNode.next.get(c);
            }
            currNode.isWord = word;
        }


        // 第 2 步： 回溯算法找所有匹配的单词
        this.rows = board.length;
        this.cols = board[0].length;
        this.visited = new boolean[rows][cols];
        List<String> res = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (root.next.containsKey(board[i][j])) {
                    dfs(board, i, j, root, visited, res);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] board, int i, int j, TrieNode currNode, boolean[][] visited, List<String> res) {
        Character letter = board[i][j];
        TrieNode nextNode = currNode.next.get(letter);

        if (nextNode.isWord != null) {
            res.add(nextNode.isWord);
            // 找到了就从字典中删除
            nextNode.isWord = null;
            // 思考这里为什么不可以 return

        }

        visited[i][j] = true;
        for (int[] direction : DIRECTIONS) {
            int newX = i + direction[0];
            int newY = j + direction[1];
            if (inArea(newX, newY) && !visited[newX][newY] && nextNode.next.containsKey(board[newX][newY])) {
                dfs(board, newX, newY, nextNode, visited, res);
            }
        }
        visited[i][j] = false;

        // 理解下面的代码非常重要
        // 优化：增量删除叶节点，Optimization: incrementally remove the leaf nodes
        if (nextNode.next.isEmpty()) {
            currNode.next.remove(letter);
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}