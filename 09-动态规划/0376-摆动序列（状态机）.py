class Solution:
    def wiggleMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        size = len(nums)
        if size < 2:
            return size
        # [1,17,5,10,13,15,10,5,16,8]

        # 0 表示初始状态，1 表示上升，2 表示下降
        res = 1
        state = 0

        for i in range(1, size):
            if state == 0:
                if nums[i - 1] > nums[i]:
                    res += 1
                    state = 2
                    continue
                if nums[i - 1] < nums[i]:
                    state = 1
                    res += 1
                    continue

            if state == 1 and nums[i - 1] > nums[i]:
                res += 1
                state = 2
                continue
            if state == 2 and nums[i - 1] < nums[i]:
                res += 1
                state = 1
        return res


if __name__ == '__main__':
    solution = Solution()
    nums = [1, 1, 7, 4, 9, 2, 5]
    result = solution.wiggleMaxLength(nums)
    print(result)
