from typing import List


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        size = len(nums)
        res = []
        # 特判
        if size < 3:
            return res

        # 排序的意义：1、去重复剪枝；2、方便后续在区间内查找两数之和
        nums.sort()
        # 枚举第 1 个数的索引
        for i in range(size - 2):
            if nums[i] > 0:
                break

            # 剪枝去重
            if i > 0 and nums[i] == nums[i - 1]:
                continue

            # 用指针对撞，在区间 [i + 1, size - 1] 区间里找两个数之和为 -nums[i]
            left = i + 1
            right = size - 1
            # 不能等于，等于就变成取一样的数了
            while left < right:
                s = nums[i] + nums[left] + nums[right]

                if s > 0:
                    right -= 1
                elif s < 0:
                    left += 1
                else:
                    res.append([nums[i], nums[left], nums[right]])
                    # 注意：这一步在去重，是第一种解法 set 做不到的
                    # 看一看右边是不是和自己相等，如果相等，就向右边移动一格
                    while left < right and nums[left] == nums[left + 1]:
                        left += 1
                    # 看一看左边是不是和自己相等，如果相等，就向右边移动一格
                    while left < right and nums[right] == nums[right - 1]:
                        right -= 1
                    # 这里不能忘记
                    left += 1
                    right -= 1
        return res


if __name__ == '__main__':
    nums = [-2, 0, 0, 2, 2]
    solution = Solution()
    result = solution.threeSum(nums)
    print(result)
