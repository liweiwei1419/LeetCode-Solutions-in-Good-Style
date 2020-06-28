from typing import List


class Solution:
    def letterCombinations(self, digits: str) -> List[str]:

        conversion = {'2': 'abc', '3': 'def', '4': 'ghi', '5': 'jkl', '6': 'mno', '7': 'pqrs', '8': 'tuv', '9': 'wxyz'}
        if len(digits) == 0:
            return []
        res = ['']
        for k in digits:

            for i in res:
                for j in conversion[k]:
                    res = res + [i + j]
                    # res.append(i + j)
                # 在这里打印 res 观察
                # res = res + [i + j] 这种写法更换了 res 这个变量的指向，for i in res: 里面的 res 依旧不变
                # 而 res.append(i + j) 这种写法直接在 for i in res: 的 res 里添加元素，所以列表会膨胀，永远退不出循环
                print(res)
                res.remove(i)

        return res


if __name__ == '__main__':
    solution = Solution()
    s = "23"
    res = solution.letterCombinations(s)
    print(res)
