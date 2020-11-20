import java.util.ArrayList;
import java.util.List;

public class Solution {

    // 双指针
    // 时间复杂度：O(N)
    // 空间复杂度：O(1)，不计保存结果集使用的空间

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int size = arr.length;
        int left = 0;
        int right = size - 1;
        int removeNums = size - k;
        while (removeNums > 0) {
            if (x - arr[left] <= arr[right] - x) {
                right--;
            } else {
                left++;
            }
            removeNums--;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}