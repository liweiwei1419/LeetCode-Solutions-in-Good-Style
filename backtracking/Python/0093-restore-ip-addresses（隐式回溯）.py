from typing import List


class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        size = len(s)
        # 剪枝操作，大于 12 的直接不考虑
        if size == 0 or size > 12:
            return []

        res = []
        path = []
        splits = 0

        self.__backtracking(s, 0, size, splits, path, res)
        return res

    def __backtracking(self, s, begin, size, splits, path, res):
        if splits == 4 and begin == size:
            res.append('.'.join(path))
            return

        # 重要操作：剪枝
        if size - begin < (4 - splits) or size - begin > 3 * (4 - splits):
            return

        for i in range(1, 4):
            # 注意：这里是严格大于号，看 s[begin:begin + i] 表达式就清楚
            if begin + i > size:
                break
            ip_segment = s[begin:begin + i]
            if self.__judge_ip_segment(ip_segment):
                self.__backtracking(s, begin + i, size, splits + 1, path + [ip_segment], res)

    def __judge_ip_segment(self, ip_segment):
        if len(ip_segment) > 1 and ip_segment[0] == '0':
            return False
        return int(ip_segment) <= 255


if __name__ == '__main__':
    s = "25525511135"
    solution = Solution()
    res = solution.restoreIpAddresses(s)
    print(res)
