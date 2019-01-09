
下面这个解法正确，但是不能通过。
(超时)
```python
class Solution:
    def numSquares(self, n):
        """
        :type n: int
        :rtype: int
        """

        squares_sum = [0] + [n] * n
        for i in range(1, n + 1):
            for j in range(1, i + 1):
                residue = i - j ** 2
                print(residue)
                if residue >= 0:
                    squares_sum[i] = min(squares_sum[i], squares_sum[residue] + 1)
                else:
                    break
        return squares_sum[n]
```

状态以及状态转移的解法：
(超时)
```python
class Solution:
    def numSquares(self, n):
        """
        :type n: int
        :rtype: int
        """
        dp = [n] * (n + 1)
        for i in range(n):
            if i * i <= n:
                dp[i * i] = 1

        for i in range(1, n + 1):
            for j in range(i):
                if i + j * j <= n:
                    dp[i + j * j] = min(dp[i] + 1, dp[i + j * j])
        return dp[-1]

```


虽然写了出来，但是太凌乱！！！
```python
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
```
