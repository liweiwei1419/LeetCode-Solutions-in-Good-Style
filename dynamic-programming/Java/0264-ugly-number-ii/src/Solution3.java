public class Solution3 {

    public int nthUglyNumber(int n) {
        int[] primes = new int[3];
        primes[0] = 2;
        primes[1] = 3;
        primes[2] = 5;
        int[] indexes = new int[3];
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < 3; j++) {
                dp[i] = Integer.min(dp[i], dp[indexes[j]] * primes[j]);
            }
            for (int j = 0; j < 3; j++) {
                if (dp[i] == dp[indexes[j]] * primes[j]) {
                    indexes[j]++;
                }
            }
        }
        return dp[n - 1];
    }
}
