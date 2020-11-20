public class Solution {

    public int hIndex(int[] citations) {
        // 单调性 [i, len - 1] 一共有论文 len - 1 - i + 1 = len - i 篇
        // 找到最小的 i 使得 nums[i] >= len - i
        int len = citations.length;
        if (len == 0 || citations[len - 1] == 0) {
            return 0;
        }

        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] > len - mid) {
                right = mid;
            } else if (citations[mid] == len - mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return len - left;
    }
}