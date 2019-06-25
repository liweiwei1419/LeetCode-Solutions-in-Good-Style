class Solution:
    def smallestSubsequence(self, text: str) -> str:
        size = len(text)
        stack = []
        pre = 0
        # 从索引 i 到索引 size - 1 的位掩码
        post = [0] * size

        for i in range(size):
            for j in range(i, size):
                post[i] |= (1 << (ord(text[j]) - ord('a')))

        for i in range(size):
            # print(stack, text[i])
            if pre & (1 << ord(text[i]) - ord('a')):
                # print(i, pre & (1 << ord(text[i]) - ord('a')))
                continue
            while stack and ord(text[i]) < ord(stack[-1]) \
                    and post[i] & (1 << (ord(stack[-1]) - ord('a'))):
                top = stack.pop()
                pre ^= (1 << ord(top) - ord('a'))
            pre |= (1 << ord(text[i]) - ord('a'))
            stack.append(text[i])
        return ''.join(stack)


if __name__ == '__main__':
    solution = Solution()
    text = "cdadabcc"
    text = "abcd"
    text = "ecbacba"
    text = "leetcode"

    res = solution.smallestSubsequence(text)
    print(res)
