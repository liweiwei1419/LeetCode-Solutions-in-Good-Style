import java.util.Arrays;

public class Solution2 {

    /**
     * 在 Solution 的基础上精简了一下，使得代码不要那么长，其实思路是一样的
     *
     * @param nums
     * @return
     */
    public String minNumber(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return "";
        }
        String[] numsStr = new String[len];
        for (int i = 0; i < len; i++) {
            numsStr[i] = nums[i] + "";
        }

        Arrays.sort(numsStr, (a, b) -> (a + b).compareTo(b + a));

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            builder.append(numsStr[i]);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 32, 321};
        Solution2 solution = new Solution2();
        String printMinNumber = solution.minNumber(nums);
        System.out.println(printMinNumber);
    }
}