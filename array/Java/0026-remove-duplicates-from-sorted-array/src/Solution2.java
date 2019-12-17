import java.util.Arrays;


public class Solution2 {

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        // 循环不变量：[0, j] 是移除重复元素以后的数组
        int j = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3, 3, 4, 4, 4};
        Solution2 solution = new Solution2();
        int ret = solution.removeDuplicates(nums);
        System.out.println(ret);
        System.out.println(Arrays.toString(nums));
    }
}
