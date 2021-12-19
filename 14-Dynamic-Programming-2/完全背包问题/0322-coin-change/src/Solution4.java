import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution4 {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(amount);
        boolean[] visited = new boolean[amount + 1];
        visited[amount] = true;

        // 排序是为了加快广度优先遍历过程中，对硬币面值的遍历，起到剪枝的效果
        Arrays.sort(coins);
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer top = queue.poll();
                for (int coin : coins) {
                    int next = top - coin;
                    // 只要遇到 0，表示找到了最短路径
                    if (next == 0) {
                        return step;
                    }
                    if (next < 0) {
                        // 由于 coins 升序排序，后面的面值会越来越大，后面的硬币就不用再看了
                        break;
                    }

                    if (!visited[next]) {
                        queue.offer(next);
                        // 添加到队列的时候，就应该立即设置为 true，否则还会发生重复访问
                        visited[next] = true;
                    }
                }
            }
            step++;
        }
        // 进入队列的顶点都出队，都没有看到 0，表示凑不出当前面值
        return -1;
    }
}