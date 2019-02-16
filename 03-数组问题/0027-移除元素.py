class Solution:

    # 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。

    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        # 下一个保存数组元素的位置
        size = len(nums)
        if size == 0:
            return 0
        j = 0
        for i in range(size):
            if nums[i] != val:
                # 就移动到前面去
                nums[i], nums[j] = nums[j], nums[i]
                j += 1
        return j


if __name__ == '__main__':
    nums = [3, 2, 2, 3]
    val = 3
    s = Solution()
    result = s.removeElement(nums, val)
    print(nums)
    print(result)
