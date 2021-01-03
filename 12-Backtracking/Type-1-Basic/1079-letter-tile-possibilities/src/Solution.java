public class Solution {

    public int numTilePossibilities(String tiles) {
        int[] count = new int[26];
        char[] charArray = tiles.toCharArray();
        for (char c : charArray) {
            count[c - 'A']++;
        }
        // tiles 里所有的信息都存在 count 里，对 count 执行深度优先遍历即可
        return dfs(count);
    }

    /**
     * 设计递归函数的返回值
     *
     * @return 在当前的频数数组下，可以产生的排列数
     */
    private int dfs(int[] count) {
        // 递归终止条件是：当前没有可以用的字符（没有显示递归终止条件）
        int res = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] == 0) {
                continue;
            }

            // 走到这里一定会有有效的排列
            res++;
            count[i]--;

            // 递归执行下一层
            res += dfs(count);
            // 深度优先遍历有返回的过程，只需要重置字符频数数组
            count[i]++;
        }
        return res;
    }
}