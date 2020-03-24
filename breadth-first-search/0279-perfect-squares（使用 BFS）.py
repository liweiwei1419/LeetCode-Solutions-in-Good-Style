class Solution:
    def numSquares(self, n: int) -> int:
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
    s = Solution()
    res = s.numSquares(4)
    print('结果', res)
