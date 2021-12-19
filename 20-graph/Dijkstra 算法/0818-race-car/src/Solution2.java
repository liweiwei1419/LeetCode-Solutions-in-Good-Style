import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution2 {

    // 方法二：Dijkstra 算法（难理解）
    // 参考资料：https://www.cnblogs.com/grandyang/p/10360655.html

    public int racecar(int target) {
        // K 的含义暂时不用理解
        int K = 33 - Integer.numberOfLeadingZeros(target - 1);

        // 分割线
        int barrier = 1 << K;

        // Dijkstra 算法
        int[] dist = new int[2 * barrier + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[target] = 0;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[]{0, target});

        while (!minHeap.isEmpty()) {
            int[] front = minHeap.poll();
            int steps = front[0];
            int targ1 = front[1];

            if (dist[Math.floorMod(targ1, dist.length)] > steps) {
                continue;
            }

            for (int i = 0; i <= K; ++i) {
                int walk = (1 << i) - 1;
                int targ2 = walk - targ1;
                int steps2 = steps + i + (targ2 != 0 ? 1 : 0);

                if (Math.abs(targ2) <= barrier && steps2 < dist[Math.floorMod(targ2, dist.length)]) {
                    minHeap.offer(new int[]{steps2, targ2});

                    // 更新
                    dist[Math.floorMod(targ2, dist.length)] = steps2;
                }
            }
        }
        return dist[0];
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int target = 6;
        int res = solution2.racecar(target);
        System.out.println(res);

        // 求模的时候 符号与 除数相关 求余的时候与被除数相关
        System.out.println(Math.floorMod(10, 3));
        System.out.println(Math.floorMod(-8, 3));
    }
}