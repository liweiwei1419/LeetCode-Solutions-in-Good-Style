from typing import List


class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        size = len(envelopes)
        # 特判
        if size < 2:
            return size

        # 对第一列排序，按照宽度排序
        # 【特别注意】当宽度相等的时候，按照高度降序排序
        # 以避免 [[11, 3], [12, 4], [12, 5], [12, 6], [14, 6]] 这种情况发生
        # 正确排序 [[11, 3], [12, 6], [12, 5], [12, 4], [14, 6]]
        envelopes.sort(key=lambda x: (x[0], -x[1]))

        # print(envelopes)
        tail = [envelopes[0][1]]

        for i in range(1, size):
            target = envelopes[i][1]
            if target > tail[-1]:
                tail.append(target)
                continue

            left = 0
            right = len(tail) - 1

            while left < right:
                mid = (left + right) >> 1
                if tail[mid] > target:
                    left = mid + 1
                else:
                    right = mid
            tail[left] = target
        # print(tail)
        return len(tail)


if __name__ == '__main__':
    envelopes = [[4, 5], [4, 6], [6, 7], [2, 3], [1, 1]]
    envelopes = [[30, 50], [12, 2], [3, 4], [12, 15]]
    envelopes = [[1, 3], [3, 5], [6, 7], [6, 8], [8, 4], [9, 5]]
    solution = Solution()
    res = solution.maxEnvelopes(envelopes)
    print(res)
