class Solution:
    def minWindow(self, s: str, t: str) -> str:
        s_len = len(s)
        t_len = len(t)

        window = [0] * 128
        pattern = [0] * 128

        for t_char in t:
            pattern[ord(t_char)] += 1

        # s 中有多少种字母，重复只计 1 次
        s_count = 0
        # t 中有多少种字母，重复只计 1 次
        t_count = 0

        for i in range(128):
            if pattern[i] > 0:
                t_count += 1

        left = 0
        right = 0
        min_len = s_len + 1
        start = 0

        while right < s_len:
            if pattern[ord(s[right])] > 0:
                window[ord(s[right])] += 1
                if window[ord(s[right])] == pattern[ord(s[right])]:
                    s_count += 1
            right += 1

            while s_count == t_count:
                # 滑动窗口是：[left, right)，其长度： right - left
                if right - left < min_len:
                    min_len = right - left
                    start = left

                if pattern[ord(s[left])] > 0:
                    window[ord(s[left])] -= 1
                    if window[ord(s[left])] < pattern[ord(s[left])]:
                        s_count -= 1
                left += 1

        if min_len == s_len + 1:
            return ""
        return s[start: start + min_len]
