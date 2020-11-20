public class Solution4 {

    // 同 Solution2

    // 符合滑动窗口性质
    // 向右边扩散得到和越来越大
    // 向左边界扩散得到和越来越小

    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;

        int left = 0;
        int right = 0;

        int sum = 0;
        // 保持性质：[left, right) >= s
        int minLen = len + 1;
        while (right < len) {
            sum += nums[right];
            right++;

            while (sum >= s) {
                minLen = Math.min(minLen, right - left);

                sum -= nums[left];
                left++;
            }
        }

        if (minLen == len + 1) {
            return 0;
        }
        return minLen;
    }
}