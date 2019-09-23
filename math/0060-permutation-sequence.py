class Solution:

    # 模拟了一个链表，用数学的方法完成这道题

    def getPermutation(self, n: int, k: int) -> str:
        # 阶乘值
        factorial = 1
        permutation = []
        for i in range(1, n + 1):
            factorial *= i  # 计算排列数量
            permutation.append(i)  # 生成排列所用列表
        # print(factorial)
        # print(permutation)

        res = ""
        # 第 k 大数字
        k = k - 1
        while n > 0:
            factorial = factorial / n  # 计算当前位置每种数字的情况个数
            h = int(k / factorial)  # 当前位置所需数字的位置
            res += str(permutation[h])
            del permutation[h]  # 删除已用数字
            k %= factorial  # 取出剩余的数
            n -= 1  # 移位
        return res

if __name__ == '__main__':
    n = 3
    k = 3
    solution = Solution()
    res = solution.getPermutation(n,k)
    print(res)
