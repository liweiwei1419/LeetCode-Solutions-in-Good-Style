# @Time    : 18/3/21 上午11:28
# @Author  : liweiwei1419
# @Site    : http://www.liwei.party/
# @Contact : liweiwei1419@gmail.com

# 动态规划的解法

def fib(n):
    memo = [-1] * (n + 1)
    memo[0] = 0
    memo[1] = 1

    for i in range(2, n + 1):
        memo[i] = memo[i - 1] + memo[i - 2]
    return memo[n]


if __name__ == '__main__':
    for i in range(1, 16):
        print(i, end='\t')
    print()
    for i in range(1, 16):
        print(fib(i), end='\t')
