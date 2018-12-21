class Solution:
    def isIsomorphic(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        if len(s) != len(t):
            return False
        # 两个字符不能映射到同一个字符上，但字符可以映射自己本身。
        dict_ = dict()  # 用于保存映射关系
        set_ = set()  # 用于判断 value 是否相同
        for cs, ct in zip(s, t):
            val = dict_.get(cs)
            if val is None:
                dict_[cs] = ct
                if set_.__contains__(ct):
                    return False
                else:
                    set_.add(ct)
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
