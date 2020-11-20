import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Solution2 {

    public int getImportance(List<Employee> employees, int id) {
        int size = employees.size();
        Map<Integer, Employee> map = new HashMap<>(size);
        Set<Integer> visited = new HashSet<>(size);

        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        int res = 0;

        Stack<Integer> stack = new Stack<>();
        stack.add(id);
        while (!stack.isEmpty()) {
            Integer topId = stack.pop();
            res += map.get(topId).importance;
            visited.add(topId);

            for (Integer subordinateId : map.get(topId).subordinates) {
                // 如果没有访问过，才添加到 stack 中
                if (visited.contains(subordinateId)) {
                    continue;
                }
                stack.push(subordinateId);
            }
        }
        return res;

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

        Solution2 solution2 = new Solution2();
        int importance = solution2.getImportance(employees, 1);
        System.out.println(importance);
    }
}