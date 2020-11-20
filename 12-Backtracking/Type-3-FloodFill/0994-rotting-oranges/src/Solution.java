import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        int cols = grid[0].length;
        if (cols == 0) {
            return 0;
        }

        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        // 这里不使用 visited 数组，直接在原始数组上修改
        Queue<Integer> queue = new LinkedList<>();
        // 初始化的时候，新鲜橘子的个数
        int cnt = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 2) {
                    queue.offer(getIndex(i, j, cols));
                } else if (grid[i][j] == 1) {
                    cnt++;
                }
            }
        }

        int res = 0;
        while (!queue.isEmpty()) {
            // 如果当前没有新鲜的橘子，就没有可以扩散的区域了
            if (cnt == 0) {
                break;
            }
            res++;
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                Integer top = queue.poll();
                int x = top / cols;
                int y = top % cols;

                for (int[] direction : directions) {
                    int newX = x + direction[0];
                    int newY = y + direction[1];
                    if (inArea(newX, newY, rows, cols) && grid[newX][newY] == 1) {
                        cnt--;
                        queue.offer(getIndex(newX, newY, cols));
                        // 直接在原始数组上做标记，这样就不需要创建 visited 数组了
                        // 发现了好的橘子，就应该将它的值修改，反正它迟早都会变质
                        // 否则会添加重复的橘子
                        grid[newX][newY] = 2;
                    }
                }
            }
        }

        if (cnt > 0) {
            // 此时说明，好的橘子是一个"孤岛"，不会被坏橘子污染到
            return -1;
        }
        return res;
    }

    private int getIndex(int i, int j, int cols) {
        return i * cols + j;
    }

    private boolean inArea(int i, int j, int rows, int cols) {
        return 0 <= i && i < rows && 0 <= j && j < cols;
    }
}