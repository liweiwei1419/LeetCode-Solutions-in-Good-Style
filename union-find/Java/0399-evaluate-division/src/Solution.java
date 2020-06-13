import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

    /**
     * 使用深度优先遍历
     *
     * @param equations
     * @param values
     * @param queries
     * @return
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equationsSize = equations.size();
        // 建立邻接表，双向图，如果是有环，直接返回 1 即可
        Map<String, Map<String, Double>> graph = new HashMap<>();

        // graph[a][b] = 2 表示 a / b = 2.0
        for (int i = 0; i < equationsSize; i++) {
            String numerator = equations.get(i).get(0);
            String denominator = equations.get(i).get(1);

            addEdge(graph, numerator, denominator, values[i]);
            addEdge(graph, denominator, numerator, 1.0 / values[i]);
        }

        int len = queries.size();
        double[] res = new double[len];

        for (int i = 0; i < len; i++) {
            String A = queries.get(i).get(0);
            String B = queries.get(i).get(1);

            if (!graph.containsKey(A) || !graph.containsKey(B)) {
                res[i] = -1.0;
                continue;
            }

            Set<String> visited = new HashSet<>(len);
            res[i] = dfs(A, B, graph, visited);
        }
        return res;
    }

    private double dfs(String A, String B, Map<String, Map<String, Double>> graph,
                       Set<String> visited) {
        if (A.equals(B)) {
            return 1.0;
        }

        visited.add(A);

        // 访问 A 的后继结点
        for (Map.Entry<String, Double> entry : graph.get(A).entrySet()) {
            String key = entry.getKey();
            if (visited.contains(key)) {
                continue;
            }

            double d = dfs(key, B, graph, visited);
            if (d > 0) {
                return d * graph.get(A).get(key);
            }

        }
        return -1.0;
    }

    private void addEdge(Map<String, Map<String, Double>> graph, String A, String B, Double value) {
        Map<String, Double> successors;
        if (graph.containsKey(A)) {
            successors = graph.get(A);
            successors.put(B, value);
        } else {
            successors = new HashMap<>();
            successors.put(B, value);
            graph.put(A, successors);
        }
    }

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        List<String> item1 = new ArrayList<>();
        item1.add("a");
        item1.add("b");

        List<String> item2 = new ArrayList<>();
        item2.add("b");
        item2.add("c");

        equations.add(item1);
        equations.add(item2);

        double[] values = new double[]{2.0, 3.0};

        List<List<String>> queries = new ArrayList<>();

        List<String> query1 = new ArrayList<>();
        query1.add("a");
        query1.add("c");

        List<String> query2 = new ArrayList<>();
        query2.add("b");
        query2.add("a");

        List<String> query3 = new ArrayList<>();
        query3.add("a");
        query3.add("e");

        List<String> query4 = new ArrayList<>();
        query4.add("a");
        query4.add("a");

        List<String> query5 = new ArrayList<>();
        query5.add("x");
        query5.add("x");

        queries.add(query1);
        queries.add(query2);
        queries.add(query3);
        queries.add(query4);
        queries.add(query5);

        Solution solution = new Solution();
        double[] res = solution.calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(res));

    }
}
