public class Solution4 {

    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int left = 1;
        // 注意这里的边界
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            int count = 0;
            for (int num : nums) {
                if (num < mid) {
                    count++;
                }
            }
            // 容易出错，需要仔细分析
            if (count < mid) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}