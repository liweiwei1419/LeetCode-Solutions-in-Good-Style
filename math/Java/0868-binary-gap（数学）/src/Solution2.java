public class Solution2 {

    // 参考了官方解答：
    // https://leetcode-cn.com/articles/binary-gap/

    public int binaryGap(int N) {
        int pre = -1;
        int res = 0;
        int mask = 1;
        // 因为是正数，所以左移 30 位就够了
        for (int i = 0; i < 31; i++) {
            if ((N & mask) != 0) {
                if (pre >= 0) {
                    res = Math.max(res, i - pre);
                }
                pre = i;
            }
            mask <<= 1;
        }
        return res;
    }
}
