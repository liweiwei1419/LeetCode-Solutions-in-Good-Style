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

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int n = 10;
        int guessNumber = solution2.guessNumber(n);
        System.out.println(guessNumber);
    }
}


