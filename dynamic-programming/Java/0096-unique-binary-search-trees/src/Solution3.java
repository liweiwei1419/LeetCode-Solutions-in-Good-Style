public class Solution3 {

    // 递归方法实现：这里一定要用上记忆化递归
    // 因为有大量重复子问题

    // base case 是，当 n = 0 或者 n = 1 时，显然 BST 数量只能有 1 个。

    /**
     * 一定要加上缓存
     */
    private int[] memo;

    public int numTrees(int n) {
        if (n < 0) {
            return 0;
        }
        if (n < 2) {
            return 1;
        }
        memo = new int[n + 1];
        memo[0] = 1;
        memo[1] = 1;
        return helper(n);
    }

    private int helper(int n) {
        if (memo[n] != 0) {
            return memo[n];
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += helper(i - 1) * helper(n - i);
        }
        memo[n] = sum;
        return sum;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int n = 3;
        int numTrees = solution2.numTrees(n);
        System.out.println(numTrees);
    }
}
