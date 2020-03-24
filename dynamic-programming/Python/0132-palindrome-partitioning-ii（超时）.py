class Solution:
    def minCut(self, s: str) -> int:
        size = len(s)
        if size < 2:
            return 0

        dp = [i for i in range(size)]

        for i in range(1, size):
            if self.__check_palindrome(s, 0, i):
                dp[i] = 0
                continue
            # 枚举分割点
            dp[i] = min([dp[j] + 1 for j in range(i) if self.__check_palindrome(s, j + 1, i)])

        return dp[size - 1]

    def __check_palindrome(self, s, left, right):
        while left < right:
            if s[left] != s[right]:
                return False
            left += 1
            right -= 1
        return True
