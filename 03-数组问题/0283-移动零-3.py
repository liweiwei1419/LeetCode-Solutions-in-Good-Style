class Solution:

    #【错误的做法】：使用了指针对撞，但是没有保证元素的相对顺序

    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """

        # 使用前后两个标记

        # 测试用例： 0 1 0 3 12
        # 12 1 0 3 0

        # 12 1 3 0 0

        # 注意初始条件判断
        if len(nums) <= 1:
            return

        begin = 0
        end = len(nums) - 1

        while True:

            while begin <= len(nums) - 1 and nums[begin] != 0:
                begin += 1
            # 停在了 0 的位置

            while end >= 0 and nums[end] == 0:
                end -= 1
            # 停在了非 0 的位置

            # 注意边界条件
            if begin > end:
                break

            nums[begin], nums[end] = nums[end], nums[begin]
            begin += 1
            end -= 1


if __name__ == '__main__':
    import random

    nums = [random.randint(1,10) for _ in range(10)]
    nums.extend([0]*10)

    random.shuffle(nums)
    print('之前',nums)

    s = Solution()

    s.moveZeroes(nums)

    print('之后',nums)
