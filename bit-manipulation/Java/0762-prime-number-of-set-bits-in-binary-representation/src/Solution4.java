public class Solution4 {

    public int countPrimeSetBits(int L, int R) {
        boolean[] primes = new boolean[32];
        int[] primeNums = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
        for (int prime : primeNums) {
            primes[prime] = true;
        }
        int res = 0;
        for (int i = L; i <= R; i++) {
            int bitCount = 0;
            int num = i;
            while (num != 0) {
                num = num & (num - 1);
                bitCount++;
            }
            if (primes[bitCount]) {
                res++;
            }
        }
        return res;
    }
}
