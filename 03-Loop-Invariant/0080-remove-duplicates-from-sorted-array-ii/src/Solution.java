public class Solution {

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len < 2){
            return len;
        }

        // 循环不变量：nums[0..j) 是有序的，并且相同元素最多保留 2 次
        // j 指向下一个要赋值的元素的位置
        int j = 2;
        for (int i = 2; i < len; i++) {
            if (nums[i] != nums[j - 2]){
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}