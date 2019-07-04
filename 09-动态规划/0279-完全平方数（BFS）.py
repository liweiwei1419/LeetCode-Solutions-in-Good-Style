class Solution:

    def numSquares(self, n):
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
                residue = num - i * i
                if residue == 0:
                    return depth
                elif residue < 0:
                    break
                else:
                    if not marked[residue]:
                        marked[residue] = True
                        queue.append((depth, residue))


if __name__ == '__main__':
    n = 4
    s = Solution()
    res = s.integerBreak(n)
    print(res)
