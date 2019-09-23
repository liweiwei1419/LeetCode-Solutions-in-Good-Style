class Solution:
    def isAnagram(self, s: str, t: str) -> bool:

        if len(s) != len(t):
            return False
        arr_s = list(s)
        arr_t = list(t)
        arr_s.sort()
        arr_t.sort()
        for char_s, char_t in zip(arr_s, arr_t):
            if char_s != char_t:
                return False
        return True


if __name__ == '__main__':
    s = "anagram"
    t = "nagaram"

    solution = Solution()
    result = solution.isAnagram(s, t)
    print(result)
