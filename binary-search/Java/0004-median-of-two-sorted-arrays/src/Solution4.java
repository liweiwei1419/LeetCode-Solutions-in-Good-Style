/**
 * 题解地址：https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/he-bing-yi-hou-zhao-gui-bing-guo-cheng-zhong-zhao-/
 *
 * @author liweiwei1419
 * @date 2019/7/18 8:46 AM
 */
public class Solution4 {

    // while (left < right) 的写法

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 为了让搜索范围更小，我们始终让 num1 是那个更短的数组，PPT 第 9 张
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        // 上述交换保证了 m <= n，在更短的区间 [0, m] 中搜索，会更快一些
        int m = nums1.length;
        int n = nums2.length;

        // 使用二分查找算法在数组 nums1 中搜索一个索引 i，PPT 第 9 张
        int left = 0;
        int right = m;

        // 因为 left_total 这个变量会一直用到，因此单独赋值，表示左边粉红色部分一共需要的元素个数
        int totalLeft = (m + n + 1) >>> 1;
        while (left < right) {
            // 尝试要找的索引，在区间里完成二分，为了保证语义，这里就不定义成 mid 了
            // 用加号和右移是安全的做法，即使在溢出的时候都能保证结果正确，但是 Python 中不存在溢出
            // 参考：https://leetcode-cn.com/problems/guess-number-higher-or-lower/solution/shi-fen-hao-yong-de-er-fen-cha-zhao-fa-mo-ban-pyth/
            int i = (left + right) >>> 1;
            // j 的取值在 PPT 第 7 张
            int j = totalLeft - i;

            if (nums2[j - 1] > nums1[i]) {
                // 这个分支缩短边界的原因在 PPT 第 8 张，情况 ①
                left = i + 1;
            } else {
                // 这个分支缩短边界的原因在 PPT 第 8 张，情况 ②
                // 【注意】：不让它收缩的原因是讨论 nums1[i - 1] > nums2[j]，i - 1 在数组的索引位置，在 i = 0 时越界
                right = i;
            }
        }

        // 退出循环的时候，交叉小于等于一定关系成立，那么中位数就可以从"边界线"两边的数得到，原因在 PPT 第 2 张、第 3 张

        int i = left;
        int j = totalLeft - left;
        // 边界值的特殊取法的原因在 PPT 第 10 张
        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int nums1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];

        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int nums2RightMin = j == n ? Integer.MAX_VALUE : nums2[j];

        // 交叉小于等于关系成立，那么中位数就可以从"边界线"两边的数得到，原因在 PPT 第 2 张、第 3 张
        // 已经找到解了，分数组之和是奇数还是偶数得到不同的结果，原因在 PPT 第 2 张
        if (((m + n) & 1) == 1) {
            return Math.max(nums1LeftMax, nums2LeftMax);
        } else {
            return (double) ((Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin))) / 2;
        }
    }
}
