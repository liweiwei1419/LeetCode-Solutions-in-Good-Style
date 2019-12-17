/**
 * @author liweiwei1419
 * @date 2019/10/10 6:58 下午
 */
public class Solution {

    /**
     * 选择排序
     *
     * @param nums
     * @return
     */
    public int thirdMax(int[] nums) {
        int len = nums.length;
        int max1 = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] > max1) {
                max1 = nums[i];
            }
        }

        int max2 = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            if (nums[i] != max1 && nums[i] > max2) {
                max2 = nums[i];
            }
        }

        int max3 = Integer.MIN_VALUE;
        int counter = 0;
        for (int i = 0; i < len; i++) {
            // 注意：这里是大于等于
            if (nums[i] != max1 && nums[i] != max2 && nums[i] >= max3) {
                max3 = nums[i];
                counter++;
            }
        }

        // 如果没有第 3 大的数，返回最大的那个数
        if (counter == 0) {
            return max1;
        }
        return max3;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 5, 3, 5};
        Solution solution = new Solution();
        int res = solution.thirdMax(nums);
        System.out.println(res);
    }
}
