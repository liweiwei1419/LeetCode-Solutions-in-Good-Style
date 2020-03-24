import java.util.ArrayList;
import java.util.List;

/**
 * @author liwei
 * @date 2019/7/25 3:04 PM
 */
public class Solution2 {

    // 位图法，不符合题目要求

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        int map = 1 << len;

        // 调试代码
        // System.out.println(Integer.toBinaryString(map));
        for (int num : nums) {
            map |= 1 << (num - 1);
            // 调试代码
            // System.out.println(Integer.toBinaryString(map));
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (((map >> i) & 1) == 0) {
                res.add(i + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        Solution2 solution2 = new Solution2();
        List<Integer> res = solution2.findDisappearedNumbers(nums);
        System.out.println(res);
    }
}
