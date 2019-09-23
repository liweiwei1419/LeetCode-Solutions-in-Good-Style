from typing import List


class Solution:

    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        # 判断存在重复元素的索引之差小于某个数
        # 先判断 nums [i] = nums [j]
        # 然后判断索引值是否相等，所以索引值可以用 hash_map 存起来。
        size = len(nums)
        if size == 0:
            return False

        hash_map = dict()
        for i in range(size):
            if nums[i] in hash_map and i - hash_map[nums[i]] <= k:
                # 只要找到 1 个符合题意的就返回
                return True
            # 更新为最新的索引，这里有贪心选择的思想，索引越靠后，符合题意的数据对的存在性就越大
            hash_map[nums[i]] = i
        return False


if __name__ == '__main__':
    nums = [1, 2, 3, 1]
    k = 3
    solution = Solution()
    result = solution.containsNearbyDuplicate(nums, k)
    print(result)
