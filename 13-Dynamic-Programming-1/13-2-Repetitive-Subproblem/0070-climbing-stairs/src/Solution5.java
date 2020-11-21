public class Solution5 {

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int p = 1;
        int q = 2;
        int res = 1;
        for (int i = 3; i <= n; ++i) {
            res = p + q;
            p = q;
            q = res;
        }
        return res;
    }
}