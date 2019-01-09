# 用户输入字符
c = 'a'

print(c + " 的ASCII 码为", ord(c))

# 用户输入ASCII码，并将输入的数字转为整型
a = 98

print(a, " 对应的字符为", chr(a))


# 记忆方法：函数名表示了返回值的类型
# ord 表示顺序，所以返回的是数值，即输入字母，返回数值
# chr 表示字母，所以返回的是字母，即输入数字，返回字母


class Solution:
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """

        # 关键点：有遇到重复的：abcafc，到 a 的时候，
        # pointer 就应该更新到【之前】重复的那个位置的下一个，
        # 这样才会使得 [point,i] 这个区间没有重复元素【紧紧抓住这一点】
        # 这样才会使得 [point,i] 这个区间没有重复元素【紧紧抓住这一点】
        # 这样才会使得 [point,i] 这个区间没有重复元素【紧紧抓住这一点】

        # 全局使用的字典，保存了遍历遇到的字母的最新索引值
        # 遇到重复的字母，索引更新为当前的（即覆盖）
        # 设计一个规则 [pointer,i] 这个区间里一定没有重复元素
        # 所以就要结束一个 map 或者 list 来判断是否有重复元素

        # 遇到重复的字母的时候，才去更新，更新到重复字母的下一个位置

        # 以上的思想其实就是【滑动窗口】

        if len(s) < 2:
            return len(s)

        max_len = 0
        pointer = 0
        map = dict()

        for index, c in enumerate(s):
            if c in map:
                # 更新 pointer 的位置
                # 【pointer 的位置只能越来越后】
                # 【pointer 的位置只能越来越后】
                # 【pointer 的位置只能越来越后】
                pointer = max(pointer, map[c] + 1)
                # 调试代码
                # print('point：', pointer)
            # 从 [pointer,i] 这个区间里，都没有重复的字符串
            # [3,4,5,6] 这个区间一共有 6-3+1=4 个元素
            # 每一次都要更新 map 和 max_len
            # 【max_len】 也一定只会越来越大
            max_len = max(max_len, index - pointer + 1)
            # 不论怎么样都要更新 map
            map[c] = index
        return max_len


if __name__ == '__main__':
    # 理解代码运行流程的最佳测试用例
    s = 'abcaec'
    solution = Solution()
    result = solution.lengthOfLongestSubstring(s)
    print(result)
