from typing import List


# 根据能够组成三角形的条件
#
# 1、两边之和大于第 3 边：这里第 3 边一定是最长边（只要满足这一条就可以了）
# 2、两边之差小于第 3 边：这里第 3 边是中间那条边，因为头尾相减差距最大

class Solution:
    def triangleNumber(self, nums: List[int]) -> int:
        size = len(nums)
        if size < 2:
            return 0

        # 排序是前提
        nums.sort()
        res = 0
        for i in range(0, size - 2):
            for j in range(i + 1, size - 1):
                k = self.__find_first_cannot_triangle(nums, j + 1, size - 1, nums[i] + nums[j])

                if k == -1:
                    # 如果不存在，返回 [j + 1 , size - 1] 这个区间的长度
                    # 即 size - 1 - (j + 1) + 1
                    res += (size - 1 - j)
                else:
                    res += (k - j - 1)
        return res

    def __find_first_cannot_triangle(self, nums, left, right, target):
        # 找到第 1 个大于等于 target 的数的索引，如果不存在，返回这个区间的长度
        while left < right:
            mid = left + (right - left) // 2
            if nums[mid] < target:
                left = mid + 1
            else:
                right = mid
        # 后处理，很有可能不存在大于等于 target 的数
        if nums[left] < target:
            return -1
        return left


if __name__ == '__main__':
    nums = [2, 2, 3, 4]
    solution = Solution()
    res = solution.triangleNumber(nums)
    print(res)
