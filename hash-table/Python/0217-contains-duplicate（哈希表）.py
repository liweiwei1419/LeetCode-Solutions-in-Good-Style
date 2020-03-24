from typing import List


class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        hash_set = set()
        for num in nums:
            if num in hash_set:
                return True
            else:
                hash_set.add(num)
        return False


if __name__ == '__main__':
    nums = [0]
    s = Solution()
    result = s.containsDuplicate(nums)
    print(result)
