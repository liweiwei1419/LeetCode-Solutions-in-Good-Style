public class Solution3 {

    public int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int n = 5;
        int res = solution3.factorial(n);
        System.out.println(res);
    }
}
