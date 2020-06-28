class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        self.direct = [(0, -1), (-1, 0), (0, 1), (1, 0)]
        m = len(board)
        if (m == 0):
            return False
        n = len(board[0])

        marked = [[False for _ in range(n)] for _ in range(m)]
        for i in range(m):
            for j in range(n):
                if (self.dfs(board, word, 0, i, j, marked, m, n)):
                    return True
        return False

    def dfs(self, board, word, index, start_x, start_y, marked, m, n):
        if (index == len(word) - 1):
            return board[start_x][start_y] == word[index]

        if (board[start_x][start_y] == word[index]):
            marked[start_x][start_y] = 1
            for i in self.direct:
                new_x = start_x + i[0]
                new_y = start_y + i[1]
                if (0 <= new_x < m and 0 <= new_y < n and marked[new_x][new_y] == 0 \
                        and self.dfs(board, word, index + 1, new_x, new_y, marked, m, n)):
                    return True
            marked[start_x][start_y] = 0
        return False
