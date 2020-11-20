public class Solution {

    public int maxTurbulenceSize(int[] A) {
        int len = A.length;
        if (len == 1) {
            return 1;
        }
        int res = 1;
        int left = 0;
        int right = 1;
        boolean isde = false;
        while (right < len) {
            if (A[right] == A[right - 1]) {
                left = right;
                right++;
            } else if (right - left == 1 || (A[right] - A[right - 1] < 0 != isde)) {
                isde = A[right] - A[right - 1] < 0;
                res = Math.max(res, right - left + 1);
                right++;
            } else {
                left = right - 1;
            }
        }
        return res;
    }
}