import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 由于不能确定结果集有多少区间，使用动态数组
        List<int[]> res = new ArrayList<>();
        // 遍历输入 intervals 的下标
        int index = 0;
        int len = intervals.length;
        // 第 1 步：先把结束在 newInterval[0] 之前的加入结果集
        while (index < len && intervals[index][1] < newInterval[0]) {
            res.add(new int[]{intervals[index][0], intervals[index][1]});
            index++;
        }

        // 第 2 步：和 newInterval 覆盖的区间进行合并（更新 newInterval 的起始端点）
        // 注意：这里需要画图理解
        while (index < len && intervals[index][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[index][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[index][1]);
            index++;
        }
        res.add(new int[]{newInterval[0], newInterval[1]});

        // 第 3 步：把剩下的与 newInterval 不重合的区间加入 res
        while (index < len) {
            res.add(new int[]{intervals[index][0], intervals[index][1]});
            index++;
        }

        // 第 4 步：动态数组转换成数组 Array
        int size = res.size();
        int[][] resArray = new int[size][2];
        for (int i = 0; i < size; i++) {
            resArray[i] = res.get(i);

        }
        return resArray;
    }
}