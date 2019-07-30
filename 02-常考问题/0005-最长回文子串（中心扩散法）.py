# 5. 最长回文子串
# 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

class Solution:
    def longestPalindrome(self, s):
        # 中心扩散法
        size = len(s)
        if size == 0:
            return ''

        # 最短回文串的长度至少是 1
        longest_palindrome = 1
        longest_palindrome_str = s[0]

        for i in range(size):

            palindrome_odd_str, odd_len = self.__center_spread(s, size, i, i)
            palindrome_even_str, even_len = self.__center_spread(s, size, i, i + 1)

            # 当前找到的最长回文子串
            cur_max_sub = palindrome_odd_str if odd_len >= even_len else palindrome_even_str
            if len(cur_max_sub) > longest_palindrome:
                longest_palindrome = len(cur_max_sub)
                longest_palindrome_str = cur_max_sub

        return longest_palindrome_str

    def __center_spread(self, s, size, index_left, index_right):
        # left = right 的时候，表示回文中心是一条线，回文串的长度是奇数
        # right = left + 1 的时候，表示回文中心是任意一个字符，回文串的长度是偶数
        # 返回当前得到的回文子串和回文子串的长度
        left = index_left
        right = index_right

        while left >= 0 and right < size and s[left] == s[right]:
            left -= 1
            right += 1
        return s[left + 1:right], right - left - 1


if __name__ == '__main__':
    solution = Solution()
    s = "babad"
    longestPalindrome = solution.longestPalindrome(s)
    print(longestPalindrome)
