class Solution:
    # 重复元素至多保留 2 个

    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        if len(nums) == 0:
            return 0

        j = 1  # j 始终保存着下一个要更新的元素的索引
        current_num = nums[0]
        duplicates_times = 0
        for i in range(1, len(nums)):
            if nums[i] == current_num:
                duplicates_times += 1
                if duplicates_times == 1:
                    # 这一步赋值是非常关键的
                    nums[j] = current_num
                    j += 1
            if nums[i] > current_num:
                current_num = nums[i]
                duplicates_times = 0
                nums[j] = nums[i]
                j += 1
        return j


if __name__ == '__main__':
    s = Solution()
    nums = [1, 1, 1, 1, 2, 2, 2, 3, 3]
    res = s.removeDuplicates(nums)
    print(res)
    print(nums[:res])
