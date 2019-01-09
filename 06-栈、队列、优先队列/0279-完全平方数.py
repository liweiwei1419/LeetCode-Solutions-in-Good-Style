# 279. 完全平方数
# 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。


class Solution:

    def __init__(self):
        # 加法因子的候选集
        self.square_set = set()

    def numSquares(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n == 1:
            return 1
        if n ** 0.5 == int(n ** 0.5):
            return 1
        for i in range(1, n // 2 + 1):
            square = i * i
            if square <= n:
                self.square_set.add(square)
            else:
                break
        depth = 1
        non_leaf_node = [n]
        while len(non_leaf_node) != 0:
            depth += 1
            current_plus_factor = []
            for element in non_leaf_node:
                for s in self.square_set:
                    if element - s in self.square_set:
                        return depth
                    else:
                        current_plus_factor.append(element - s)
            non_leaf_node = current_plus_factor


if __name__ == '__main__':
    s = Solution()
    res = s.numSquares(4)
    print('结果', res)
