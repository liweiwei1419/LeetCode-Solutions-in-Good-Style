import java.util.Arrays;

public class Solution3 {

    public int countPrimes(int n) {
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);
        for (int i = 2; i < n; i++) {
            // 每一轮第一个没有被划去的数肯定是质数
            if (primes[i]) {
                for (int j = i + i; j < n; j += i) {
                    primes[j] = false;
                }
            }
        }
        // 下面开始计数
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i]) {
                count++;
            }
        }
//        System.out.println("打印质数");
//        for (int i = 2; i < n; i++) {
//            if (primes[i]) {
//                System.out.println("质数 " + i);
//            }
//        }
        return count;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int n = 20;
        int countPrimes = solution3.countPrimes(n);
        System.out.println(countPrimes);
    }
}
