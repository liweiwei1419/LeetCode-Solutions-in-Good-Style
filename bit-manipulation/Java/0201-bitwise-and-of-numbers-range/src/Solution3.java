public class Solution3 {

    /**
     * 利用了 n &= (n - 1) 一下能消死一大片
     *
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd(int m, int n) {
        while (n > m) {
            n &= (n - 1);
        }
        return n;
    }
}
