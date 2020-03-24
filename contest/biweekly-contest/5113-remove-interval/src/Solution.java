import java.util.ArrayList;
import java.util.List;

/**
 * @author liweiwei1419
 * @date 2019/12/1 7:41 上午
 */
public class Solution {

    // 1、这里要注意：toBeRemoved 只有 1 个；
    // 2、画图；
    // 3、学习一下扫描线法；
    // 4、注意讨论一下边界情况

    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> res = new ArrayList<>();
        int len = intervals.length;
        for (int i = 0; i < len; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];

            if (right <= toBeRemoved[0]) {
                // 注意：这里是等于，此时直接把区间加到结果集里
                List<Integer> interval = new ArrayList<>();
                interval.add(left);
                interval.add(right);
                res.add(interval);
            } else if (left < toBeRemoved[0] && right <= toBeRemoved[1]) {
                // 注意：这里是严格小
                List<Integer> interval = new ArrayList<>();
                interval.add(left);
                interval.add(toBeRemoved[0]);
                res.add(interval);
            } else if (left < toBeRemoved[0] && right > toBeRemoved[1]) {
                // 注意：两边都是严格小于，才能加上两段
                List<Integer> interval1 = new ArrayList<>();
                interval1.add(left);
                interval1.add(toBeRemoved[0]);
                res.add(interval1);

                List<Integer> interval2 = new ArrayList<>();
                interval2.add(toBeRemoved[1]);
                interval2.add(right);
                res.add(interval2);
            } else if (left >= toBeRemoved[0] && left <= toBeRemoved[1] && right > toBeRemoved[1]) {
                // 特别注意：&& left <= toBeRemoved[1] 不要漏掉了
                List<Integer> interval = new ArrayList<>();
                interval.add(toBeRemoved[1]);
                interval.add(right);
                res.add(interval);
            } else if (left >= toBeRemoved[1]) {
                List<Integer> interval = new ArrayList<>();
                interval.add(left);
                interval.add(right);
                res.add(interval);
            }
        }
        return res;
    }
}
