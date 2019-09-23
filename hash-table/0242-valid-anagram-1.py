class Solution:
    def isAnagram(self, s: str, t: str) -> bool:

        if len(s) != len(t):
            return False
        # 两个 word 的字母频数表
        s_count = [0] * 26
        t_count = [0] * 26
        basic = ord('a')
        for index in range(len(s)):
            s_count[ord(s[index]) - basic] += 1
            t_count[ord(t[index]) - basic] += 1
        for num1, num2 in zip(s_count, t_count):
            if num1 != num2:
                return False
        return True
