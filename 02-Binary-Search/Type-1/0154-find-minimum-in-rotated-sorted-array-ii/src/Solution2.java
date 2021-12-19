public class Solution2 {

    public int findMin(int[] nums) {
        // 在 nums[left..right] 里查找目标元素
        return findMin(nums, 0, nums.length - 1);
    }

    private int findMin(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = (left + right) / 2;
        if (nums[mid] == nums[right]) {
            return findMin(nums, left, right - 1);
        } else if (nums[mid] < nums[right]) {
            // 下一轮搜索区间是 [left..mid]
            return findMin(nums, left, mid);
        } else {
            // 下一轮搜索区间是 [mid + 1..right]
            return findMin(nums, mid + 1, right);
        }
    }

    public static void main(String[] args) {
        // 声明成 int，打印出来的就是 ASCII 值
        int a = '0';
        int b = '6';

        System.out.println(a);
        System.out.println(b);
        System.out.println(b - a);
    }
}