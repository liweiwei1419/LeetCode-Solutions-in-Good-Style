class Solution:

    # 只要后面有，就弹栈

    def removeDuplicateLetters(self, s: str) -> str:
        size = len(s)
        stack = []

        for i in range(size):
            if stack.count(s[i]) > 0:
                continue
            while stack and ord(s[i]) < ord(stack[-1]) \
                    and s.find(stack[-1], i) != -1:
                stack.pop()

            stack.append(s[i])
        return ''.join(stack)


if __name__ == '__main__':
    s = "cbacdcbc"
    solution = Solution()

    res = solution.removeDuplicateLetters(s)
    print(res)
