public class Solution {

    /**
     * 暴力解法会超时
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd(int m, int n) {
        int res = m;
        for (int i = m + 1; i <= n; i++) {
            res &= i;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int m = 200;
        int n = 230;
        int rangeBitwiseAnd = solution.rangeBitwiseAnd(m, n);

        for (int i = m; i <=n ; i++) {
            System.out.printf("%-3d %32s",i,Integer.toBinaryString(i));
            System.out.println();
        }

        System.out.println("结果：");
        System.out.printf("%-3d %32s",rangeBitwiseAnd,Integer.toBinaryString(rangeBitwiseAnd));
    }
}
