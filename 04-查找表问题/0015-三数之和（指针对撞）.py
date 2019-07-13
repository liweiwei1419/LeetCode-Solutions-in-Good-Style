# 15、三数之和
# 给定一个包含 n 个整数的数组 nums，
# 判断 nums 中是否存在三个元素 a，b，c ，
# 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

# 思路：指针对撞


from typing import List


class Solution:

    def threeSum(self, nums: List[int]) -> List[List[int]]:
        size = len(nums)
        res = []

        # 排序是前提
        nums.sort()

        for i in range(size - 2):
            # 剪枝去重
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            # 双指针对撞
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
                    while left < right and nums[left] == nums[left + 1]:
                        left += 1
                    while left < right and nums[right] == nums[right - 1]:
                        right -= 1
                    left += 1
                    right -= 1
        return res


if __name__ == '__main__':
    nums = [-2, 0, 0, 2, 2]
    solution = Solution()
    result = solution.threeSum(nums)
    print(result)
