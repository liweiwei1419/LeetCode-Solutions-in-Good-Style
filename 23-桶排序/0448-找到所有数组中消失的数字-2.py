# 时间复杂度O(2n)，空间复杂度 $O(1)$，res 不算额外空间
from typing import List


class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        size = len(nums)

        # 位图
        map = 1 << (size)

        # 调试代码
        # print(bin(map))

        for num in nums:
            map |= 1 << (num - 1)
            # 调试代码
            # print(bin(map))

        res = []

        for index in range(size):
            if (map >> index) & 1 == 0:
                res.append(index + 1)
        return res


if __name__ == '__main__':
    solution = Solution()
    nums = [4, 3, 2, 7, 8, 2, 3, 1]
    res = solution.findDisappearedNumbers(nums)
    print(res)
