class Solution:
    def frequencySort(self, s: str) -> str:
        hash = dict()
        # 词频统计
        for char in s:
            hash[char] = hash.setdefault(char, 0) + 1
        # 按照词频降序排序
        sorted_item = sorted(hash.items(), key=lambda x: x[1], reverse=True)
        res = ''
        for key, count in sorted_item:
            res += key * count
        return res


if __name__ == '__main__':
    string = 'tree'
    s = Solution()
    res = s.frequencySort(string)
    print(res)
