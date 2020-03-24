/**
 * @author liweiwei1419
 * @date 2019/9/20 12:16 下午
 */
public class Solution3 {

    // 关键词是连续

    /**
     * 构建前缀和数组，以空间换时间
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        int res = 0;
        for (int left = 0; left < len; left++) {
            for (int right = left + 1; right <= len; right++) {
                if (preSum[right] - preSum[left] == k) {
                    res++;
                }
            }
        }
        return res;
    }

}
