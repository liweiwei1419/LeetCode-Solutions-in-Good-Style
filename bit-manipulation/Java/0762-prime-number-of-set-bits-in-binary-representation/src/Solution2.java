public class Solution2 {

    public int countPrimeSetBits(int L, int R) {
        int result = 0;
        for (int i = L; i <= R; i++) {
            int num = countNum(i);
            if (isPrime(num)){
                result++;
            }
        }
        return result;
    }

    /**
     * 数出二进制中 1 的个数
     *
     * @param num
     * @return
     */
    private int countNum(int num) {
        int result = 0;
        do {
            if (num % 2 != 0) {
                result++;
            }
            num = num >> 1;
        } while (num > 0);
        return result;
    }

    /**
     * 判断是否质数
     *
     * @param num
     * @return
     */
    private boolean isPrime(int num) {
        if (num == 1){
            return false;
        }
        if (num == 2 || num == 3){
            return true;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
