public class Solution {

    // 思想：双指针
    // 空间复杂度：O(N)
    // 时间复杂度：O(1)

    public boolean increasingTriplet(int[] nums) {
        // 注意：两个都是小于等于
        int one = Integer.MAX_VALUE;
        int two = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= one) {
                one = num;
            } else if (num <= two) {
                // 执行到这里一定有 num > one
                two = num;
            } else {
                // 执行到这里一定有 num > two > one
                return true;
            }
        }
        return false;
    }
}