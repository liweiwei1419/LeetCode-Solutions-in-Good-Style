import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public int[] decompressRLElist(int[] nums) {
        int len = nums.length;
        List<Integer> res = new ArrayList<>(len);

        for (int i = 0; i < len / 2; i++) {
            int count = nums[2 * i];
            int val = nums[2 * i + 1];

            for (int j = 0; j < count; j++) {
                res.add(val);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        Solution solution = new Solution();
        int[] res = solution.decompressRLElist(nums);
        System.out.println(Arrays.toString(res));
    }
}
