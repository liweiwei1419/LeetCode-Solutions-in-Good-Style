from typing import List


class Solution:
    def findOcurrences(self, text: str, first: str, second: str) -> List[str]:
        res = []
        # 特判
        text_arr = text.split()
        size = len(text_arr)
        if size < 3:
            return res

        # print(text_arr)
        for i in range(size - 2):
            # print(i,text_arr[i],text_arr[i + 1])
            if text_arr[i] == first:
                continue
            elif text_arr[i + 1] == second:
                res.append(text_arr[i + 2])
        return res
