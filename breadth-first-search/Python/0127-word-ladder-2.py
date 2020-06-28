from typing import List


class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList:
            return 0
        hash_map = dict()

        # 预处理，key：单词，value：后继单词列表
        for word in wordList:
            for i in range(len(word)):
                next_word = word[:i] + "*" + word[i + 1:]
                if next_word not in hash_map:
                    hash_map[next_word] = []
                hash_map[next_word].append(word)

        queue = [(beginWord, 1)]
        visited = set()
        visited.add(beginWord)

        for next_word, step in queue:
            if next_word == endWord:
                return step

            for i in range(len(next_word)):
                w2 = next_word[:i] + "*" + next_word[i + 1:]
                for word in hash_map.get(w2, []):
                    if word in visited:
                        continue
                    if sum([next_word[i] != word[i] for i in range(len(next_word))]) == 1:
                        queue.append((word, step + 1))
                        visited.add(word)
        return 0


if __name__ == '__main__':
    beginWord = "hit"
    endWord = "cog"
    wordList = ["hot", "dot", "dog", "lot", "log", "cog"]
    solution = Solution()
    res = solution.ladderLength(beginWord, endWord, wordList)
    print(res)
