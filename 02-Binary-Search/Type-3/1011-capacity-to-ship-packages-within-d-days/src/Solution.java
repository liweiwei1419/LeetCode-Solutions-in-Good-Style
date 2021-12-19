public class Solution {

    // 题目意思：我们装载的重量不会超过船的最大运载重量。
    // 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。

    // 重点 1：货物必须按照给定的顺序装运
    // 重点 2：最低运载能力：表示超过了就要另外起一艘航船

    // 分析：运载能力最低是数组 weights 中的最大值，至少得拉走一个
    // 最高是数组 weights 中的和

    // 这里需要作图说明

    public int shipWithinDays(int[] weights, int D) {
        int maxVal = 0;
        int sum = 0;

        for (int weight : weights) {
            maxVal = Math.max(maxVal, weight);
            sum += weight;
        }

        int left = maxVal;
        int right = sum;
        while (left < right) {
            // 运载能力
            int mid = left + (right - left ) / 2;
            // 运载能力越大，天数越少
            // 运载能力越小，天数越多
            // 负相关
            if (calculateDays(weights, mid) > D) {
                // 太多，下一轮搜索区间 [mid + 1, right]
                left = mid + 1;
            } else {
                // 下一轮搜索区间 [left, mid]
                right = mid;
            }
        }
        return left;
    }

    /**
     * 返回多少天
     *
     * @param weights
     * @param capacity
     * @return
     */
    private int calculateDays(int[] weights, int capacity) {
        int days = 1;
        int currentWeightSum = 0;
        for (int weight : weights) {
            if (currentWeightSum + weight > capacity) {
                currentWeightSum = 0;
                days++;
            }
            currentWeightSum += weight;
        }
        return days;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] weights = new int[]{5,5,5,5,5,5,5,5,5,5};
        int D = 8;
        int res = solution.shipWithinDays(weights, D);
        System.out.println(res);
    }
}