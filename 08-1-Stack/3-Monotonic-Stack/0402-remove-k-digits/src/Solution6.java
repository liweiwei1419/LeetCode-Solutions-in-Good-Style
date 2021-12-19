public class Solution6 {

    public int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        int res = factorial(n - 1);
        // 在这里还能够执行一次操作，实现「分治思想」里「合并」的逻辑
        return n * res;
    }

    public static void main(String[] args) {
        Solution6 solution3 = new Solution6();
        int n = 5;
        int res = solution3.factorial(n);
        System.out.println(res);
    }
}
