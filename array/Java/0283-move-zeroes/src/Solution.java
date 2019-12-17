/**
 * @author liweiwei1419
 * @date 2019/10/13 2:24 上午
 */
public class Solution {

    // 循环不变式：[0, i) 非零

    public void moveZeroes(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return;
        }

        int next = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                nums[next] = nums[i];
                next++;
            }
        }

        for (int i = next; i < len; i++) {
            nums[next] = 0;
            next++;
        }
    }
}
