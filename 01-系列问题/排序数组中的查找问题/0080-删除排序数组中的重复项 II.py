# 80. 删除排序数组中的重复项 II
# 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
#
# 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

# 我觉得记住这个写法就可以了

class Solution:
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        size = len(nums)
        if size <= 2:
            return size

        counter = 2
        for i in range(2, size):
            if nums[i] != nums[counter - 2]:
                nums[counter] = nums[i]
                counter += 1

        return counter


if __name__ == '__main__':
    nums = [1, 1, 1, 2, 2, 3]
    solution = Solution()
    result = solution.removeDuplicates(nums)
    print(nums)
    print(result)
