class Solution:
    def isAnagram(self, s: str, t: str) -> bool:

        # 这个解法不是很好懂
        if len(s) != len(t):
            return False
        # 两个 word 的字母频数表
        s_count = [0] * 26
        t_count = [0] * 26
        basic = ord('a')
        for index in range(len(s)):
            s_count[ord(s[index]) - basic] += 1
            t_count[ord(t[index]) - basic] += 1
        # 给出两个质数
        p1 = 1181
        p2 = 1187
        s_hash = 1
        t_hash = 1
        for i in range(0, 26):
            s_hash = s_hash * p1 + s_count[i]
            t_hash = t_hash * p1 + t_count[i]
            p1 *= p2
        return s_hash == t_hash


if __name__ == '__main__':
    s = 'happynewyear'
    t = 'newhappyyear'
    solution = Solution()
    result = solution.isAnagram(s, t)
    print(result)
