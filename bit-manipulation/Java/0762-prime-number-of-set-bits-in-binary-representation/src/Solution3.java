public class Solution3 {

    public int countPrimeSetBits(int L, int R) {
        int res = 0;
        for (int i = L; i <= R; i++) {
            int count = countPrimeSetBit(i);
            if (isPrime(count)) {
                res++;
            }
        }
        return res;
    }

    private boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        if (num == 2 || num == 3) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private int countPrimeSetBit(int num) {
        int count = 0;
        while (num != 0) {
            if (num % 2 == 1) {
                count++;
            }
            num >>>= 1;
        }
        return count;
    }
}
