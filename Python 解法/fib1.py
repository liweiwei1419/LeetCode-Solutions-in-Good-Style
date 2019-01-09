# @Time    : 18/3/21 上午11:27
# @Author  : liweiwei1419
# @Site    : http://www.liwei.party/
# @Contact : liweiwei1419@gmail.com


def fib(n):
    if n == 0:
        return 0
    if n == 1:
        return 1
    return fib(n - 1) + fib(n - 2)


if __name__ == '__main__':
    for i in range(1, 16):
        print(i, end='\t')
    print()
    for i in range(1, 16):
        print(fib(i), end='\t')