class Solution:

    # 先写最简单的
    # 然后写有 * 的

    def isMatch(self, s: str, p: str) -> bool:
        if len(p) == 0:
            return len(s) == 0

        first_match = len(s) > 0 and (p[0] == s[0] or p[0] == '.')

        if len(p) > 1 and p[1] == '*':
            if self.isMatch(s, p[2:]):
                return True
            return first_match and self.isMatch(s[1:], p)

        return first_match and self.isMatch(s[1:], p[1:])