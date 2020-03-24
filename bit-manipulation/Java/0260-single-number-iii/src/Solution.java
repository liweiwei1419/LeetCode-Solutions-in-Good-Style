public class Solution {

    public int[] singleNumber(int[] nums) {
        int axorb = 0;
        for (int num : nums) {
            axorb ^= num;
        }

        // n & (n - 1) 将从右边到左边的第 1 个 1 变成 0
        // n & (~(n - 1)) 只保留从右边到左边的第 1 个 1（本题使用技巧）
        int flag = axorb & (~(axorb - 1));
        int[] res = new int[2];
        for (int num : nums) {
            if ((num & flag) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }
}
