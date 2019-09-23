from typing import List


class Solution:
    def findOcurrences(self, text: str, first: str, second: str) -> List[str]:
        res = []
        # 特判
        text_arr = text.split()
        size = len(text_arr)
        if size < 3:
            return res

        flag = 0
        for i in range(size):
            if flag == 2:
                res.append(text_arr[i])

            if text_arr[i] == first:
                flag = 1
            elif flag == 1 and text_arr[i] == second:
                flag = 2
            else:
                flag = 0

        return res
