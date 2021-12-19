import java.util.HashMap;
import java.util.Map;

public class Solution4 {

    public int maxSubArrayLen(int[] arr, int k) {
        int len = arr.length;
        int[] preSum = new int[len + 1];
        for (int i = 0; i <= len; i++) {
            preSum[i + 1] = preSum[i] + arr[i];
        }

        Map<Integer, Integer> map = new HashMap<>();
        // right - left = k
        // left = right - k
        int res = 0;
        int right;
        for (int i = 0; i <= len; i++) {
            right = preSum[i];
            int left = right - k;
            if (map.containsKey(left)) {
                res = Math.max(res, i - map.get(left));
            }
            map.putIfAbsent(right, i); // make current right as left for later retrieve
        }
        return res;
    }
}
