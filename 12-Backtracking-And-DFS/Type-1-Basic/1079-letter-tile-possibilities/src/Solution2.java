import java.util.Arrays;

public class Solution2 {

    private int cnt;
    private boolean[] used;

    public int numTilePossibilities(String tiles) {
        int len = tiles.length();
        if (len == 0) {
            return cnt;
        }
        char[] charArray = tiles.toCharArray();
        Arrays.sort(charArray);
        this.used = new boolean[tiles.length()];
        dfs(charArray, len, 0);
        return cnt;
    }

    private void dfs(char[] tilesChar, int len, int index) {
        if (index == len) {
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                if (i > 0 && tilesChar[i] == tilesChar[i - 1] && !used[i - 1]) {
                    continue;
                }
                cnt++;
                used[i] = true;
                dfs(tilesChar, len, index + 1);
                used[i] = false;
            }
        }
    }
}