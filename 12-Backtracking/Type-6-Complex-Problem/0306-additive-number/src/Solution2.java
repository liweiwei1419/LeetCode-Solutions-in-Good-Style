import java.math.BigInteger;

public class Solution2 {

    // 参考资料：https://leetcode-cn.com/problems/additive-number/solution/dfs-backtracking-pruning-you-gao-liao-yi-ge-xiao-s/

    public boolean isAdditiveNumber(String num) {
        int len = num.length();
        char[] charArray = num.toCharArray();
        return dfs(charArray, len, 0, new BigInteger("0"), new BigInteger("0"), 0);
    }

    private boolean dfs(char[] charArray, int len, int begin, BigInteger num1, BigInteger num2, int k) {
        if (begin == len) {
            return k > 2;
        }

        BigInteger num3 = new BigInteger("0");
        for (int i = begin; i < len; i++) {
            num3 = num3.multiply(new BigInteger("10")).add(new BigInteger(String.valueOf(charArray[i])));
            if (i > begin && charArray[begin] == '0') {
                continue;
            }

            if (k >= 2 && num3.compareTo(num1.add(num2)) != 0) {
                continue;
            }
            if (dfs(charArray, len, i + 1, num2, num3, k + 1)) {
                return true;
            }
        }
        return false;
    }
}