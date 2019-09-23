from typing import List


class Solution:

    # 使用并查集
    # is_edge 这个设计不太好，不如给并查集设置一个"富裕"的结点，把边上的 "O" 都指向它

    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        class UnionFind:
            def __init__(self, n):
                self.parent = [i for i in range(n)]

            def find(self, p):
                root = p
                while root != self.parent[root]:
                    root = self.parent[root]
                while p != self.parent[p]:
                    temp = self.parent[p]
                    self.parent[p] = root
                    p = temp
                return root

            def is_connected(self, p, q):
                return self.find(p) == self.find(q)

            def union(self, p, q):
                p_id = self.find(p)
                q_id = self.find(q)
                if p_id == q_id:
                    return
                self.parent[p_id] = q_id

                # 加上了这一句，很重要，合并在一起的时候，边的属性和合并了
                if is_edge[p_id]:
                    is_edge[q_id] = True

        # 一开始是常规的代码
        m = len(board)
        if m == 0:
            return
        n = len(board[0])

        size = m * n
        # 并查集要用到这个变量，所以要设置成全局可用
        global is_edge
        is_edge = [False for _ in range(size)]

        uf = UnionFind(size)

        for i in range(size):
            x = i // n
            y = i % n
            # 'O' 在边上，置为 True
            if board[x][y] == 'O' and (x == 0 or y == 0 or x == m - 1 or y == n - 1):
                is_edge[i] = True

        for i in range(size):
            x = i // n
            y = i % n
            # 每个点都右边看一下，下面看一下，只要一样，就合并

            right = y + 1
            if right < n and board[x][y] == board[x][right]:
                uf.union(i, i + 1)

            down = x + 1
            if down < m and board[x][y] == board[down][y]:
                uf.union(i, i + n)

        for i in range(size):
            x = i // n
            y = i % n
            if board[x][y] == 'O' and not is_edge[uf.find(i)]:
                board[x][y] = 'X'


if __name__ == '__main__':
    # board = [['X', 'X', 'X', 'X'],
    #          ['X', 'O', 'O', 'X'],
    #          ['X', 'X', 'O', 'X'],
    #          ['X', 'O', 'X', 'X']]
    # board = [['O', 'O', 'O'],
    #          ['O', 'O', 'O'],
    #          ['O', 'O', 'O']]

    # board = [["X", "O", "X", "O", "X", "O"],
    #          ["O", "X", "O", "X", "O", "X"],
    #          ["X", "O", "X", "O", "X", "O"],
    #          ["O", "X", "O", "X", "O", "X"]]

    board = [["X", "X", "X", "O", "X", "O", "X"],
             ["X", "O", "X", "O", "X", "O", "O"],
             ["X", "X", "X", "X", "X", "X", "O"],
             ["X", "X", "X", "X", "O", "X", "O"],
             ["X", "X", "X", "X", "X", "X", "O"],
             ["X", "X", "X", "X", "X", "X", "X"],
             ["O", "X", "X", "O", "O", "O", "X"]]

    solution = Solution()
    import time

    begin = time.time()
    solution.solve(board)
    print(time.time() - begin)
    for row in board:
        print(row)
