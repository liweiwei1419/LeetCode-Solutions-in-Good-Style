class Solution:
    def integerBreak(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n <= 2:
            return n

        marked = [False] * n
        queue = [(0, n)]

        while queue:
            depth, num = queue.pop(0)
            depth += 1

            for i in range(1, num + 1):
                res = num - i * i
                if res == 0:
                    break
                elif res < 0:
                    return depth
                else:
                    if not marked[res]:
                        marked[res] = True
                        queue.append((depth, res))


if __name__ == '__main__':
    n = 4
    s = Solution()
    res = s.integerBreak(n)
    print(res)
