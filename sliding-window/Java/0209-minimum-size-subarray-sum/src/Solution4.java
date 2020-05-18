public class Solution4 {


    public int minSubArrayLen2(int s, int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int left = 0;
        int segmentSum = 0;
        int minSubArrayLen = len + 1;
        for (int right = 0; right < len; right++) {
            segmentSum += nums[right];
            while (segmentSum >= s) {
                minSubArrayLen = Integer.min(minSubArrayLen, right - left + 1);
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
