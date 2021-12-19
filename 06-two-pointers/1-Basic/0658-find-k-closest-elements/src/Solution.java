import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int len = arr.length;
        if (len < k) {
            return new ArrayList<>();
        }

        int cnt = len - k;
        int left = 0;
        int right = len - 1;
        for (int i = 0; i < cnt; i++) {
            if (x - arr[left] < arr[right] - x) {
                right--;
            } else if (x - arr[left] > arr[right] - x) {
                left++;
            } else {
                right--;
            }
        }

        List<Integer> res = new ArrayList<>(k);
        for (int i = left; i < left + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}
