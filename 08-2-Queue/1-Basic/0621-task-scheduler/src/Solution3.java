public class Solution3 {

    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        // 最多的执行次数
        int maxExec = 0;
        for (char task : tasks) {
            freq[task - 'A']++;
            maxExec = Math.max(maxExec, freq[task - 'A']);
        }

        // 具有最多执行次数的任务数量
        int maxCount = 0;
        for (int i = 0; i < 26; i++) {
            int value = freq[i];
            if (value == maxExec) {
                maxCount++;
            }
        }
        return Math.max((maxExec - 1) * (n + 1) + maxCount, tasks.length);
    }
}