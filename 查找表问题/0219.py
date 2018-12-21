class Solution:

    # 应该写 is not None
    # 判断存在重复元素的索引之差小于某个数

    def containsNearbyDuplicate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """
        # 给定一个整数数组和一个整数 k，
        # 判断数组中是否存在两个不同的索引 i 和 j，
        # 使得 nums [i] = nums [j]，
        # 并且 i 和 j 的差的绝对值最大为 k。

        # 其实很简单，先判断 nums [i] = nums [j]
        # 然后判断索引值是否相等，所以索引值可以用 map 存起来。
        map = dict()
        for index, num in enumerate(nums):
            if map.get(num) is not None:  # 说明 nums [i] = nums [j]
                if index - map.get(num) <= k:
                    # 只要存在就返回了，其实并不难
                    return True
            # 更新为最新的索引
            map[num] = index
        return False


if __name__ == '__main__':
    nums = [1, 2, 3, 1]
    k = 3
    solution = Solution()
    result = solution.containsNearbyDuplicate(nums, k)
    print(result)
