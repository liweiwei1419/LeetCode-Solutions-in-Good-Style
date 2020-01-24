public class Solution2 {

    // 时间复杂度：O(2^N)

    public int fib(int N) {
        if (N < 2) {
            return N;
        }
        return fib(N - 1) + fib(N - 2);
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int N = 60;
        int res = solution2.fib(N);
        System.out.println(res);
    }
}
