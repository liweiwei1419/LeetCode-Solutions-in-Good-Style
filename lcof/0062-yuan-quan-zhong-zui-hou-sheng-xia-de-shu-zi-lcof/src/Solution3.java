public class Solution3 {

    int lastRemaining(int n, int m) {
        if (n <= 0 || m <= 0) {
            return -1;
        }

        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }

        return last;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int n = 70866;
        int m = 116922;
        // 64165
//        int n = 10;
//        int m = 17;
        int lastRemainingSolution = solution3.lastRemaining(n, m);
        System.out.println(lastRemainingSolution);
    }
}
