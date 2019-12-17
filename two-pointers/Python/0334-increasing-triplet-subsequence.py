from typing import List


class Solution:
    def increasingTriplet(self, nums: List[int]) -> bool:
        one = float('inf')
        two = float('inf')

        for num in nums:
            if num <= one:
                one = num
            elif num <= two:
                two = num
            else:
                return True
        return False