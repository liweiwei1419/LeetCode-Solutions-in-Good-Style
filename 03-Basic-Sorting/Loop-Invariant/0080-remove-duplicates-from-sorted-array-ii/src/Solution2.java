public class Solution2 {

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return len;
        }

        // 循环不变量：[0, j) 是最终返回的数组
        // 初始化的时候，前 2 位有效
        // [0, 1, 1, 1, 2, 2, 2, 2, 3, 3, 4]
        //           j
        //              i
        // j 指向下一个要填写的元素
        int j = 2;
        for (int i = 2; i < len; i++) {
            if (nums[i] != nums[j - 2]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}