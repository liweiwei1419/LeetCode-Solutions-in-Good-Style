from typing import List

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        def dfs(s, start, length, dp, path, res):
            if start == length:
                # 当字符串走到头了,就将path内部全部加入到res中
                res.append(path)
                return
            else:
                for i in range(start, length):
                    if not dp[start][i]:
                        continue
                    path.append(s[start:i + 1])
                    dfs(s, i + 1, length, dp, path, res)

        length = len(s)
        dp = [[0] * length] * length
        res = []
        if length == 0:
            return res
        for right in range(length):
            for left in range(right + 1):
                if s[left] == s[right] and (right - left <= 2 or dp[left + 1][right - 1]):
                    dp[left][right] = 1
        dfs(s, 0, length, dp, [], res)
        return res