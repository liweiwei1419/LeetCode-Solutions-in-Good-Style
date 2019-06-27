class Solution:
    def mySqrt(self, x: int) -> int:
        if x == 0:
            return 0

        l = 1
        r = x // 2
        while l < r:
            # 调试代码开始：为了仔细观察区间左右端点，我们每进入一次循环，让线程休眠 1 秒
            import time
            time.sleep(1)
            print('调试代码，观察区间左右端点、中位数，和进入的分支： l = {} , r = {} , '.format(l, r), end='')
            # 调试代码结束

            # 错误代码，在分支左区间不发生收缩的情况下，中位数应该取右中位数
            mid = l + (r - l) // 2

            # 调试代码
            print('mid = {} ,'.format(mid), end=' ')
            square = mid * mid

            if square > x:
                # 调试代码
                print('进入 r = mid - 1 这个分支。')
                r = mid - 1
            else:
                # 调试代码
                print('进入 l = mid 这个分支。')
                l = mid
        return l


if __name__ == '__main__':
    # 当 x = 8 的时候，代码能得出正确答案
    x = 9
    solution = Solution()
    res = solution.mySqrt(x)
    print(res)
