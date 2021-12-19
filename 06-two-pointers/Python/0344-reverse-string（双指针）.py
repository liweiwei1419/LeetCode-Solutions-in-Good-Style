from typing import List


class Solution:
    def reverseString(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        size = len(s)
        if size < 2:
            return

        left = 0
        right = size - 1
        while left < right:
            s[left], s[right] = s[right], s[left]
            left += 1
            right -= 1
