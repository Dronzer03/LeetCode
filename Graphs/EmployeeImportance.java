package Graphs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// LC - 690
// https://leetcode.com/problems/employee-importance
public class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        Employee target = null;
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee emp : employees) {
            if (emp.id == id) {
                target = emp;
            }
            map.put(emp.id, emp);
        }
        if (target == null)
            return 0;

        return findImportance(target, map);
    }

    private int findImportance(Employee target, Map<Integer, Employee> map) {
        int importance = target.importance;

        for (int e : target.subordinates) {
            importance += findImportance(map.get(e), map);
        }

        return importance;
    }

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
}
