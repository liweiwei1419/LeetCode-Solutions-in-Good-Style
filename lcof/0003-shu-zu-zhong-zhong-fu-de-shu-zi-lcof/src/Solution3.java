public class Solution3 {

    public int findRepeatNumber(int[] nums) {
        int hash = 0;
        for (int num : nums) {
            if (((hash >> num) & 1) == 1) {
                return num;
            }
            hash ^= (1 << num);
        }
        throw new IllegalArgumentException("数组中没有重复的数字");
    }


    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        int res = solution3.findRepeatNumber(nums);
        System.out.println(res);
    }
}
