class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        size = len(s)

        last_appear_index = [0 for _ in range(26)]
        if_in_stack = [False for _ in range(26)]

        # 记录每个字符最后一次出现的索引
        for i in range(size):
            last_appear_index[ord(s[i]) - ord('a')] = i

        stack = ['a']
        for i in range(size):
            if if_in_stack[ord(s[i]) - ord('a')]:
                continue

            while ord(stack[-1]) > ord(s[i]) and last_appear_index[ord(stack[-1]) - ord('a')] >= i:
                top = stack.pop()
                if_in_stack[ord(top) - ord('a')] = False

            stack.append(s[i])
            if_in_stack[ord(s[i]) - ord('a')] = True

        return ''.join(stack[1:])


if __name__ == '__main__':
    s = 'bcabc'
    solution = Solution()
    res = solution.removeDuplicateLetters(s)
    print(res)
