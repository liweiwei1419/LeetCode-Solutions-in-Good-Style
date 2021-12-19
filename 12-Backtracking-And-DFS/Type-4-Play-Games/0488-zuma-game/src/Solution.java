public class Solution {

    // 参考资料：https://zhuanlan.zhihu.com/p/187004523

    public int findMinStep(String board, String hand) {
        int[] c = new int[128];

        for (char x : hand.toCharArray()) {
            c[x]++;
        }
        return aux(board, c);
    }

    /**
     * @param board: the given board
     * @param hand:  the balls in your hand
     * @return: the minimal balls you have to insert to remove all the balls on the table
     */
    private int aux(String s, int[] c) {
        if ("".equals(s)) {
            return 0;
        }
        int res = 2 * s.length() + 1;
        for (int i = 0; i < s.length(); ) {
            // j 保存起点
            int j = i++;
            while (i < s.length() && s.charAt(i) == s.charAt(j)) {
                i++;
            }
            // 3 - (i - j) 判断消除需要几个球
            int inc = 3 - i + j;
            // 如果数量足够
            if (c[s.charAt(j)] >= inc) {
                // 如果 inc <= 0，不需要
                int used = Math.max(inc, 0);
                // 用掉 s[j]
                c[s.charAt(j)] -= used;
                // 去除 j 至 i 的一段继续搜索
                int temp = aux(s.substring(0, j) + s.substring(i), c);
                if (temp >= 0) {
                    res = Math.min(res, used + temp);
                }
                // 搜索完成后补充球的数量
                c[s.charAt(j)] += used;
            }
        }
        return res == 2 * s.length() + 1 ? -1 : res;
    }
}