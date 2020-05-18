import java.util.Arrays;

public class Solution3 {

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        while (n > 1 && k > 0) {

            k %= n;
            int last = n - k + i;
            for (int d = 0; d < k; d++) {
                // System.out.println(Arrays.toString(nums) + " i = " + i + ", last = " + last);
                swap(nums, i + d, last + d);
                // System.out.println(Arrays.toString(nums) + " i = " + i + ", last =" + last);
            }
            i += k;
            n -= k;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        int k = 5;
        Solution3 solution3 = new Solution3();
        solution3.rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
