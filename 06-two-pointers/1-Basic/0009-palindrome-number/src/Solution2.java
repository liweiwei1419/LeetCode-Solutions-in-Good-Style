public class Solution2 {

    public boolean isPalindrome(int x) {
        int origin = x;
        int res = 0;
        // 每次得到的余数
        int y;
        while (x > 0) {
            // 得到个位数
            y = x % 10;
            x = x / 10;
            res = res * 10 + y;
        }
        return res == origin;
    }
}