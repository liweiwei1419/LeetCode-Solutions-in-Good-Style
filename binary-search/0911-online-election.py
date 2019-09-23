from typing import List


class TopVotedCandidate:

    # 时间复杂度：O(\log N)
    # 空间复杂度：O(N)

    def __init__(self, persons: List[int], times: List[int]):
        from collections import defaultdict
        self.times = times

        # 每个时刻投票最多的那个人是谁
        self.most_table = []
        # 计数器，key 是 person 的编号，value 是 person 当前时刻的投票数
        counter = defaultdict(int)

        # 可以理解为哨兵
        most_person = -1
        for person, time in zip(persons, times):
            counter[person] = counter[person] + 1
            # 这一句就包括了最近投票优先的情况
            if counter[most_person] <= counter[person]:
                most_person = person
            self.most_table.append(most_person)

    def q(self, t: int) -> int:
        left = 0
        right = len(self.times) - 1
        # 找到第一个小于等于 t 的 times 位置，
        # 然后返回这个位置对应的时间得票最多的 person 即可
        while left < right:
            mid = (left + right + 1) >> 1
            if self.times[mid] > t:
                # 大于肯定不是
                right = mid - 1
            else:
                left = mid
        return self.most_table[left]

# Your TopVotedCandidate object will be instantiated and called as such:
# obj = TopVotedCandidate(persons, times)
# param_1 = obj.q(t)
