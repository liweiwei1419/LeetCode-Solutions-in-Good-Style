/**
 * @author liwei
 * @date 18/6/29 下午4:50
 */
public class Solution3 {
    // 1,1,1,3,2
    public int majorityElement(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int count = 1;
        int res = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] == res) {
                count++;
            } else {
                // 此时 nums[i] != res
                count--;
                if (count == 0) {
                    res = nums[i];
                    // 这一步很关键
                    count = 1;
                }
            }
        }
        return res;
    }
}