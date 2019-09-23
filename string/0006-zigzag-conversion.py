class Solution:
    def convert(self, s: str, numRows: int) -> str:
        # 特判
        if numRows < 2:
            return s

        rows = [list() for _ in range(numRows)]
        size = len(s)
        index = 0

        # 遍历每一个字符
        while index < size:
            # 先从上到下
            for i in range(numRows):
                if index >= size:
                    break
                rows[i].append(s[index])
                index += 1

            # 再从下到上
            for i in range(numRows - 2, 0, -1):
                if index >= size:
                    break
                rows[i].append(s[index])
                index += 1
        # 最后合起来
        for i in range(1, numRows):
            rows[0].extend(rows[i])
        return ''.join(rows[0])


if __name__ == '__main__':
    s = "PAYPALISHIRING"
    numRows = 3
    solution = Solution()
    res = solution.convert(s, numRows)
    print(res)
