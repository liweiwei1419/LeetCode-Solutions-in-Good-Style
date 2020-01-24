public class Solution3 {

    public boolean isAdditiveNumber(String num) {
        int len = num.length();
        return dfs(num, 0, len, 0, 0, 0);
    }

    private boolean dfs(String num, int start, int len, long preSum, long curNum, int split) {
        // 分割数要严格大于 2 并且 start 恰好在末尾
        if (split > 2 && start == len) {
            return true;
        }

        for (int i = 0; i + start < len; i++) {
            long newNum = calculateCurSum(num, start, start + i, preSum, split);
            // 这里判断得是大于等于 0，特例 "1,0,1"
            if (newNum >= 0) {
                // 此时 累计和 + 当前新数成为新的累计和，当前数更新
                if (dfs(num, start + i + 1, len, newNum + curNum, newNum, split + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * @param num
     * @param left
     * @param right
     * @param preSum
     * @param split 当 split 小于 2 的时候，直接返回这个区间里的数
     * @return num[left:right] 转换为长整型以后，是不是等于 preSum，如果不是返回 - 1，如果是，返回这个数
     */
    private long calculateCurSum(String num, int left, int right, long preSum, int split) {
        if (num.charAt(left) == '0' && left < right) {
            return -1;
        }

        long curSum = 0;
        while (left <= right) {
            curSum = curSum * 10 + num.charAt(left) - '0';
            left++;
        }
        if (split < 2) {
            return curSum;
        }

        if (preSum == curSum) {
            return curSum;
        }

        return -1;
    }

    public static void main(String[] args) {
        String num = "112358";
        // String num = "19910011992";
        Solution3 solution3 = new Solution3();
        boolean res = solution3.isAdditiveNumber(num);
        System.out.println(res);
    }
}
