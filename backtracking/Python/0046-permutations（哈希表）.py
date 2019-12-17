from typing import List


class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        size = len(nums)
        if size == 0:
            return []
        res = []
        path = []
        hash_set = set()
        self.__backtracking(nums, 0, size, hash_set, path, res)
        return res

    def __backtracking(self, nums, index, size, hash_set, path, res):
        if index == size:
            res.append(path.copy())
            return

        for i in range(size):
            if not nums[i] in hash_set:
                hash_set.add(nums[i])
                path.append(nums[i])
                self.__backtracking(nums, index + 1, size, hash_set, path, res)
                path.pop()
                hash_set.remove(nums[i])
