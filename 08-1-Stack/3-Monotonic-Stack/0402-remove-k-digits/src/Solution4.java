public class Solution4 {

    public int factorial(int n) {
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res *= i;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        int n = 5;
        int res = solution4.factorial(n);
        System.out.println(res);
    }
}
