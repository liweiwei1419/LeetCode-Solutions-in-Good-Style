class Solution:
    def frequencySort(self, s):
        """
        :type s: str
        :rtype: str
        """

        d = dict()
        # 词频统计
        for char in s:
            d[char] = d.setdefault(char, 0) + 1
        # 按照词频降序排序
        sorted_item = sorted(d.items(), key=lambda x: x[1], reverse=True)
        result = ''
        for key, count in sorted_item:
            result += key * count
        return result


if __name__ == '__main__':
    string = 'tree'
    s = Solution()
    res = s.frequencySort(string)
    print(res)
