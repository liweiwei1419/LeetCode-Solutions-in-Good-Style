public class Solution3 {

    // 双指针对撞 while 写法

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        throw new RuntimeException("在数组中没有找到这样的两个数，使得它们的和为指定值");
    }
}