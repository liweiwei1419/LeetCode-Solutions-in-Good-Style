https://leetcode.com/problems/house-robber/description/


You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Credits:
Special thanks to @ifanchu for adding this problem and creating all test cases. Also thanks to @ts for adding additional test cases.



注意：
记忆化搜索的缓存数组的初始值不能全部设置为 0，否则面对下面的这个测试用例：

[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]

缓存无效！


```python
class Solution:
    def __init__(self):
        self.cache = None

    def _rob_house(self, nums, begin_index):
        '''
        考虑偷取 [begin_index,len(num-1)] 这些房子的物品，价值之和最大为多少
        状态转移方程是：
        f(0) = max(v(0) + f(2),v(1) + f(3),...,v(n-3) + f(n-1),v(n-2),v(n-1))
        :param nums:
        :param begin_index:
        :return:
        '''

        l = len(nums)
        if begin_index >= l:
            return 0
        if self.cache[begin_index] != -1:
            return self.cache[begin_index]
        max_val = 0
        for i in range(begin_index, l):
            max_val = max(max_val, nums[i] + self._rob_house(nums, i + 2))
        self.cache[begin_index] = max_val
        return max_val

    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        if n == 0:
            return 0
        self.cache = [-1] * n
        return self._rob_house(nums, 0)
```

下面我们换一种状态转移的定义，又得到另外一种解法：
```python
class Solution:
    def __init__(self):
        self.cache = None

    def _rob_house(self, nums, end_index):
        '''
        考虑偷取 [0,...,end_index] 区间范围内的房子价值的最大者
        状态转移方程：
        f(l-1) = max(v(l-1) + f(l-3),
                     v(l-2) + f(l-4),
                     ...,
                     v(3) + f(1),
                     v(2) + f(0),
                     v(1),
                     v(0))

        :param nums:
        :param end_index:
        :return:
        '''
        if end_index < 0:
            return 0
        if self.cache[end_index] != -1:
            return self.cache[end_index]

        max_val = 0
        for i in range(end_index, -1, -1):
            max_val = max(max_val, nums[i] + self._rob_house(nums, i - 2))
        self.cache[end_index] = max_val
        return max_val

    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        l = len(nums)
        if l == 0:
            return 0
        self.cache = [-1] * l
        return self._rob_house(nums, l - 1)
```
注意：先判断是否越界，再判断是否缓存！！！
注意：先判断是否越界，再判断是否缓存！！！
注意：先判断是否越界，再判断是否缓存！！！
加缓存其实是很快的！

动态规划的解法：
```python
class Solution:

    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        if n == 0:
            return 0
        dp = [-1] * n

        if n <= 2:
            return max(nums)
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])

        for i in range(2, n):
            dp[i] = max(nums[i] + dp[i - 2], dp[i - 1])
        return dp[-1]
```
注意：小问题的时候，容易忽略。

动态规划的时候，考虑一下，是不是可以节约一下空间。
```python
class Solution:

    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        if n == 0:
            return 0

        if n <= 2:
            return max(nums)
        dp = [-1] * 2

        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])

        for i in range(2, n):
            dp[i % 2] = max(nums[i] + dp[(i - 2) % 2], dp[(i - 1) % 2])
        return dp[(n - 1) % 2]
```


既然只有两个变量，更酷炫的写法：
```python
class Solution:

    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        if n == 0:
            return 0
        if n <= 2:
            return max(nums)
        pp = nums[0]
        p = max(pp, nums[1])
        for i in range(2, len(nums)):
            tmp = p
            p = max(pp + nums[i], p)
            pp = tmp

        return p
```