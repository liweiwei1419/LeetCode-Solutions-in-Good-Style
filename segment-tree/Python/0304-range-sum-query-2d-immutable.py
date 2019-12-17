from typing import List


class NumMatrix:

    def __init__(self, matrix: List[List[int]]):
        rows = len(matrix)
        if rows == 0:
            return

        cols = len(matrix[0])
        if cols == 0:
            return

        self.__pre_sum = [[0 for _ in range(cols + 1)] for _ in range(rows + 1)]

        for i in range(rows):
            for j in range(cols):
                self.__pre_sum[i + 1][j + 1] = self.__pre_sum[i + 1][j] + self.__pre_sum[i][j + 1] - self.__pre_sum[i][
                    j] + matrix[i][j]

    def sumRegion(self, row1: int, col1: int, row2: int, col2: int) -> int:
        return self.__pre_sum[row2 + 1][col2 + 1] - self.__pre_sum[row1][col2 + 1] - self.__pre_sum[row2 + 1][col1] + \
               self.__pre_sum[row1][col1]


if __name__ == '__main__':
    pre_sum = [[0 for _ in range(5 + 1)] for _ in range(5 + 1)]

    print(pre_sum)
