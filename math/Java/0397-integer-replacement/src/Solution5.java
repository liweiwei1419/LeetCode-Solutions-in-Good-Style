public class Solution5 {

    // 参考资料：https://segmentfault.com/a/1190000007318944

    public int integerReplacement(int n) {
        long num = n;
        int res = 0;
        while (num != 1) {
            res++;
            if ((num & 1) == 0) {
                // 是偶数的时候，直接右移
                num >>= 1;
            } else {
                // 是奇数的时候
                // 2 的二进制是 10，即如果倒数第 2 位是 1 的话
                // 加 1 能消耗掉更多的 1
                // 例如：
                // 如果倒数第二位是 0，那么 n - 1 的操作比 n + 1 的操作能消掉更多的 1
                // 1001 + 1 = 1010
                // 1001 - 1 = 1000
                // 如果倒数第二位是 1，那么 n + 1 的操作能比 n - 1的操作消掉更多的 1
                // 1011 + 1 = 1100
                // 1111 + 1 = 10000
                if ((num & 2) != 0 && num != 3) {
                    num++;
                } else {
                    num--;
                }
            }
        }
        return res;
    }
}
