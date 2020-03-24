public class Solution2 {

    // 超时

    public boolean judgeSquareSum(int c) {
        if (c < 0) {
            return false;
        }
        if (c == 0 || c == 1) {
            return true;
        }
        int half = c / 2;
        for (int i = 1; i <= half; i++) {
            if (helper(c - i * i)) {
                return true;
            }
        }
        return false;
    }

    private boolean helper(int c) {
        if (c < 0) {
            return false;
        }
        if (c == 0 || c == 1) {
            return true;
        }
        long l = 1;
        long r = c / 2;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            long square = mid * mid;
            if (square == c) {
                return true;
            } else if (square < c) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}
