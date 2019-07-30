# 英文模板：
# https://leetcode.com/problems/minimum-window-substring/discuss/26808/here-is-a-10-line-template-that-can-solve-most-substring-problems

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # 特判
        size = len(s)
        if size < 2:
            return size
        left = 0
        right = 0
        counter = [0 for _ in range(256)]

        condition = 0

        res = 1
        while right < size:

            if counter[ord(s[right])] > 0:
                condition += 1

            counter[ord(s[right])] += 1
            right += 1

            while condition > 0:
                if counter[ord(s[left])] > 1:
                    condition -= 1
                counter[ord(s[left])] -= 1
                left += 1
            res = max(res, right - left)
        return res


if __name__ == '__main__':
    s = "abcabcbb"
    solution = Solution()
    result = solution.lengthOfLongestSubstring(s)
    print(result)
