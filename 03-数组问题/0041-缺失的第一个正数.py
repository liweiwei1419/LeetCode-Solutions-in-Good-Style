# 41. 缺失的第一个正数
# 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。

class Solution:

    def firstMissingPositive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        # 题目中给出的例子，就是最好的例子
        # [3,4,-1,1]
        # [-1,4,3,1]
        # [-1,1,3,4]
        # 3 应该放在索引为 2 的地方
        # 4 应该放在索引为 3 的地方

        for i in range(len(nums)):

            # nums[i] > 0 and nums[i] <= len(nums) 的意思是：只要是符合索引的数字
            # 这里的索引应该认为从 1 开始
            # 就要把它放到正确的地方上去，这一步叫 hash
            # nums[i] == nums[nums[i]-1]，叫放到了正确的地方
            # 例如，3 应该放在索引为 2 的地方，如果不理解，这句话多读几遍
            # 例如，3 应该放在索引为 2 的地方，如果不理解，这句话多读几遍
            # 例如，3 应该放在索引为 2 的地方，如果不理解，这句话多读几遍

            # 所以，先判断这个数字是不是索引
            # 然后判断这个数字是不是放在了正确的地方

            while 1 <= nums[i] <= len(nums) and nums[i] != nums[nums[i] - 1]:
                # 交换
                self.__swap(nums, i, nums[i] - 1)

        # print(nums)
        # 再遍历一次，没有放对的就是你要找的
        for i in range(len(nums)):
            # value： [1,2,3,4]
            # index： [0,1,2,3]
            if i + 1 != nums[i]:
                return i + 1

        return len(nums) + 1

    def __swap(self, nums, index1, index2):
        nums[index1], nums[index2] = nums[index2], nums[index1]


if __name__ == '__main__':
    nums = [4, 4, 4, 3, 2, 31]

    solution = Solution()
    res = solution.firstMissingPositive(nums)
    print(res)
