public class Solution {

    public boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false;
        }
        String binaryString = Integer.toBinaryString(num);
        int len = binaryString.length();
        // 二进制的长度是奇数，即后面 0 的个数是偶数
        return len % 2 == 1 && (num & 1 << (len - 1)) == num;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean powerOfFour = solution.isPowerOfFour(-2147483648);
        System.out.println(powerOfFour);
    }
}