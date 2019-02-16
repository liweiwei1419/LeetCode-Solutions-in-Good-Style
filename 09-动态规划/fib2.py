# @Time    : 18/3/21 上午11:28
# @Author  : liweiwei1419
# @Site    : http://www.liwei.party/
# @Contact : liweiwei1419@gmail.com


# 记忆化搜索的实现

memo = None


def _fib(n):
    if memo[n] != -1:
        return memo[n]
    if n == 0:
        return 0
    if n == 1:
        return 1
    memo[n] = _fib(n - 1) + _fib(n - 2)
    return memo[n]


def fib(n):
    global memo
    memo = [-1] * (n + 1)
    return _fib(n)


if __name__ == '__main__':
    for i in range(1, 16):
        print(i, end='\t')
    print()
    for i in range(1, 16):
        print(fib(i), end='\t')
