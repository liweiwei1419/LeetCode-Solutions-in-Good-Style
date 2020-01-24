public class Solution {

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1};
        Solution solution = new Solution();
        int singleNumber = solution.singleNumber(nums);
        System.out.println(singleNumber);
    }
}
