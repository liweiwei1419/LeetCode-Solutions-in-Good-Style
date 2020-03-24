public class Main {

    // 二分法测试代码
    private static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        // 这里一定是等于号
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5, 8, 12, 13, 15};
        int target = 14;
        // 我要返回的是 6

        int index = binarySearch(nums, target);
        System.out.println(nums[index]);
    }
}
