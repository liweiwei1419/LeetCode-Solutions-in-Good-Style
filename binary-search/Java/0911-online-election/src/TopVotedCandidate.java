import java.util.HashMap;
import java.util.Map;

/**
 * @author liwei
 * @date 2019/9/6 8:14 AM
 */
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
            int mid = (left + right + 1) >>> 1;
            if (this.times[mid] > t) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return this.winners[left];
    }

    public static void main(String[] args) {
        int[] persons = {0, 1, 1, 0, 0, 1, 0};
        int[] times = {0, 5, 10, 15, 20, 25, 30};
        TopVotedCandidate obj = new TopVotedCandidate(persons, times);
        int param_1 = obj.q(24);
        System.out.println(param_1);
    }
}
