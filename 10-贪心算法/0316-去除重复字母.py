class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        counter = [0] * 26
        marked = [False] * 26

        for alpha in s:
            counter[ord(alpha) - ord('a')] += 1

        index = 0
        for count in counter:
            if count > 0:
                index += 1

        stack = []

        for alpha in s:

            while stack and ord(alpha) < ord(stack[-1]) \
                    and counter[ord(stack[-1]) - ord('a')] > 1 \
                    and not marked[ord(alpha) - ord('a')]:
                top = stack.pop()
                marked[ord(top) - ord('a')] = False
                counter[ord(top) - ord('a')] -= 1

            if marked[ord(alpha) - ord('a')]:
                counter[ord(alpha) - ord('a')] -= 1
                continue

            stack.append(alpha)
            marked[ord(alpha) - ord('a')] = True
        return ''.join(stack)