/**
 * 二分查找
 *
 * @author liwei
 * @date 2019/8/29 12:55 PM
 */
public class Solution {
    public int splitArray(int[] nums, int m) {
        // 考虑分割的两个极端：1、不分割；2、每个数成为 1 个子数组
        // 1、不分割，因为就一个子数组：子数组各自的和的最大值 = sum(nums)
        // 2、每个数成为 1 个子数组：子数组各自的和的最大值 = max(nums)

        // 遍历一次得到数组的最大值与数组所有元素的和
        int max = 0;
        int sum = 0;

        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        // "子数组各自的和的最大值"介于 [max, sum] 之间
        // 一个重要的性质：分割数越大，"子数组各自的和的最大值"就越小（非递增，满足单调性），
        // 因此可以使用二分查找，定位分割数

        // 一种"分割方案（分成几个子数组）"对应了一个"子数组各自的和的最大值"
        // 反过来，一个"子数组各自的和的最大值"对应了一种"分割方案（分成几个子数组）"
        // 它们是一一对应的（关键）

        // 二分搜索的思路如下：先找"子数组各自的和的最大值"的中位数，看看它对应的"分割方案（分成几个子数组）"是多少
        // 如果"分割方案（分成几个子数组）"比题目要求的 m 还多，说明"子数组各自的和的最大值"较小，
        // 所以下一次搜索应该至少是中位数 + 1（left = mid + 1），它的反面即至多是中位数（right = mid）

        int left = max;
        int right = sum;

        while (left < right) {
            int mid = (left + right) >>> 1;
            int splits = split(nums, mid);
            if (splits > m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    /***
     *
     * @param nums 原始数组
     * @param maxSum 子数组各自的和的最大值
     * @return 满足不超过"子数组各自的和的最大值"的分割数
     */
    private int split(int[] nums, int maxSum) {
        // 至少是一个分割
        int splits = 1;
        int tempSum = 0;
        for (int num : nums) {
            // 尝试加上当前遍历的这个数，如果加上去超过了"子数组各自的和的最大值"，就不加这个数，另起炉灶
            if (tempSum + num > maxSum) {
                tempSum = 0;
                splits++;
            }
            tempSum += num;
        }
        return splits;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7, 2, 5, 10, 8};
        int m = 2;
        Solution solution = new Solution();
        int res = solution.splitArray(nums, m);
        System.out.println(res);
    }
}
