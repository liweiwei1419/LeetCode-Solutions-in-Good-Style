class Solution(object):

    # 模板写法

    def removeDuplicates(self, nums, k):
        """
        :type nums: List[int]
        :rtype: int
        """
        size = len(nums)
        if size <= k:
            return size
        # counter 表示下一个要覆盖的索引
        counter = k
        # 索引为 0 和 1 的数一定会被保留，因此遍历从索引 2 开始
        for i in range(k, size):
            if nums[i] != nums[counter - k]:
                nums[counter] = nums[i]
                counter += 1
        return counter


if __name__ == '__main__':
    nums = [1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7]
    solution = Solution()
    counter = solution.removeDuplicates(nums, k=5)
    print(counter)
    print(nums[:counter])
