class Solution:

    res = 0

    def numTilePossibilities(self, tiles: str) -> int:
        counter = [0] * 26
        for alpha in tiles:
            counter[ord(alpha) - ord('A')] += 1
        self.__dfs(counter)
        return self.res

    def __dfs(self, counter):
        for i in range(26):
            if counter[i] == 0:
                # 剪枝
                continue
            self.res += 1
            counter[i] -= 1

            self.__dfs(counter)
            counter[i] += 1


if __name__ == '__main__':
    tiles = "AAABBC"

    solution = Solution()

    res = solution.numTilePossibilities(tiles)
    print(res)
