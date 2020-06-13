public class Solution {

    // 速度越小，耗时越大，搜索的是速度
    // 会选择一堆香蕉，只能选择一堆，因此需要向上取整

    public int minEatingSpeed(int[] piles, int H) {
        int maxVal = 1;
        for (int pile : piles) {
            maxVal = Math.max(maxVal, pile);
        }

        // 速度最小的时候，耗时最长
        int left = 1;
        // 速度最大的时候，耗时最短
        int right = maxVal;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (calculateSum(piles, mid) > H) {
                // 耗时太多，说明速度太慢了，下一轮搜索区间在
                // [mid + 1, right]
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    /**
     * 如果返回的小时数严格大于 H，就不符合题意
     *
     * @param piles
     * @param speed
     * @return 需要的小时数
     */
    private int calculateSum(int[] piles, int speed) {
        int sum = 0;
        for (int pile : piles) {

            sum += pile / speed;
            if (pile % speed != 0) {
                sum += 1;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
//        int[] piles = {3, 6, 7, 11};
//        int H = 8;

//        int[] piles = {30, 11, 23, 4, 20};
//        int H = 5;

        int[] piles = {30, 11, 23, 4, 20};
        int H = 6;
        Solution solution = new Solution();
        int res = solution.minEatingSpeed(piles, H);
        System.out.println(res);
    }
}
