public class Solution5 {

    /**
     * @param n
     * @param res 递归函数上一层的结果，由于求的是阶乘一开始需要传入 1
     * @return
     */
    public int factorial(int n, int res) {
        if (n == 1) {
            return res;
        }
        return factorial(n - 1, n * res);
    }

    public static void main(String[] args) {
        Solution5 solution4 = new Solution5();
        int n = 5;
        int res = solution4.factorial(n, 1);
        System.out.println(res);
    }
}
