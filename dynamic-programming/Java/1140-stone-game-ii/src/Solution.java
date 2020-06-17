import java.net.Socket;

public class Solution {

    public int stoneGameII(int[] piles) {
        int len = piles.length;
        // dp 表格存储子问题的结果
        int[][] table = new int[len][len];

        // 使用上述递归公式填充表。 请注意，该表以对角线方式填充。
        // (similar to http://goo.gl/PQqoS), 形成回文的最小插入字符数
        // from diagonal elements to table[0][len-1]
        // which is the result.
        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j; j++) {
                int x = ((i + 2) <= j) ? table[i + 2][j] : 0;
                int y = ((i + 1) <= (j - 1)) ? table[i + 1][j - 1] : 0;
                int z = (i <= (j - 2)) ? table[i][j - 2] : 0;

                table[i][j] = Math.max(piles[i] + Math.min(x, y), piles[j] + Math.min(y, z));
            }
        }

        return table[0][len - 1];
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] piles = {2, 7, 9, 4, 4};
        int res = solution.stoneGameII(piles);
        System.out.println(res);

        int[] piles1 = {8, 15, 3, 7};

        int[] piles2 = {2, 2, 2, 2};

        int[] piles3 = {20, 30, 2, 2, 2, 10};

        int res1 = solution.stoneGameII(piles1);
        int res2 = solution.stoneGameII(piles2);
        int res3 = solution.stoneGameII(piles3);
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}
