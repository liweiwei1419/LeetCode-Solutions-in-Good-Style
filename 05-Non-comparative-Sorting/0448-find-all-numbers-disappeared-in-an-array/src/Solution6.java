import java.util.ArrayList;
import java.util.List;

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
}