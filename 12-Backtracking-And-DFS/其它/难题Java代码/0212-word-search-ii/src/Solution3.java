import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution3 {

    // 本题的区别：words 是数组，第 79 题，只有一个单词

    private int rows;
    private int cols;

    private int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<String> findWords(char[][] board, String[] words) {
        this.rows = board.length;
        this.cols = board[0].length;

        // 第 1 步：建立字典树
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        // 第 2 步：深度优先遍历
        // 可能的结果有重复
        Set<String> res = new HashSet<String>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, trie, i, j, res);
            }
        }
        return new ArrayList<String>(res);
    }

    public void dfs(char[][] board, Trie root, int x, int y, Set<String> res) {
        if (!root.children.containsKey(board[x][y])) {
            return;
        }
        char ch = board[x][y];
        root = root.children.get(ch);
        if (!"".equals(root.word)) {
            res.add(root.word);
        }

        board[x][y] = '#';
        for (int[] dir : dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (inArea(newX, newY)) {
                dfs(board, root, newX, newY, res);
            }
        }
        board[x][y] = ch;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}

class Trie {
    String word;
    Map<Character, Trie> children;
    boolean isWord;

    public Trie() {
        this.word = "";
        this.children = new HashMap<Character, Trie>();
    }

    public void insert(String word) {
        Trie cur = this;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new Trie());
            }
            cur = cur.children.get(c);
        }
        cur.word = word;
    }
}