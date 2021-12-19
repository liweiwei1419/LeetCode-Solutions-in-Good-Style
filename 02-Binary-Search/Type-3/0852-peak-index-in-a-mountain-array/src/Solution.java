public class Solution {

    public int peakIndexInMountainArray(int[] arr) {
        int len = arr.length;
        int left = 1;
        int right = len - 2;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < arr[mid + 1]) {
                // 下一轮搜索区间在 [mid + 1..right]
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}