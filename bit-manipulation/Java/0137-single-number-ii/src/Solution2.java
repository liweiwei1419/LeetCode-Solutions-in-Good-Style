public class Solution2 {

    public int singleNumber(int[] nums) {
        int res = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            mask = 1 << i;
            int count = 0;
            for (int num : nums) {
                if ((num & mask) != 0) {
                    count++;
                }
            }
            if (count % 3 != 0) {
                res |= mask;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] nums = {1, 1, 1, 2, 2, 2, 3, 3, 3, 5};
        // int[] nums = {-2, -2, 1, 1, -3, 1, -3, -3, -4, -2};
        int singleNumber = solution2.singleNumber(nums);
        System.out.println(singleNumber);
    }
}
