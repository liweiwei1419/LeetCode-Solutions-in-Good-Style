from collections import deque

# 不知道用数组好还是用哈希表去重好

class Solution:
    def numSquares(self, n: int) -> int:
        square_root = int(n ** 0.5)
        # print(square_root)

        squares = [num ** 2 for num in range(1, square_root + 1)]
        # print(squares)

        queue = deque()
        queue.append((1, n))
        s = set()
        s.add(n)

        while queue:
            # print(queue)
            level, top = queue.popleft()
            for num in squares:
                residue = top - num
                if residue < 0:
                    break
                if residue == 0:
                    return level
                if residue not in s:
                    queue.append((level + 1, residue))
                    s.add(residue)


if __name__ == '__main__':
    n = 19
    solution = Solution()
    res = solution.numSquares(n)
    print(res)
