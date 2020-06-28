from typing import List
from collections import deque


class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        word_set = set(wordList)
        if endWord not in word_set:
            return 0
        if beginWord in word_set:
            word_set.remove(beginWord)

        queue = deque()
        queue.append(beginWord)

        visited = set(beginWord)
        visited.add(beginWord)

        wordlength = len(beginWord)

        step = 1
        while queue:
            size = len(queue)
            for i in range(size):
                word = queue.popleft()
                word_list = list(word)

                for j in range(wordlength):
                    origin_char = word_list[j]

                    for k in range(26):
                        if ord(origin_char) == k:
                            continue
                        word_list[j] = chr(ord('a') + k)
                        next_word = ''.join(word_list)
                        if next_word in word_set:
                            if next_word == endWord:
                                return step + 1
                            if next_word not in visited:
                                queue.append(next_word)
                                visited.add(next_word)  # 这一行加不加我的答案都是错的
                    word_list[j] = origin_char
            step += 1
        return 0
