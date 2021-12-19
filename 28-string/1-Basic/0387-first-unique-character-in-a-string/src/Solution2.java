import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    private List<Integer>[] adj;
    private boolean[] visited;
    private List<Integer> res;

    public List<Integer> traverse(List<Integer>[] adj) {
        this.adj = adj;
        this.visited = new boolean[6];
        this.res = new ArrayList<>();
        dfs(0);
        return res;
    }

    private void dfs(int u) {
        visited[u] = true;
        res.add(u);
        List<Integer> successors = adj[u];
        for (int successor : successors) {
            if (!visited[successor]) {
                // 写在这里就是前序遍历
                dfs(successor);
                // 写在这里就是后序遍历

            }
        }
    }

    // 把这部分内容工具化

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        List<Integer>[] adj = new ArrayList[6];
        List<Integer> zero = new ArrayList<>();
        zero.add(1);
        zero.add(2);
        zero.add(5);
        List<Integer> one = new ArrayList<>();
        one.add(0);
        one.add(2);
        one.add(5);
        List<Integer> two = new ArrayList<>();
        two.add(0);
        two.add(1);
        two.add(3);
        List<Integer> three = new ArrayList<>();
        three.add(2);
        three.add(4);
        List<Integer> four = new ArrayList<>();
        four.add(3);
        four.add(5);
        List<Integer> five = new ArrayList<>();
        five.add(0);
        five.add(1);
        five.add(4);

        adj[0] = zero;
        adj[1] = one;
        adj[2] = two;
        adj[3] = three;
        adj[4] = four;
        adj[5] = five;

        List<Integer> res = solution2.traverse(adj);
        System.out.println(res);
    }
}
