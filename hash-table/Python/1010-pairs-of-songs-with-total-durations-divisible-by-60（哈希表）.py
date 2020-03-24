from typing import List


class Solution:

    def numPairsDivisibleBy60(self, time: List[int]) -> int:
        # 预处理：把数组中的元素全都模 60
        time = [t % 60 for t in time]

        from collections import defaultdict
        d = defaultdict(int)

        res = 0
        for t in time:
            # 1、先计数
            # 针对 [0, 0, 0] 这一类特殊用例，要模 60
            residue = (60 - t) % 60
            if residue in d:
                res += d[residue]

            # 2、再记录频数
            d[t] += 1

        return res


if __name__ == '__main__':
    time = [60, 60, 60]
    solution = Solution()
    res = solution.numPairsDivisibleBy60(time)
    print(res)
