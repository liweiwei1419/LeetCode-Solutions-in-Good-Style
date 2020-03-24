public class Solution4 {

    // https://www.cnblogs.com/maizi-1993/p/5909887.html
    // 有点贪心算法的意思

    public int integerReplacement(int n) {
        // 先考虑特殊情况
        if (n == Integer.MAX_VALUE) {
            return 32;
        }
        int res = 0;
        while (n != 1) {
            // 当 n 不论是奇数还是偶数的时候，变成偶数，消耗一个操作
            res++;
            if ((n & 1) == 0) {
                n >>= 1;
            } else {
                // 谁末尾的 0 多，就变成谁
                // 只有 3 这一个特例
                if (n == 3 || countTailZeros(n - 1) > countTailZeros(n + 1)) {
                    n--;
                } else {
                    n++;
                }
            }
        }
        return res;
    }

    // 这里很关键！！！末尾有几个 0 就表示可以提取的公因子！
    // 这里很关键！！！末尾有几个 0 就表示可以提取的公因子！
    // 这里很关键！！！末尾有几个 0 就表示可以提取的公因子！
    // 110100 52 26 13

    // 这个做法有点"过"，是很充分的做法
    private int countTailZeros(int num) {
        int count = 0;
        while (num % 2 == 0) {
            count++;
            num >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
    }
}
