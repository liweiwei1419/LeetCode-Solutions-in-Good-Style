from typing import List


class Solution:
    def triangleNumber(self, nums: List[int]) -> int:
        # 索引数组：[0, 1, 2, 3, 4]，size = 5

        size = len(nums)
        # 思路 2：从后到前，先固定 k ，再固定 j ，最后确定 i 的范围
        # 首先不要忘记排序
        nums.sort()
        res = 0

        # 注意边界，看上面那个索引数组知道 k 最小取到 2，不能再小了
        for k in range(size - 1, 1, -1):
            # 要给 i 留一个位置，故 1 是下限（取不到）
            # print('k=', k)
            for j in range(k - 1, 0, -1):
                # 在区间 [0, j - 1] 中找第 1 个能构成三角形的数
                # i 与 j 之间的数的个数就是一票解
                # 等价于，在子区间 [0, j - 1] 里找第 1 个大于（不能等于） nums[k] - nums[j] 的数
                i = self.__find_first_can_triangle(nums, 0, j - 1, nums[k] - nums[j])
                # print(i, j, k)
                if i == -1:
                    # 说明子区间 [0, j - 1] 全部的数都不能构成三角形
                    # 其中的数的个数为 0，
                    # 为了语义清晰，我还是写一下 + 0
                    res += 0
                else:
                    # 说明子区间 [i, j - 1] 全部的数可以构成三角形，注意：这里 k 取不到
                    # 其中的数的个数为 j - 1 - i + 1
                    res += (j - i)
                # print('res=', res)
        return res

    def __find_first_can_triangle(self, nums, left, right, target):
        # 在 nums 的子区间 [left, right] 里找第 1 个大于（不能等于） target 的元素的索引
        # 如果不存在，返回 -1
        while left < right:
            mid = (left + right) >> 1
            if nums[mid] <= target:
                left = mid + 1
            else:
                right = mid
        # 后处理，因为很有可能找不到大于 target 的元素
        if nums[left] <= target:
            return -1
        return left


if __name__ == '__main__':
    solution = Solution()
    nums = [2, 2, 3, 4]
    res = solution.triangleNumber(nums)
    print(res)
