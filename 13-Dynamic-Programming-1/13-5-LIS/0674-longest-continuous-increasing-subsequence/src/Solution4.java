public class Solution4 {

    public int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        int res = 0;
        int i = 0;
        int j = 0;
        // 循环不变量 [i..j] 严格单调递增
        while (j < len) {
            if (j > 0 && nums[j - 1] >= nums[j]) {
                i = j;
            }
            res = Math.max(res, j - i + 1);
            j++;
        }
        return res;
    }
}
