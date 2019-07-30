# 滑动窗口
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        size = len(s)
        # 特判
        if size < 2:
            return size

        left = 0
        # 滑动窗口的逻辑是尝试向右移动一位，因此，初始值是 -1
        right = -1
        # 设置成 128 与测试用例有关
        counter = [0 for _ in range(128)]
        # 因为自己一定是不重复的子串，在字符串非空的情况下，至少结果为 1
        res = 1
        # 认为左边界更重要，有重复的子串，我们记录左边，舍弃右边，因此左边界如果越界了，算法停止
        while left < size:
            # right + 1 表示最多到 len - 1
            # counter[s.charAt(right + 1)] == 0 表示在 [left, right] 这个区间里没有出现
            if right + 1 < size and counter[ord(s[right + 1])] == 0:
                # 表示没有重复元素，right 可以加 1
                counter[ord(s[right + 1])] += 1
                right += 1
            else:
                # 如果下一个字符已经越界了，或者右边第 1 个字母是频率数组是曾经出现过的
                # 把左边从频数数组中挪掉，频数减 1
                counter[ord(s[left])] -= 1
                left += 1
            # 经过上面的分支，窗口 [left, right] 内一定没有重复元素，故记录最大值
            res = max(res, right - left + 1)
        return res
