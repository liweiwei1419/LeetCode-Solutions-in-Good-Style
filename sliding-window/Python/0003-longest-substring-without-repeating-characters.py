class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        size = len(s)
        if size < 2:
            return size
        left = 0
        right = 0

        win_freq = [0] * 128
        count = 0
        res = 0
        while right < size:
            if win_freq[ord(s[right])] > 0:
                # 大于 0 表示重复了
                count += 1
            win_freq[ord(s[right])] += 1
            right += 1

            while count > 0:
                if win_freq[ord(s[left])] > 1:
                    count -= 1
                win_freq[ord(s[left])] -= 1
                left += 1

            res = max(res, right - left)
        return res
