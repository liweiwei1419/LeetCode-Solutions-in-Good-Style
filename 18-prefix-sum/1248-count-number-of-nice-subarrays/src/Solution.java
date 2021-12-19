public class Solution {

    // 方法一：前缀和

    public int numberOfSubarrays(int[] nums, int k) {
        int len = nums.length;
        // preSum[i] 前缀和为 i 出现的次数
        int[] preSum = new int[len + 1];
        // 表示前缀和为 0 的个数为 1，1 是乘法单位元
        preSum[0] = 1;

        // 目前为止看到的奇数的个数
        int odd = 0;
        int res = 0;
        for (int num : nums) {
            odd += num & 1;
            if (odd >= k) {
                // 注意：有一个单位的偏移
                res += preSum[odd - k];
            }
            preSum[odd]++;
        }
        return res;
    }
}