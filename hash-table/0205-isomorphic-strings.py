class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:

        if len(s) != len(t):
            return False
        # 两个字符不能映射到同一个字符上，但字符可以映射自己本身。
        hash_table = dict()  # 用于保存映射关系
        hash_set = set()  # 用于判断 value 是否相同
        for cs, ct in zip(s, t):
            val = hash_table.get(cs)
            if val is None:
                hash_table[cs] = ct
                if ct in hash_set:
                    return False
                else:
                    hash_set.add(ct)
            else:
                if val != ct:
                    return False
        return True


if __name__ == '__main__':
    s = "egg"
    t = "add"
    solution = Solution()
    result = solution.isIsomorphic(s, t)
    print(result)
