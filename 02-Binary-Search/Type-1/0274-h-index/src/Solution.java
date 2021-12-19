public class Solution {

    public int hIndex(int[] citations) {
        int len = citations.length;
        // 最差情况下所有的论文被引用次数都为 0，所以下界是 0
        int left = 0;
        // 最好情况下，所有的论文的引用次数 >= 总共论文篇数，所以上界是论文总数
        int right = len;
        while (left < right) {
            // 猜论文篇数
            int mid = (left + right + 1) / 2;
            // 满足高引用的特点是：引用次数 >= 论文篇数
            // count 的含义是：大于等于 mid 的论文篇数
            int count = 0;
            for (int citation : citations) {
                if (citation >= mid) {
                    count++;
                }
            }

            if (count >= mid) {
                // 实际上大于等于 2 分的论文有 3 篇
                // [0,1,| 3,5,6]，说明答案至少是 2 篇，下一次搜索在区间 [mid..right]
                left = mid;
            } else {
                // 下一次搜索在区间 [left..mid - 1]
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] citations = new int[]{1, 3, 5, 7, 10, 13};
        Solution solution = new Solution();
        int res = solution.hIndex(citations);
        System.out.println(res);
    }


    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}