from typing import List
from collections import defaultdict
from collections import deque


class Solution:
    def maxProbability(self, n: int, edges: List[List[int]], succProb: List[float], start: int, end: int) -> float:
        d = defaultdict(list)
        for (x, y), p in zip(edges, succProb):
            d[x].append((y, p))
            d[y].append((x, p))

        queue = deque([(start, 1), ])
        record = defaultdict(int)
        res = 0
        while queue:
            node, prob = queue.popleft()
            if node == end:
                res = max(res, prob)
                continue

            for next, next_prob in d[node]:
                val = next_prob * prob
                if val > record[next]:
                    record[next] = val
                    queue.append((next, val))
        return res
