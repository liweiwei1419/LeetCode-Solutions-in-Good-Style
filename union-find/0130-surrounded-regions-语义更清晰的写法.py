from typing import List

class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """

        # 使用并查集
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

        # 一开始是常规的代码
        m = len(board)
        if m == 0:
            return
        n = len(board[0])

        def get_index(x, y):
            return x * n + y

        dummy_node = m * n

        uf = UnionFind(m * n + 1)

        # 先把四条边上的 "O" 全部连起来
        for row_index in range(m):
            if board[row_index][0] == 'O':
                uf.union(get_index(row_index, 0), dummy_node)
            if board[row_index][n - 1] == 'O':
                uf.union(get_index(row_index, n - 1), dummy_node)

        for col_index in range(n):
            if board[0][col_index] == 'O':
                uf.union(get_index(0, col_index), dummy_node)
            if board[m - 1][col_index] == 'O':
                uf.union(get_index(m - 1, col_index), dummy_node)

        directions = [(1, 0), (0, 1)]
        for i in range(m):
            for j in range(n):
                if board[i][j] == 'O':
                    # 只向 2 个方向找，只用看 2 个方向，不要和回溯算法混淆了
                    for direction in directions:
                        new_i = i + direction[0]
                        new_j = j + direction[1]
                        if new_i < m and new_j < n and board[new_i][new_j] == 'O':
                            uf.union(get_index(i, j), get_index(new_i, new_j))

        for i in range(1, m - 1):
            for j in range(1, n - 1):
                if board[i][j] == 'O' and not uf.is_connected(get_index(i, j), m * n):
                    board[i][j] = 'X'


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

    board = [["X", "O", "O", "X", "X", "X", "O", "X", "O", "O"],
             ["X", "O", "X", "X", "X", "X", "X", "X", "X", "X"],
             ["X", "X", "X", "X", "O", "X", "X", "X", "X", "X"],
             ["X", "O", "X", "X", "X", "O", "X", "X", "X", "O"],
             ["O", "X", "X", "X", "O", "X", "O", "X", "O", "X"],
             ["X", "X", "O", "X", "X", "O", "O", "X", "X", "X"],
             ["O", "X", "X", "O", "O", "X", "O", "X", "X", "O"],
             ["O", "X", "X", "X", "X", "X", "O", "X", "X", "X"],
             ["X", "O", "O", "X", "X", "O", "X", "X", "O", "O"],
             ["X", "X", "X", "O", "O", "X", "O", "X", "X", "O"]]
    solution = Solution()
    import time

    begin = time.time()
    solution.solve(board)
    print(time.time() - begin)
    for row in board:
        print(row)
