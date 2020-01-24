public class Solution {

    public int findNumbers(int[] nums) {
        int res = 0;
        for (int num : nums) {
            int count = countDigit(num);
            if ((count & 1) == 0) {
                res += 1;
            }
        }
        return res;
    }

    private int countDigit(int num) {
        int count = 0;
        while (num > 0) {
            count += 1;
            num /= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {555, 901, 482, 1771};
        Solution solution = new Solution();
        int res = solution.findNumbers(nums);
        System.out.println(res);
    }
}
