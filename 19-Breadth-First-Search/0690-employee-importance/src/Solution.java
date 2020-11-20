import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};

public class Solution {

    private int res = 0;
    private Set<Integer> visited;
    private Map<Integer, Employee> map;

    // 深度优先遍历

    public int getImportance(List<Employee> employees, int id) {
        int size = employees.size();
        map = new HashMap<>(size);
        visited = new HashSet<>(size);

        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }

        dfs(map.get(id));
        return this.res;
    }

    private void dfs(Employee employee) {
        if (visited.contains(employee.id)) {
            return;
        }
        visited.add(employee.id);
        this.res += employee.importance;

        // 遍历 id 的所有下属
        for (Integer id : employee.subordinates) {
            dfs(map.get(id));
        }
    }

    public static void main(String[] args) {
        Employee employee1 = new Employee();
        employee1.id = 1;
        employee1.importance = 5;
        List<Integer> subordinates1 = new ArrayList<>();
        subordinates1.add(2);
        subordinates1.add(3);
        employee1.subordinates = subordinates1;

        Employee employee2 = new Employee();
        employee2.id = 2;
        employee2.importance = 3;
        employee2.subordinates = new ArrayList<>();

        Employee employee3 = new Employee();
        employee3.id = 3;
        employee3.importance = 3;
        employee3.subordinates = new ArrayList<>();

        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

        Solution solution = new Solution();
        int importance = solution.getImportance(employees, 1);
        System.out.println(importance);
    }
}