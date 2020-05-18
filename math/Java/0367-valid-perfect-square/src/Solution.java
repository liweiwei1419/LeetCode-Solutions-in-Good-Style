public class Solution {

    public boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }

        int left = 1;
        int right = num / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (num % mid == 0 && num / mid == mid) {
                return true;
            } else if (num / mid > mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res = solution.isPerfectSquare(5);
        System.out.println(res);
    }
}
