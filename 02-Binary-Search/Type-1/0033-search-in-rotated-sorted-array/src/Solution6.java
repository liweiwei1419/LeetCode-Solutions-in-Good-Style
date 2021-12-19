public class Solution6 {

    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }

        // 第一次「二分」：从中间开始找，找到满足 >=nums[0] 的分割点（旋转点）
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] >= nums[0]) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        // 第二次「二分」：通过和 nums[0] 进行比较，得知 target 是在旋转点的左边还是右边
        if (target >= nums[0]) {
            l = 0;
        } else {
            l = l + 1;
            r = n - 1;
        }

        System.out.println(l);
        System.out.println(r);

        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l] == target ? l : -1;
    }

    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();
        int[] nums = new int[]{1, 3};
        int target = 0;
        int res = solution6.search(nums, target);
        System.out.println(res);
    }
}
