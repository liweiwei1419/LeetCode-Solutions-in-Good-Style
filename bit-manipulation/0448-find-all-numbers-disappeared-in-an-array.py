from typing import List


class Solution:

    # 不符合题目要求，仅提供位运算的思路

    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        size = len(nums)

        # 位图，这里使用了额外的空间，不符合题目要求，仅提供思路
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
