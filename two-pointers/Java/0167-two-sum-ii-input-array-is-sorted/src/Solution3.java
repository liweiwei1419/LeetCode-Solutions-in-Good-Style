import java.util.Arrays;

public class Solution {

    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int left = 0;
        int right = len - 1;
        int sum;

        while (left < right) {
            sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5, 8, 10, 2147483647};
        int target = 8;
        Solution solution = new Solution();
        int[] res = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(res));

    }
}
