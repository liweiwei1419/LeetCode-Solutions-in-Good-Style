import java.util.HashMap;
import java.util.Map;

public class TopVotedCandidate {

    /**
     * 在每个时刻的获胜者
     */
    private int[] winners;
    private int[] times;
    private int len;

    // 参考资料：https://unclegem.cn/2019/05/10/Leetcode学习笔记-911-在线选举/

    public TopVotedCandidate(int[] persons, int[] times) {
        this.len = persons.length;
        this.times = times;
        this.winners = new int[len];
        // 存当前时刻投票最多的用户
        Map<Integer, Integer> hash = new HashMap<>();
        int winner = -1;
        for (int i = 0; i < len; i++) {
            hash.put(persons[i], hash.getOrDefault(persons[i], 0) + 1);
            if (hash.getOrDefault(winner, 0) <= hash.get(persons[i])) {
                winner = persons[i];
            }
            winners[i] = winner;
        }
    }

    public int q(int t) {
        // 找第一个小于等于的时刻，大于的肯定不是
        int left = 0;
        int right = this.len - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (this.times[mid] > t) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return this.winners[left];
    }
}