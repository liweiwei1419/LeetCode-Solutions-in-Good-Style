public class Solution {

    public boolean isPalindrome(int x) {
        // 如果 x < 0 直接就可以判断不是回文数
        if (x < 0) {
            return false;
        }
        return x == reverse(x);
    }

    private int reverse(int x) {
        int reverse = 0;
        while (x != 0) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        return reverse;
    }
}