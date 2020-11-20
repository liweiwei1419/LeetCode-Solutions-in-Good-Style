public class Solution2 extends GuessGame {

    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int guessNum = guess(mid);
            if (guessNum == 0) {
                return mid;
            } else if (guessNum == -1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}