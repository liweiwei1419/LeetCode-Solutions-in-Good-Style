public class Solution3 {

    /**
     * 转换成一个 3 进制的数，它的字符串表示一定是以 1 开头，后面全部是 0
     *
     * @param n
     * @return
     */
    public boolean isPowerOfThree(int n) {
        return n > 0 && Integer.toString(n, 3).matches("^10*$");
    }

    public static void main(String[] args) {
        int num = 27;
        System.out.println(Integer.toString(num, 3));
    }
}
