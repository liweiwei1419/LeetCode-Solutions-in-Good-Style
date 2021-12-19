public class Solution6 {

    public int reversePairs(int[] nums) {
        int count = 0;
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();
        int[] nums = new int[]{8, 7, 6, 5, 4, 3, 2, 1};
        int res = solution6.reversePairs(nums);
        System.out.println(res);
    }
}
