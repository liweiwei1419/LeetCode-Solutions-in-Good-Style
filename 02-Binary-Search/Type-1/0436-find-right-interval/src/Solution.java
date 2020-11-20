import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] findRightInterval(int[][] intervals) {
        int len = intervals.length;
        if (len == 0) {
            return new int[0];
        }

        // 对原始区间进行预处理，key：起点，value：索引
        // 题目中说：你可以假定这些区间都不具有相同的起始点
        Map<Integer, Integer> hashMap = new HashMap<>(len);

        int[] arr = new int[len];
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            hashMap.put(intervals[i][0], i);
            arr[i] = intervals[i][0];
        }

        Arrays.sort(arr);
        for (int i = 0; i < len; i++) {
            int index = binarySearch(arr, intervals[i][1]);
            if (index == -1) {
                res[i] = -1;
            } else {
                res[i] = hashMap.get(arr[index]);
            }
        }
        return res;
    }

    /**
     * 查找第 1 个大于等于 target 的元素的索引
     *
     * @param arr
     * @param target
     * @return
     */
    private int binarySearch(int[] arr, int target) {
        int len = arr.length;
        // 特判
        if (arr[len - 1] < target) {
            return -1;
        }

        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}