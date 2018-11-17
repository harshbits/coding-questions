package givenbyfriend;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeImportance690 {

	
	public static void main(String[] args) {
		
	}
	public int getImportance(List<Employee> employees, int id) {

		
//		int totalImportance = 0;
		
		Map<Integer, Employee> map = employees.stream().collect(Collectors.toMap(Employee::getId, Function.identity()));
		
//		Employee emp = map.get(id);
//		totalImportance += emp.getImportance();
//		
//		while (!emp.getSubordinates().isEmpty()) {
//			
//			for (int subId : emp.getSubordinates()) {
//
//				Employee e = map.get(subId);
//				totalImportance += e.getId();
//
//			}
//		}
		
		int totalImportance = dfsHelper(map, id);
		
		return totalImportance;
	}
	
	
	
	private int dfsHelper(Map<Integer, Employee> map, int id) {
		
		Employee emp = map.get(id);
		int totalImportance = emp.getImportance();
		for (int subId : emp.getSubordinates()) {
			totalImportance += dfsHelper(map, subId);
		}
		return totalImportance;
		
	}
	
}

//Employee info
class Employee {
	// It's the unique id of each node;
	// unique id of this employee
	public int id;
	// the importance value of this employee
	public int importance;
	// the id of direct subordinates
	public List<Integer> subordinates;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getImportance() {
		return importance;
	}
	public void setImportance(int importance) {
		this.importance = importance;
	}
	public List<Integer> getSubordinates() {
		return subordinates;
	}
	public void setSubordinates(List<Integer> subordinates) {
		this.subordinates = subordinates;
	}
	
	
};