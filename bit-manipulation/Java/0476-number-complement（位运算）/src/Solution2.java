public class Solution2 {

    public int findComplement(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException("输入的数字不是正整数");
        }
        // 这个复制出来的数对运算结果不起直接作用，只是用来判断需要取反的操作的次数
        int numCopy = num;
        int mask = 1;
        // 正整数，右移，左边补 0
        while (numCopy > 0) {
            // 和 1 做异或操作：0 1 -> 1 ，1 1 -> 0：
            // 和 0 做异或操作：1 0 -> 1 ，0 0 -> 0：
            num ^= mask;
            mask <<= 1;
            numCopy >>= 1;
        }
        return num;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int n = 16;
        System.out.println(Integer.toBinaryString(n));
        int solutionComplement = solution2.findComplement(n);
        System.out.println(solutionComplement);
    }
}
