/**
 * @author liwei
 * @date 2019/7/22 10:37 AM
 */
public class Solution4 {

    // 3 种写法本质上都是一样：滑动窗口
    public int minSubArrayLen2(int s, int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int l = 0;
        int segmentSum = 0;
        int minSubArrayLen = len + 1;
        for (int i = 0; i < len; i++) {

            segmentSum += nums[i];
            while (segmentSum >= s) {
                minSubArrayLen = Integer.min(minSubArrayLen, i - l + 1);
                segmentSum -= nums[l];
                l++;
            }
        }
        if (minSubArrayLen == len + 1) {
            return 0;
        }
        return minSubArrayLen;
    }
}
