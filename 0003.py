class Solution:
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        l = len(s)
        if l <= 1:
            return l

        point = 0
        map = dict()
        result = 0

        for index, alpha in enumerate(s):
            if alpha in map and map[alpha] >= point:
                point = map[alpha] + 1
            result = max(result, index - point + 1)
            map[alpha] = index
        return result


if __name__ == '__main__':
    s = "abcabcbb"
    s = "bbb"
    solution = Solution()
    result = solution.lengthOfLongestSubstring(s)
    print(result)
