import java.util.Arrays;

public class Solution4 {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int res = 4;
            for (int j = 1; i - j * j >= 0; j++) {
                res = Math.min(1 + dp[i - j * j], res);
            }
            dp[i] = res;
        }
        // System.out.println(Arrays.toString(dp));
        return dp[n];
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        int numSquares = solution4.numSquares(200);
        System.out.println(numSquares);
    }
}
