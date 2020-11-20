import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


public class Solution3 {

    // 广度优先遍历，使用队列

    public int getImportance(List<Employee> employees, int id) {
        int size = employees.size();
        Map<Integer, Employee> map = new HashMap<>(size);
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }

        Queue<Integer> queue = new LinkedList<>();
        int res = 0;
        // 加入队尾
        queue.offer(id);
        while (!queue.isEmpty()) {
            // 队头拿出
            Integer currentId = queue.poll();

            Employee currentEmployee = map.get(currentId);
            res += currentEmployee.importance;
            for (Integer eid : currentEmployee.subordinates) {
                queue.offer(eid);
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

        Solution3 solution3 = new Solution3();
        int importance = solution3.getImportance(employees, 1);
        System.out.println(importance);
    }
}