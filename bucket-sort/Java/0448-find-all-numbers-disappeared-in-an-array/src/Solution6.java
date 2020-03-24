import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liweiwei1419
 * @date 2019/10/11 12:13 下午
 */
public class Solution6 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        for (int i = 0; i < len; i++) {
            int index = (nums[i] - 1) % len;
            // System.out.println(i + " " +index + " " + (nums[i] - 1));
            nums[index] += len;
            // System.out.println(Arrays.toString(nums));
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] <= len) {
                res.add(i + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        Solution2 solution2 = new Solution2();
        List<Integer> res = solution2.findDisappearedNumbers(nums);
        System.out.println(res);
    }
}
