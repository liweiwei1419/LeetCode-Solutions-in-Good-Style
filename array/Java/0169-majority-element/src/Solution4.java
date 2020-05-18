public class Solution4 {

    // 已知：你可以假设数组是非空的，并且给定的数组总是存在众数。
    // 摩尔投票法，有点像玩消消乐一样

    public int majorityElement(int[] nums) {
        int res = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                res = num;
            }
            if (res == num) {
                count++;
            } else {
                count--;
            }
        }
        return res;
    }
}