public class Solution {

    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        if (len == 0) {
            return len;
        }

        // 循环不变量：nums[0..j) != val
        // j 指向了下一个要赋值的元素的位置
        int j = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
