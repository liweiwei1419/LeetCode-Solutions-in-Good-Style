public class Solution {

    //
    // 1、找到所有介于 L 和 R 之间的数的二进制表示；
    // 2、判断每个二进制数表示中 1 的个数是否为质数；
    // 3、求为质数的个数。

    public int countPrimeSetBits(int L, int R) {
        // int 类型的二进制表示 1 的个数最多是 32
        // 所以 32 以内的质数个数完全可以打表列举出来
        boolean[] isPrime = new boolean[32];
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};

        // 质数的个数作为索引，是不是质数体现在索引对应的值
        for (int prime : primes) {
            isPrime[prime] = true;
        }
        int res = 0;
        for (int i = L; i <= R; i++) {
            if (isPrime[Integer.bitCount(i)]) {
                res++;
            }
        }
        return res;
    }
}


