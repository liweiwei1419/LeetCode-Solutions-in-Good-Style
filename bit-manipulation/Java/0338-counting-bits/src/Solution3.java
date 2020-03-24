public class Solution3 {

    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 0;
        for (int i = 1; i <= num; i++) {
            // 特判，很重要，只有 1 个的话，就直接是 1
            if ((i & (i - 1)) == 0) {
                dp[i] = 1;
                continue;
            }
            dp[i] = dp[i - 1] + 1;
        }
        return dp;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 16; i++) {
            System.out.println(String.format("%04d", Integer.parseInt(Integer.toBinaryString(i))));
        }
    }
}
