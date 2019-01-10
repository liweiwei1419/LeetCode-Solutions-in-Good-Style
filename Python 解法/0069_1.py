class Solution:
    # 牛顿法
    # 与系统函数作比较

    def mySqrt(self, x):
        """
        :type x: int
        :rtype: int
        """
        if x < 0:
            raise Exception('不能输入负数')
        if x == 0:
            return 0

        cur = -5
        while True:
            pre = cur
            cur = (cur + x / cur) / 2
            if abs(cur - pre) < 1e-6:
                return cur

    # 这个解直接提交到 LeetCode 上就可以了
    def mySqrt1(self, x):
        """
        :type x: int
        :rtype: int
        """
        if x < 0:
            raise Exception('不能输入负数')
        if x == 0:
            return 0
        # 起始的时候在 1 ，这可以比较随意设置
        cur = 1
        while True:
            pre = cur
            cur = (cur + x / cur) / 2
            if abs(cur - pre) < 1e-6:
                return int(cur)


if __name__ == '__main__':
    import numpy as np

    nums = np.linspace(0, 999, 100)
    solution = Solution()
    for num in nums:
        a = solution.mySqrt(num)
        b = np.sqrt(num)
        print("牛顿法：{} \t NumPy：{}\t 差距：{}".format(abs(a), abs(b), abs(a) - abs(b)))
