from typing import List


class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        size = len(s)
        if size < 4 or size > 12:
            return []

        path = []
        res = []
        self.__dfs(s, size, 0, 0, path, res)
        return res

    def __dfs(self, s, size, split_times, begin, path, res):
        if begin == size:
            if split_times == 4:
                res.append('.'.join(path))
            return

        if size - begin < (4 - split_times) or size - begin > 3 * (4 - split_times):
            return

        for i in range(3):
            if begin + i >= size:
                break

            ip_segment = self.__judge_if_ip_segment(s, begin, begin + i)

            if ip_segment != -1:
                path.append(str(ip_segment))
                self.__dfs(s, size, split_times + 1, begin + i + 1, path, res)
                path.pop()

    def __judge_if_ip_segment(self, s, left, right):
        size = right - left + 1

        if size > 1 and s[left] == '0':
            return -1

        res = 0
        for i in range(left, right + 1):
            res = res * 10 + ord(s[i]) - ord('0')

        if res > 255:
            return - 1
        return res
