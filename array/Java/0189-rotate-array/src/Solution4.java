import java.util.Arrays;

public class Solution4 {

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        while (n > 0 && k > 0) {
            if (k > n) {
                k %= n;
            }
            int last = n - k + i;
            for (int offset = 0; offset < k; offset++) {
                // System.out.println(Arrays.toString(nums) + " i = " + i + ", last = " + last);
                swap(nums, i + offset, last + offset);
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
        Solution4 solution3 = new Solution4();
        solution3.rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
