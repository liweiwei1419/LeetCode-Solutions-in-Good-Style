# 60. 第k个排列
# 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
#
# 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
#
# "123"
# "132"
# "213"
# "231"
# "312"
# "321"
# 给定 n 和 k，返回第 k 个排列。
#
# 说明：
#
# 给定 n 的范围是 [1, 9]。
# 给定 k 的范围是[1,  n!]。


class Solution:
    # 给定 n 和 k，返回第 k 个排列。

    def getPermutation(self, n: int, k: int) -> str:
        """
        :param n:
        :param k:
        :return:
        """

        if n == 0:
            return []
        nums = [i + 1 for i in range(n)]
        used = [False for _ in range(n)]
        factorial = [1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880]
        return self.__dfs(nums, used, n, k, 0, [], factorial)

    def __dfs(self, nums, used, n, k, depth, pre, factorial):
        if depth == n:
            # 在叶子结点处结算
            return ''.join(pre)
        # 后面的数的全排列的个数
        ps = factorial[n - 1 - depth]
        for i in range(n):
            # 如果这个数用过，就不再考虑
            if used[i]:
                continue
            # 后面的数的全排列的个数小于 k 的时候，执行剪枝操作
            if ps < k:
                k -= ps
                continue
            pre.append(str(nums[i]))
            # 因为直接走到叶子结点，因此状态不用恢复
            used[i] = True
            return self.__dfs(nums, used, n, k, depth + 1, pre, factorial)


if __name__ == '__main__':
    solution = Solution()
    n = 4
    k = 9
    res = solution.getPermutation(n, k)
    print(res)

    import math

    factorial = []
    for i in range(1, 10):
        factorial.append(math.factorial(i))

    print(factorial)
