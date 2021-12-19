import java.util.Arrays;

public class Solution {

    public int arrayPairSum(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < len; i += 2) {
            res += nums[i];
        }
        return res;
    }
}