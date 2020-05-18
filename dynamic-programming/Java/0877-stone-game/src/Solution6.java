import java.util.Arrays;

public class Solution6 {
    // 花花酱的思路 1：计算子区间里的相对分数


    public boolean stoneGame(int[] piles) {
        int len = piles.length;
        int[][] memo = new int[len][len];

        for (int i = 0; i < len; i++) {
            Arrays.fill(memo[i], -99999999);
            memo[i][i] = piles[i];
        }
        return stoneGame(piles, 0, len - 1, memo) > 0;
    }


    /**
     * 计算子区间 [left, right] 里先手能够得到的分数
     *
     * @param piles
     * @param left
     * @param right
     * @return
     */
    private int stoneGame(int[] piles, int left, int right, int[][] memo) {
        if (memo[left][right] != -99999999) {
            return memo[left][right];
        }

        if (left == right) {
            return piles[left];
        }

        int res = Math.max(piles[left] - stoneGame(piles, left + 1, right, memo),
                piles[right] - stoneGame(piles, left, right - 1, memo));
        memo[left][right] = res;
        return res;
    }


}
