class Solution:
    def wordPattern(self, pattern: str, str: str) -> bool:
        # 匹配串
        s = str.split()
        # 模式串
        p = list(pattern)
        hash_map = dict()

        # 特判
        if len(pattern) != len(s):
            return False

        for i in set(p):
            hash_map[s[p.index(i)]] = i

        for i in range(len(s)):
            if s[i] in hash_map:
                s[i] = hash_map[s[i]]
        return s == p
