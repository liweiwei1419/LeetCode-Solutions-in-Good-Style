if __name__ == '__main__':

    obstacleGrid = [[0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1], [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1],
                    [1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1]]
    m = len(obstacleGrid)
    n = len(obstacleGrid[0])

    dp_row = [0] * n
    dp_col = [0] * m

    for i in range(n):
        if obstacleGrid[0][i] == 0:
            dp_row[i] = 1
            continue
        else:
            break

    for i in range(m):
        if obstacleGrid[i][0] == 0:
            dp_col[i] = 1
            continue
        else:
            break

    print('1', dp_row)
    print('2', dp_col)
