/**
 * @author liweiwei1419
 * @date 2019/11/2 9:13 上午
 */
public class Solution4 {

    // 已知：你可以假设数组是非空的，并且给定的数组总是存在众数。
    // 摩尔投票法，有点像玩消消乐一样

    public int majorityElement(int[] nums) {
        int res = 0;
        int count = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (count == 0) {
                res = nums[i];
            }
            if (res == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return res;
    }
}