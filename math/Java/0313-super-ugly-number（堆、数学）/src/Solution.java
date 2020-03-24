public class Solution {

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        int plen = primes.length;
        if (n <= 0 || plen == 0) {
            return 0;
        }
        int[] indexes = new int[primes.length];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < plen; j++) {
                dp[i] = Integer.min(dp[i], dp[indexes[j]] * primes[j]);
            }
            for (int j = 0; j < plen; j++) {
                if (dp[i] == dp[indexes[j]] * primes[j]) {
                    indexes[j]++;
                }
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int n = 12;
        int[] nums = {2, 7, 13, 19};
        Solution solution = new Solution();
        int nthSuperUglyNumber = solution.nthSuperUglyNumber(n, nums);
        System.out.println(nthSuperUglyNumber);
    }
}
