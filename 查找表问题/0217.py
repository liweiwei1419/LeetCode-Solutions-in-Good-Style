class Solution:
    def containsDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        s = set()
        for num in nums:
            if num in s:
                return True
            else:
                s.add(num)
        return False


if __name__ == '__main__':
    nums = [0]
    s = Solution()
    result = s.containsDuplicate(nums)
    print(result)
