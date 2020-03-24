import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author liweiwei1419
 * @date 2019/12/1 8:06 上午
 */
public class Solution {

    /**
     * 邻接表
     */
    private Map<Integer, Set<Integer>> graph;

    /**
     * 以 i 为根结点的树的结点个数之和
     */
    private int[] size;
    /**
     * 以 i 为根结点的树的结点 value 之和
     */
    private int[] sum;

    /**
     * 需要删除的结点个数
     */
    private int deleteCount;

    public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        // 0、初始化一些全局变量
        deleteCount = 0;
        // 在前序位置初始化的时候，根据需要在后序位置更新
        size = new int[nodes];
        // 一开始的时候就初始化
        sum = new int[nodes];
        for (int i = 0; i < nodes; i++) {
            sum[i] = value[i];
        }

        // 1、构建邻接表
        buildAdjacencyList(nodes, parent);

        // 2、从根结点开始执行一次深度优先遍历，在"后序"位置操作
        dfs(0);
        return nodes - deleteCount;
    }

    // 后序遍历
    private int[] dfs(int i) {
        size[i] = 1;

        // 要注意的地方
        if (graph.containsKey(i)) {
            Set<Integer> successors = graph.get(i);
            for (Integer successor : successors) {
                int[] res = dfs(successor);
                size[i] += res[0];
                sum[i] += res[1];
            }
        }

        if (sum[i] == 0) {
            deleteCount += size[i];
            size[i] = 0;
        }
        return new int[]{size[i], sum[i]};
    }

    /**
     * 构建邻接表
     *
     * @param nodes
     * @param parent
     */
    private void buildAdjacencyList(int nodes, int[] parent) {
        graph = new HashMap<>();
        // 从 1 开始即可
        for (int i = 1; i < nodes; i++) {
            if (graph.containsKey(parent[i])) {
                graph.get(parent[i]).add(i);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(i);
                graph.put(parent[i], set);
            }
        }
    }

    public static void main(String[] args) {
        int nodes = 7;
        int[] parent = {-1, 0, 0, 1, 2, 2, 2};
        int[] value = {1, -2, 4, 0, -2, -1, -1};

        Solution solution = new Solution();
        int res = solution.deleteTreeNodes(nodes, parent, value);
        System.out.println(res);
    }
}
