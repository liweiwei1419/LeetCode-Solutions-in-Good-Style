class Solution:


    def numSquares(self, n):
        """
        :type n: int
        :rtype: int
        """

        marked = [False for _ in range(n)]

        queue = [(0, n)]

        while queue:
            level, top = queue.pop(0)
            level += 1

            start = 1
            while True:
                residue = top - start * start
                if residue == 0:
                    return level
                elif residue < 0:
                    break
                else:
                    if not marked[residue]:
                        queue.append((level, residue))
                        marked[residue] = True
                start += 1


if __name__ == '__main__':
    solution = Solution()
    n = 12
    result = solution.numSquares(n)
    print(result)
