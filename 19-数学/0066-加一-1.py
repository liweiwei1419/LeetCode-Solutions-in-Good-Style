class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """

        n = len(digits)
        if n == 0:
            return None
        # 从后向前
        for index in range(n - 1, -1, -1):
            if digits[index] < 9:
                digits[index] += 1
                return digits
            else:
                digits[index] = 0
        return [1] + digits
