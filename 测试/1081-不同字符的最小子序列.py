class Solution:
    def smallestSubsequence(self, text: str) -> str:
        size = len(text)
        stack = []
        for i in range(size):
            if text[i] in stack:
                continue
            while stack and ord(text[i]) < ord(stack[-1]) and \
                    text.find(stack[-1], i) != -1:
                stack.pop()
            stack.append(text[i])
        return ''.join(stack)


if __name__ == '__main__':
    solution = Solution()
    text = "cdadabcc"
    res = solution.smallestSubsequence(text)
    print(res)
