from typing import List


class Solution:
    def findOcurrences(self, text: str, first: str, second: str) -> List[str]:
        res = []
        combination = first + ' ' + second + ' '
        text = text + ' '
        word_len = len(combination)
        start = 0
        while True:
            idx = text.find(combination, start)
            start = idx
            if idx == -1:
                break
            third_word_end = text.find(' ', start + word_len)
            third_word = text[start + word_len:third_word_end]
            if third_word != '':
                res.append(third_word)
            start = idx + word_len
        return res


if __name__ == '__main__':
    text = "alice is a good girl she is a good student"
    first = "a"
    second = "good"

    combination = first + ' ' + second

    print(text.index(combination))

    solution = Solution()
    res = solution.findOcurrences(text, first, second)
    print(res)
