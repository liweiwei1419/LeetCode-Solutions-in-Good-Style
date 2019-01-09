# 20. 有效的括号
# 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
class Solution:
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        stack = []
        d = ["()", "[]", "{}"]
        for i in range(0, len(s)):
            stack.append(s[i])
            if len(stack) >= 2 and stack[-2] + stack[-1] in d:
                stack.pop()
                stack.pop()
        return len(stack) == 0


if __name__ == '__main__':
    s = Solution()
    s1 = "()[]{}"
    isValid = s.isValid(s1)
    print(isValid)
