public class Solution {

    public void moveZeroes(int[] nums) {
        int len = nums.length;

        // 循环不变量：nums[0..j) !=0, nums[j..i) = 0
        // j 指向了下一个要赋值的元素的位置
        int j = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }

        for (int i = j; i < len; i++) {
            nums[i] = 0;
        }
    }
}