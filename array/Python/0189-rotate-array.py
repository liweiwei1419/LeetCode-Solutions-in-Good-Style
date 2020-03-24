from typing import List


class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """

        size = len(nums)
        # 先处理极端情况
        if size == 0 or k <= 0:
            return

        k = k % len(nums)

        # 做下面 3 个逆转动作的时候，注意边界条件
        # 技巧就是举具体的例子
        self.__reverse(nums, 0, size - 1)
        self.__reverse(nums, 0, k - 1)
        self.__reverse(nums, k, size - 1)

    def __reverse(self, nums, index1, index2):
        """
        将数组 [index1,index2] 区间内的元素进行逆转
        :param nums:
        :param index1:
        :param index2:
        :return:
        """
        while index1 < index2:
            nums[index1], nums[index2] = nums[index2], nums[index1]
            index1 += 1
            index2 -= 1


if __name__ == '__main__':
    nums = [1, 2, 3, 4, 5, 6, 7]
    k = 3

    s = Solution()
    s.rotate(nums, k)
    print(nums)
