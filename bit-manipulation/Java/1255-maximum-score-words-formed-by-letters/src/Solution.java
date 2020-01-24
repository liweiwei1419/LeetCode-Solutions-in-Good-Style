public class Solution {

    /**
     * 返回 words 的一个子集里的字符频数数组
     *
     * @param words 单词数组
     * @param bit   对应一个单词集合的子集
     * @return
     */
    private int[] subset(String[] words, int bit) {
        // 一个 bit （用二进制表示）与一个单词的子集一一对应
        int[] g = new int[26];
        int len = words.length;
        for (int i = 0; i < len; i++) {
            if ((bit & (1 << i)) != 0) {
                continue;
            }

            for (char c : words[i].toCharArray()) {
                g[c - 'a']++;
            }
        }
        return g;
    }

    /**
     *
     * @param group
     * @param letterCount
     * @param score
     * @return
     */
    private int calculateScore(int[] group, int[] letterCount, int[] score) {
        int s = 0;
        for (int i = 0; i < 26; i++) {
            // 如果组成这个子集，字符数都不够用（这里是严格大于），说明这种组合不存在
            // 因此，得分为 0
            if (letterCount[i] < group[i]) {
                return 0;
            }
            s += group[i] * score[i];
        }
        return s;
    }

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        // 所有的字符都可能被使用，统计一下至多能使用的字符数量
        int[] letterCount = new int[26];
        for (char letter : letters) {
            letterCount[letter - 'a']++;
        }

        // 枚举 words 的所有子集，每个单词有选和不选两种可能，因此有 2 ^ len 种可能
        int len = words.length;
        int size = 1 << len;
        int res = 0;

        for (int i = 0; i < size; i++) {
            // 根据 i 的二进制表示，得到一个 words 的子集
            int[] subset = subset(words, i);
            res = Math.max(res, calculateScore(subset, letterCount, score));
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
//        System.out.println(nums.length);

        String[] words = new String[]{"dog", "cat", "dad", "good"};
        char[] letters = new char[]{'a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o' };
        int[] score = new int[]{1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        Solution solution = new Solution();
        int res = solution.maxScoreWords(words, letters, score);
        System.out.println(res);
    }
}
