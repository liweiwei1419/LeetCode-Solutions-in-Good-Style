import java.util.ArrayList;
import java.util.List;

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
}