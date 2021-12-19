public class Solution {

    // 国际版

    public int candy(int[] ratings) {
        int len = ratings.length;
        if (len == 0) {
            return 0;
        }


        int res = 1;
        int prev = 1;
        int countDown = 0;

        for (int i = 1; i < len; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                if (countDown > 0) {
                    res += countDown * (countDown + 1) / 2;
                    if (countDown >= prev) {
                        res += countDown - prev + 1;
                    }
                    countDown = 0;
                    prev = 1;
                }
                prev = ratings[i] == ratings[i - 1] ? 1 : prev + 1;
                res += prev;
            } else {
                countDown++;
            }
        }

        // if we were descending at the end
        if (countDown > 0) {
            res += countDown * (countDown + 1) / 2;
            if (countDown >= prev) {
                res += countDown - prev + 1;
            }
        }
        return res;
    }
}
