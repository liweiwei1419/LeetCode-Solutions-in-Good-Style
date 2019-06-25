class Solution:

    def numTilePossibilities(self, tiles: str) -> int:
        counter = [0] * 26
        for alpha in tiles:
            counter[ord(alpha) - ord('A')] += 1
        return self.__dfs(counter)

    def __dfs(self, counter):
        res = 0
        for i in range(26):
            if counter[i] == 0:
                # 剪枝
                continue
            res += 1
            counter[i] -= 1

            res += self.__dfs(counter)
            counter[i] += 1
        return res


if __name__ == '__main__':
    tiles = "AAABBC"

    solution = Solution()

    res = solution.numTilePossibilities(tiles)
    print(res)
