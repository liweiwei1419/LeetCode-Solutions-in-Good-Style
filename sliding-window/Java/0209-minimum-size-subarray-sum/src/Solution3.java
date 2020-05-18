public class Solution3 {

    // 与上面的写法相同，只是边界条件设置不一样

    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        int left = 0;
        int right = 0;
        int minSubArrayLen = len + 1;
        int segmentSum = 0;
        for (int num : nums) {
            segmentSum += num;
            right++;
            // 注意：根据题意"找出该数组中满足其和 ≥ s 的长度最小的子数组"
            // 注意这个边界条件
            while (segmentSum >= s) {
                minSubArrayLen = Integer.min(minSubArrayLen, right - left);
                segmentSum -= nums[left];
                left++;
            }
        }

        if (minSubArrayLen == len + 1) {
            return 0;
        }
        return minSubArrayLen;
    }
}
