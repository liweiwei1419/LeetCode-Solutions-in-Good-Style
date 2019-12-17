public class Solution2 {

    public int findMin(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            throw new IllegalArgumentException("数组为空");
        }
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] > nums[right]) {
                // 5 6 7 8 9 1 2
                // 此时可以扔掉 mid 的值
                left = mid + 1;
            } else {
                // 5 6 7 1 2 3 4
                assert nums[mid] < nums[right];
                // 此时 mid 有可能是最小值所在的索引
                right = mid;
            }
        }
        // 退出循环说明 left 与 right 相等，所以只剩一个元素可能，
        // 所以 return [left] 或者 return [right] 都可以了
        // 注意不能 return mid，可以从 {2,1} 这个输入看出来。
        return nums[left];
    }
}
