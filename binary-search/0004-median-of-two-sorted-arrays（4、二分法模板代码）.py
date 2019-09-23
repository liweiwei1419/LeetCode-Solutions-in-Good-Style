from typing import List


class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        # 为了让搜索范围更小，我们始终让 num1 是那个更短的数组，PPT 第 9 张
        if len(nums1) > len(nums2):
            # 这里使用了 pythonic 的写法，即只有在 Python，中可以这样写
            # 在一般的编程语言中，得使用一个额外变量，通过"循环赋值"的方式完成两个变量的地址的交换
            nums1, nums2 = nums2, nums1

        # 上述交换保证了 m <= n，在更短的区间 [0, m] 中搜索，会更快一些
        m = len(nums1)
        n = len(nums2)

        # 使用二分查找算法在数组 nums1 中搜索一个索引 i，PPT 第 9 张
        left = 0
        right = m

        # 因为 left_total 这个变量会一直用到，因此单独赋值，表示左边粉红色部分一共需要的元素个数
        left_total = (m + n + 1) >> 1
        while left < right:
            # 尝试要找的索引，在区间里完成二分，为了保证语义，这里就不定义成 mid 了
            # 用加号和右移是安全的做法，即使在溢出的时候都能保证结果正确，但是 Python 中不存在溢出
            # 参考：https://leetcode-cn.com/problems/guess-number-higher-or-lower/solution/shi-fen-hao-yong-de-er-fen-cha-zhao-fa-mo-ban-pyth/
            i = (left + right) >> 1
            j = left_total - i

            # 如果 nums1 左边最大值 > nums2 右边最小值
            # print('i = {}, j = {}'.format(i, j))
            if nums2[j - 1] > nums1[i]:
                # 这个分支缩短边界的原因在 PPT 第 8 张，情况 ①
                left = i + 1
            else:
                # 这个分支缩短边界的原因在 PPT 第 8 张，情况 ②
                # 【注意】：不让它收缩的原因是讨论 nums1[i - 1] > nums2[j]，i - 1 在数组的索引位置，在 i = 0 时越界
                right = i

        # 退出循环的时候，交叉小于等于一定关系成立，那么中位数就可以从"边界线"两边的数得到，原因在 PPT 第 2 张、第 3 张
        i = left
        j = left_total - left

        # 边界值的特殊取法的原因在 PPT 第 10 张
        nums1_left_max = float('-inf') if i == 0 else nums1[i - 1]
        nums1_right_min = float('inf') if i == m else nums1[i]

        nums2_left_max = float('-inf') if j == 0 else nums2[j - 1]
        nums2_right_min = float('inf') if j == n else nums2[j]

        # 已经找到解了，分数组之和是奇数还是偶数得到不同的结果，原因在 PPT 第 2 张
        if (m + n) & 1:
            return max(nums1_left_max, nums2_left_max)
        else:
            return (max(nums1_left_max, nums2_left_max) + min(nums1_right_min, nums2_right_min)) / 2


if __name__ == '__main__':
    nums1 = [1, 2, 3, 4, 5, 7, 8, 9, 10]
    nums2 = [6]

    solution = Solution()
    res = solution.findMedianSortedArrays(nums1, nums2)
    print(res)
