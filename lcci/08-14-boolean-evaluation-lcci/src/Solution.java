import java.util.ArrayList;
import java.util.List;


public class Solution {

    // 区间 dp 问题

    // 参考：https://leetcode-cn.com/problems/boolean-evaluation-lcci/solution/qu-jian-dp-by-lightcml/

    public int countEval(String s, int result) {
        // dp[i][j][k]表示子区间 s[i, j] 字计算结果为 k 的方案数
        // 这里 k = 0 或者 1

        // 枚举区间分割点，左右的方法数的乘积

        char[] charArray = s.toCharArray();

        int len = s.length();

        List<Integer> nums = new ArrayList<>();
        List<Character> operations = new ArrayList<>();

        for (int i = 0; i < len; ++i) {
            if ((i % 2) == 0) {
                nums.add(charArray[i] - '0');
            } else {
                operations.add(charArray[i]);
            }
        }
        int size = nums.size();
        int[][][] dp = new int[size][size][2];
        for (int i = 0; i < size; ++i) {
            dp[i][i][nums.get(i)] = 1;
            dp[i][i][nums.get(i) ^ 1] = 0;
        }


        for (int l = 2; l <= size; ++l) {
            for (int i = 0; i + l - 1 < size; ++i) {
                int j = i + l - 1;
                dp[i][j][0] = dp[i][j][1] = 0;
                for (int k = i; k < j; ++k) {
                    if (operations.get(k) == '&') {
                        dp[i][j][1] += dp[i][k][1] * dp[k + 1][j][1];
                        dp[i][j][0] += dp[i][k][1] * dp[k + 1][j][0];
                        dp[i][j][0] += dp[i][k][0] * dp[k + 1][j][1];
                        dp[i][j][0] += dp[i][k][0] * dp[k + 1][j][0];
                    } else if (operations.get(k) == '|') {
                        dp[i][j][1] += dp[i][k][1] * dp[k + 1][j][1];
                        dp[i][j][1] += dp[i][k][1] * dp[k + 1][j][0];
                        dp[i][j][1] += dp[i][k][0] * dp[k + 1][j][1];
                        dp[i][j][0] += dp[i][k][0] * dp[k + 1][j][0];
                    } else {
                        dp[i][j][0] += dp[i][k][1] * dp[k + 1][j][1];
                        dp[i][j][1] += dp[i][k][1] * dp[k + 1][j][0];
                        dp[i][j][1] += dp[i][k][0] * dp[k + 1][j][1];
                        dp[i][j][0] += dp[i][k][0] * dp[k + 1][j][0];
                    }
                }
            }
        }
        return dp[0][size - 1][result];

    }
}
