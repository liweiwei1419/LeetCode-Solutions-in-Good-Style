public class Solution {

    // 本题利用的单调性如下：
    // 等待天数越多，可以用于制作的花束就越多
    // 等待天数越少，可以用于制作的花束就越少

    public int minDays(int[] bloomDay, int m, int k) {
        int len = bloomDay.length;
        if (m * k > len) {
            return -1;
        }

        // 二分等待天数 waitingDays
        int left = 0;
        int right = 0;
        for (int day : bloomDay) {
            right = Math.max(right, day);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            // 找大于等于 m 的最少天数
            int flowers = calculateFlowers(bloomDay, mid, k);
            // System.out.println("mid => " + mid + " 结果 => " + flowers);
            if (flowers < m) {
                // 小于 m 的时候，一定不是解，等待的天数需要增加，因此下一轮搜索区间是 [mid + 1, right]
                left = mid + 1;
            } else {
                // 大于等于 m 的时候，题目问「摘 m 束花需要等待的最少的天数」，当前有可能是最少的天数，因此下一轮搜索区间是 [left, mid]
                right = mid;
            }
        }
        return left;
    }

    /**
     * @param bloomDay
     * @param waitingDays
     * @param k
     * @return 可以制作多少束花
     */
    private int calculateFlowers(int[] bloomDay, int waitingDays, int k) {
        // 当前连续的花朵数
        int count = 0;
        int flowers = 0;

        // needDays 意即：当前这束花盛开需要的天数
        for (int needDays : bloomDay) {
            // 当前这束花盛开需要的天数 <= 需要等待的天数，此时这朵花盛开
            if (needDays <= waitingDays) {
                count++;
            } else {
                // 否则这束花没有开放，连续的花朵数就要重新计算
                count = 0;
                continue;
            }

            // 如果连续的花朵数恰好等于 k，就可以用于制作一束花
            if (count == k) {
                flowers++;
                count = 0;
            }
        }
        return flowers;
    }
}