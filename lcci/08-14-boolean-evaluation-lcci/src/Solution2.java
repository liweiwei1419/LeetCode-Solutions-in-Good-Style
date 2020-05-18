import java.util.Arrays;

public class Solution2 {

    // 参考：https://leetcode-cn.com/problems/boolean-evaluation-lcci/solution/java-ji-yi-hua-sou-suo-by-npe_tle/

    public int countEval(String s, int result) {
        char[] charArray = s.toCharArray();
        int len = s.length();
        int[][][] memo = new int[len][len][2];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return dfs(charArray, memo, 0, len - 1, result);
    }


    /**
     * 返回从索引 begin 到 end 值为 k 的不同括号方案的个数
     */
    private int dfs(char[] charArray, int[][][] memo, int begin, int end, int result) {
        if (begin == end) {
            return charArray[begin] - '0' == result ? 1 : 0;
        }

        if (memo[begin][end][result] != -1) {
            return memo[begin][end][result];
        }

        int cnt = 0;
        for (int k = begin; k < end; k += 2) {
            char operator = charArray[k + 1];
            for (int i = 0; i <= 1; i++) {
                for (int j = 0; j <= 1; j++) {
                    if (getBoolAns(i, j, operator) == result) {
                        cnt += dfs(charArray, memo, begin, k, i) * dfs(charArray, memo, k + 2, end, j);
                    }
                }
            }
        }

        memo[begin][end][result] = cnt;
        return cnt;
    }

    private int getBoolAns(int val1, int val2, char operator) {
        switch (operator) {
            case '&':
                return val1 & val2;
            case '|':
                return val1 | val2;
            case '^':
                return val1 ^ val2;
        }
        return val1 & val2;
    }
}
