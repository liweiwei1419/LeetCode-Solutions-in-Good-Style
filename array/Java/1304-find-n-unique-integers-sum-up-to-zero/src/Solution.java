import java.util.Arrays;

public class Solution {

    public int[] sumZero(int n) {
        int[] nums = new int[n];

        int half = n / 2;
        for (int i = 0; i < half; i++) {
            nums[i] = i + 1;
            nums[n - 1 - i] = -(i + 1);
        }

        return nums;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 4;
        int[] res = solution.sumZero(n);
        System.out.println(Arrays.toString(res));
    }
}
