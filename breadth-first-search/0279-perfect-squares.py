class Solution:
    def numSquares(self, n: int) -> int:

        if n == 1:
            return 1
        if n ** 0.5 == int(n ** 0.5):
            return 1

        # 加法因子的候选集
        square_set = set()

        for i in range(1, n // 2 + 1):
            square = i * i
            if square <= n:
                square_set.add(square)
            else:
                break
        depth = 1
        non_leaf_node = [n]
        while len(non_leaf_node) != 0:
            depth += 1
            current_plus_factor = []
            for element in non_leaf_node:
                for s in square_set:
                    if element - s in square_set:
                        return depth
                    else:
                        current_plus_factor.append(element - s)
            non_leaf_node = current_plus_factor


if __name__ == '__main__':
    s = Solution()
    res = s.numSquares(4)
    print('结果', res)
