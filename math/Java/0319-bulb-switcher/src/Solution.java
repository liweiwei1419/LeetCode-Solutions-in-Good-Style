import java.util.Arrays;

public class Solution {

    public int bulbSwitch(int n) {
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j < n; j += i) {
                nums[j] ^= 1;
            }
            System.out.println(Arrays.toString(nums));
        }

        int res = 0;
        for (int num : nums) {
            res += num;
        }
        return res;
    }


    public static void main(String[] args) {
        int n = 8;
        Solution solution = new Solution();
        int res = solution.bulbSwitch(n);
        System.out.println(res);

    }
}
