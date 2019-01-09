# @Time    : 18/4/12 下午3:19
# @Author  : liweiwei1419
# @Site    : http://www.liwei.party/
# @Contact : liweiwei1419@gmail.com


class Solution:

    def __init__(self):
        self.cache = None

    def _partition(self, nums, index, j):
        '''
        f(i,j) = f(i-1,j) || f(i,j-nums[i])
        :param nums:
        :param index:
        :param C:
        :return:
        '''
        if j == 0:
            return True
        if index < 0 or j < 0:
            return False

        if self.cache[index][j] != 0:
            return self.cache[index][j]

        res = self._partition(nums, index - 1, j)
        if nums[index] <= j:
            res = res or self._partition(nums, index - 1, j - nums[index])
        self.cache[index][j] = res
        return res

    def canPartition(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """

        l = len(nums)
        if l == 0:
            return False
        s = sum(nums)
        if s % 2 == 1:
            return False
        half = s // 2

        print('l',l)
        print('half',half)

        self.cache = [[0 for _ in range(half + 1)] for _ in range(l)]

        # print(self.cache)
        return self._partition(nums, l - 1, half)


if __name__ == '__main__':
    # nums = [1, 5, 11, 5]
    import time
    begin = time.time()
    nums = [100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100]
    print(len(nums))
    s = Solution()
    res = s.canPartition(nums)
    end = time.time()
    print(end-begin)
    print(res)
