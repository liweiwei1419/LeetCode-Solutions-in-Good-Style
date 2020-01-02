public class Solution3 {

    public int minCut(String s) {
        int len = s.length();
        // 初始化最小分割次数数组
        // 表示 s[0,i] 最多被分割成为回文子串的次数
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = i;
        }

        // checkP[i][j] 表示 s[i:j] 是否为回文
        boolean[][] checkP = new boolean[len][len];

        for (int right = 0; right < len; right++) {
            for (int left = 0; left <= right; left++) {
                if (s.charAt(left) == s.charAt(right) && (right - left < 2 || checkP[left + 1][right - 1])) {
                    checkP[left][right] = true;

                    // 下面这两种情况互斥
                    if (left == 0) {
                        // 开始是 0 ，说明自身就是回文串，无需切割
                        dp[right] = 0;
                    } else {

                        // 状态转移方程要讲清楚
                        dp[right] = Math.min(dp[right], dp[left - 1] + 1);
                    }
                }
            }

        }
        return dp[len - 1];
    }
}
