import java.util.Arrays;

public class Solution {

    public int[] plusOne(int[] digits) {
        int len = digits.length;
        if (len == 0) {
            return new int[0];
        }
        int carry = 1;
        // 就想我们手动做加法一样，从后向前
        for (int i = len - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
            // 如果不产生进位，马上就可以返回了
            // 有了这一步判断，就不必遍历完整个数组了
            if (carry == 0) {
                return digits;
            }
        }
        if (carry == 1) {
            int[] res = new int[len + 1];
            res[0] = 1;
            for (int i = 1; i < len + 1; i++) {
                res[i] = digits[i - 1];
            }
            return res;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] nums = {9, 9, 9, 9};
        Solution solution = new Solution();
        int[] plusOne = solution.plusOne(nums);
        System.out.println(Arrays.toString(plusOne));
    }
}
