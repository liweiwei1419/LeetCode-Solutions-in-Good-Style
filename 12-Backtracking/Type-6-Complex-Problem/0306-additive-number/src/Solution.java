public class Solution {

    // 这个版本不是标准的大整数的版本

    public boolean isAdditiveNumber(String num) {
        int len = num.length();
        char[] charArray = num.toCharArray();
        return dfs(charArray, len, 0, 0, 0, 0);
    }

    private boolean dfs(char[] charArray, int len, int begin, long num1, long num2, int k) {
        if (begin == len) {
            return k > 2;
        }

        long num3 = 0;
        for (int i = begin; i < len; i++) {
            num3 = num3 * 10 + (charArray[i] - '0');
            if (i > begin && charArray[begin] == '0') {
                continue;
            }

            if (k >= 2 && num3 != (num1 + num2)) {
                continue;
            }
            if (dfs(charArray, len, i + 1, num2, num3, k + 1)) {
                return true;
            }
        }
        return false;
    }
}