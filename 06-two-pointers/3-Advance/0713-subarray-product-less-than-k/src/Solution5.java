public class Solution5 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int len = nums.length;
        int product = 1;

        int left = 0;
        int right = 0;
        int res = 0;
        while (right < len) {
            product *= nums[right];
            right++;
            while (product >= k) {
                product /= nums[left];
                left++;
            }

            res += (right - left);
            System.out.println("product = " + product);
            System.out.println("res += " + (right - left));
        }
        return res;
    }

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        int[] nums = new int[]{10, 5, 2, 6};
        int k = 100;
        int res = solution5.numSubarrayProductLessThanK(nums, k);
        System.out.println(res);
    }
}