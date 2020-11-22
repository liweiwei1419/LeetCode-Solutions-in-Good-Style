public class Solution {

    // 方法一：赋值

    public void moveZeroes(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return;
        }

        int next = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                // 遵守循环不变式：[0, i) 非零，所以先赋值，后自增
                nums[next] = nums[i];
                next++;
            }
        }

        // 把剩下的部分设置为 0
        for (int i = next; i < len; i++) {
            nums[next] = 0;
            next++;
        }
    }
}