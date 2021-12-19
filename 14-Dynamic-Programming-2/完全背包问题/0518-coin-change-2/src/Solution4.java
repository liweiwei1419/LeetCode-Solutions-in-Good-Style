import java.util.Arrays;

public class Solution4 {

    // 该解法超时，要看问题规模

    private int res = 0;

    public int change(int amount, int[] coins) {
        int len = coins.length;
        Arrays.sort(coins);

        dfs(amount, coins, 0, len);
        return res;
    }

    private void dfs(int residue, int[] coins, int start, int len) {
        if (residue == 0) {
            res++;
            return;
        }

        for (int i = start; i < len; i++) {
            if (residue - coins[i] < 0) {
                break;
            }
            dfs(residue - coins[i], coins, i, len);
        }
    }

    public static void main(String[] args) {
        int amount = 500;
        int[] coins = {3, 5, 7, 8, 9, 10, 11};
        Solution4 solution4 = new Solution4();
        int res = solution4.change(amount, coins);
        System.out.println(res);
    }
}
