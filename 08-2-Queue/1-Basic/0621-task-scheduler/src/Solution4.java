import java.util.Arrays;

public class Solution4 {

    // https://leetcode-cn.com/problems/task-scheduler/solution/jian-ming-yi-dong-de-javajie-da-by-lan-s-jfl9/

    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }
        Arrays.sort(freq);

        int maxTimes = freq[25];
        int maxCount = 1;
        for (int i = 25; i >= 1; i--) {
            if (freq[i] == freq[i - 1]) {
                maxCount++;
            } else {
                break;
            }
        }
        int res = (maxTimes - 1) * (n + 1) + maxCount;
        return Math.max(res, tasks.length);
    }
}
