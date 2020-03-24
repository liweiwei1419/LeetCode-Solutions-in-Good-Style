class Solution:
    def isAdditiveNumber(self, num: str) -> bool:
        size = len(num)
        return self.__backtracking(num, 0, size, 0, 0, 0)

    def __backtracking(self, num, start, size, pre_sum, cur_num, split):
        if split > 2 and start == size:
            return True

        for i in range(0, size - start):
            new_num = self.__calculate_new_num(num, start, start + i, pre_sum, split)
            # 这里判断得是大于等于 0，特例 "1,0,1"
            if new_num >= 0:
                if self.__backtracking(num, start + i + 1, size, cur_num + new_num, new_num, split + 1):
                    return True
        return False

    def __calculate_new_num(self, num, left, right, pre_sum, split):
        if left < right and num[left] == '0':
            return -1

        cur_num = 0
        while left <= right:
            cur_num = (cur_num * 10 + ord(num[left]) - ord('0'))
            left += 1

        if split < 2:
            return cur_num

        if pre_sum == cur_num:
            return cur_num
        return -1
