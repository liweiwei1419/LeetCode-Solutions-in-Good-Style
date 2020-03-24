/**
 * @author liweiwei1419
 * @date 2019/10/4 3:49 下午
 */
public class Solution2 {

    public int missingNumber(int[] nums) {
        int len = nums.length;
        int res = 0;

        for (int i = 0; i < len; i++) {
            res ^= nums[i];
        }

        for (int i = 1; i <= len; i++) {
            res ^= i;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};

        Solution2 solution2 = new Solution2();
        int res = solution2.missingNumber(nums);
        System.out.println(res);
    }
}
