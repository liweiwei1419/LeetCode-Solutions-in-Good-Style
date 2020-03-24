public class Solution {

    public boolean isPerfectSquare(int num) {
        if (num < 0) {
            return false;
        }
        if (num == 1) {
            return true;
        }
        long l = 1;
        long r = num / 2;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            long square = mid * mid;
            if (square == num) {
                return true;
            } else if (square < num) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean perfectSquare = solution.isPerfectSquare(0);
        System.out.println(perfectSquare);
    }
}
