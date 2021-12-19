public class Solution {

    // 选择中位数和右边界元素比较，其实跟左边界元素比较也是可以的

    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }

        int left = 0;
        int right = len - 1;
        while (left < right) {
            // 根据分支的逻辑将中间数改成上取整
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] < nums[right]) {
                // 此时 [mid..right] 有序
                if (nums[mid] <= target && target <= nums[right]) {
                    // 如果 target 的值落在这个区间里，下一轮搜索区间是 [mid..right]，此时设置 left = mid;
                    left = mid;
                } else {
                    // 否则，下一轮搜索区间是 [left..mid - 1]，此时设置 right = mid - 1;
                    right = mid - 1;
                }
            } else {
                // 此时 nums[mid] >= nums[right]，注意此时 mid 可能与 right 重合
                // 数组前半部分有序，即 [left..mid] 有序，为了与上一个分支的逻辑一致，认为 [left..mid - 1] 有序
                if (nums[left] <= target && target <= nums[mid - 1]) {
                    // 如果 target 的值落在区间 [left..mid - 1] 里，设置 right = mid - 1;
                    right = mid - 1;
                } else {
                    // 否则，下一轮搜索区间是 [mid..right]，此时设置 left = mid;
                    left = mid;
                }

                // 补充说明：由于中间数上取整，在区间只剩下两个元素的时候，mid 与 right 重合，逻辑走到 else 分支里
                // 此时恰好 if 这个分支看到的是 left 和 mid - 1 ，用到的都是 == 号，等价于判断 nums[left] == target
                // 因此依然可以缩减区间，注意这里 if 里面的 nums[left] <= target && target <= nums[mid - 1] ，
                // 不可以写成 nums[left] <= target && target < nums[mid]
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }
}