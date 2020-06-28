from typing import List


class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        # 使用深度优先搜索
        if not board:  # 边界条件
            return False
        for i in range(len(board)):
            for j in range(len(board[0])):
                if self.dfs(board, i, j, word):
                        return True
        return False

    def dfs(self, board, i, j, word):
        if len(word) == 0:  # 如果单词已经检查完毕
            return True
        if word[0] != board[i][j]:
            # 如果路径出界或者矩阵中的值不是word的首字母，返回False
            return False
        tmp = board[i][j]
        board[i][j] = '0'
        for (row, col) in ((0, 1), (0, -1), (1, 0), (-1, 0)):
            if i + row >= 0 and i + row < len(board) and j + col >= 0 and j + col < len(board[0]) and self.dfs(board,
                                                                                                            i + row,
                                                                                                            j + col,
                                                                                                            word[1:]):
                return True
        # 标记过的点恢复原状，以便进行下一次搜索
        board[i][j] = tmp

        return False


if __name__ == '__main__':
    board = [
        ['A', 'B', 'C', 'E'],
        ['S', 'F', 'C', 'S'],
        ['A', 'D', 'E', 'E']
    ]

    solution = Solution()
    word = "ABCB"
    res = solution.exist(board, word)
    print(res)
