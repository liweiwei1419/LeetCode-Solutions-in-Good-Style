class GuessGame {

    private static final int NUM = 6;

    int guess(int num) {
        if (num == NUM) {
            return 0;
        } else if (num < NUM) {
            return -1;
        }
        return 1;
    }
}

// 这道题题目的描述比较让人疑惑，能通过在线测评即可，不用深究

public class Solution extends GuessGame {

    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = (left + right + 1) >>> 1;
            if (guess(mid) == -1) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }
}