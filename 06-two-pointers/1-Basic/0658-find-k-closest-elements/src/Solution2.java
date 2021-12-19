import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int len = arr.length;
        if (len < k) {
            return new ArrayList<>();
        }

        int left = 0;
        int right = len - k;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid + k] - x >= x - arr[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        List<Integer> res = new ArrayList<>(k);
        for (int i = left; i < left + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}
