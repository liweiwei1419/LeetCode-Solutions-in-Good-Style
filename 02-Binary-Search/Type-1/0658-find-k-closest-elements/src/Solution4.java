import java.util.ArrayList;
import java.util.List;

public class Solution4 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int size = arr.length;
        int left = 0;
        int right = size - k;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 尝试从长度为 k + 1 的连续子区间删除一个元素，从而定位左区间端点的边界值
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}