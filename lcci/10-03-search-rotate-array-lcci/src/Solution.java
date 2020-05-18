public class Solution {

    public int search(int[] nums, int target) {
        int len = nums.length;

        // 题目给的数据保证数组非空，因此无需再判断

        int left = 0;
        int right = len - 1;
        while (left < right) {

            int mid = (left + right) >>> 1;

            // 调试代码
            // System.out.println("left = " + left + " right = " + right + " mid = " + mid +  " nums[mid] = " + nums[mid]);

            if (nums[mid] < nums[right]) {
                // 此时 [mid, right] 这个区间一定有序

                // 注意：为了让边界收缩行为一直，这里 nums[mid] < target 不取等号，这样才能凑出 left = mid + 1 和后面的分支统一
                if (nums[mid] < target && target <= nums[right]) {
                    // 下一轮搜索区间是 [mid + 1, right]，设置 left = mid
                    left = mid + 1;
                } else {
                    // if 的反面，下一轮搜索区间是 [left, mid]
                    right = mid;
                }

            } else if (nums[mid] > nums[right]) {
                // 此时 [left, mid] 一定有序

                if (nums[left] <= target && target <= nums[mid]) {
                    // 下一轮搜索区间是 [left, mid]
                    right = mid;
                } else {
                    // if 的反面，下一轮搜索区间是 [mid + 1, right]
                    left = mid + 1;
                }
            } else {
                // 此时 nums[mid] == nums[right]

                if (nums[mid] == target) {
                    // {2, 1, 2, 2, 2}; target = 2
                    // mid 的右边一定不是解，下一轮搜索的区间是 [left, mid]
                    right = mid;
                } else {
                    // target = 1
                    // {2, 1, 2, 2, 2};
                    // {2, 2, 2, 1, 2};

                    // 根据上面的例子，只能把 right 这个位置排除掉，下一轮搜索的区间是 [left, right - 1]
                    right--;
                }
            }
        }

        // 有可能区间内不存在目标元素，因此还需做一次判断
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] nums = {21, 21, -21, -20, -17, -8, -6, -2, -2, -1, 0, 2, 3, 4, 4, 6, 11, 13, 14, 16, 17, 18, 20};
//        int target = 4;

        // int[] nums = {2, 1, 2, 2, 2};
        int[] nums = {2, 1, 2};
        int target = 2;
        int res = solution.search(nums, target);
        System.out.println(res);
    }
}
