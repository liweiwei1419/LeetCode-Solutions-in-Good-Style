# 给定一个包含 n 个整数的数组 nums，
# 判断 nums 中是否存在三个元素 a，b，c ，
# 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res = []
        nums.sort()
        for i in range(len(nums) - 2):
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            # 用指针对撞的方式
            l = i + 1
            r = len(nums) - 1
            # 不能等于，等于就变成取一样的数了
            while l < r:
                s = nums[i] + nums[l] + nums[r]
                if s > 0:
                    r -= 1
                elif s < 0:
                    l += 1
                else:
                    res.append([nums[i], nums[l], nums[r]])
                    # 注意：这一步在去重，是第一种解法 set 做不到的
                    while l < r and nums[l] == nums[l + 1]:
                        l += 1
                    while l < r and nums[r] == nums[r - 1]:
                        r -= 1
                    l += 1
                    r -= 1
        return res

if __name__ == '__main__':
    nums = [-2, 0, 0, 2, 2]
    solution = Solution()
    result = solution.threeSum(nums)
    print(result)


