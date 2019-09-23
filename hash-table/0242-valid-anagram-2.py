class Solution:
    def isAnagram(self, s: str, t: str) -> bool:

        if len(s) != len(t):
            return False
        # 只用一个 word 的字母频数表
        count = [0] * 26
        basic = ord('a')
        for index in range(len(s)):
            count[ord(s[index]) - basic] += 1
            count[ord(t[index]) - basic] -= 1
        for num in count:
            if num != 0:
                return False
        return True
