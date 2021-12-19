import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;

public class Solution {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int len = groupSizes.length;
        List<List<Integer>> res = new ArrayList<>();
        // 特判
        if (len == 0) {
            return res;
        }

        // 使用最小堆，int[] 的长度为 2，第 1 个数是数组元素，第 2 个数是数组下标，把数和下标绑定在了一起，在堆中参与比较的是数，下标是依附于数的
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(len, Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < len; i++) {
            minHeap.add(new int[]{groupSizes[i], i});
        }

        while (!minHeap.isEmpty()) {
            int curSize = minHeap.peek()[0];

            List<Integer> currList = new ArrayList<>();
            for (int i = 0; i < curSize; i++) {
                currList.add(minHeap.poll()[1]);
            }

            res.add(currList);
        }
        return res;
    }
}