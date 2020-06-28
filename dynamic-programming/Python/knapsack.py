

if __name__ == '__main__':
    # m 是物品的件数
    # n 是背包的容量
    m, n = map(int, input().split())
    v = []  # 体积数组（左边那一列）
    w = []  # 价值数组（右边那一列）

    for i in range(m):
        num, x = map(int, input().split())
        v.append(num)
        w.append(x)

    dp = [[0 for _ in range(n + 1)] for _ in range(m + 1)]

    for i in range(1, m + 1):
        for j in range(0, n + 1):
            dp[i][j] = dp[i - 1][j]
            if j >= v[i - 1]:
                dp[i][j] = max(dp[i][j], dp[i - 1][j - v[i - 1]] + w[i - 1])
    print(dp)
    print(dp[m][n])
