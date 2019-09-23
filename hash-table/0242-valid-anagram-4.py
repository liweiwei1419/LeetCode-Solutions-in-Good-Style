class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        return sorted(list(s)) == sorted(list(t))


if __name__ == '__main__':
    s = 'a'
    t = 'b'
    l1 = ['a', 'b']
    l2 = ['a', 'b']
    print('两个列表相等，当且仅当对应元素全部相等：', l1 == l2)
    solution = Solution()
    result = solution.isAnagram(s, t)
    print(result)
