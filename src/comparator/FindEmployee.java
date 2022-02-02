package comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class FindEmployee {
	
	@Test
	public void findEmployee() {
	List<EmployeeDetails> emp = new ArrayList<EmployeeDetails>();
		emp.add(new EmployeeDetails("1001","Sam David","QA Software Engineer"));
		emp.add(new EmployeeDetails("1003","Gopi","Automation Architect"));
		emp.add(new EmployeeDetails("1006","Naveen","Jr.Test Engineer"));
		emp.add(new EmployeeDetails("1007","Balaji","QA Software Engineer"));
		emp.add(new EmployeeDetails("1010","Koushik","QA Software Engineer"));
		emp.add(new EmployeeDetails("1019","Narashimhan","Digital Marketing Consultant"));
		
		List<EmployeeDetails> sortedList = emp.stream().filter(emp1 -> emp1.getEmpDesignation().contains("Engineer"))
		.sorted(Comparator.comparing(EmployeeDetails::getEmpId)).collect(Collectors.toList());
		
		System.out.println(sortedList.get(sortedList.size()-1).getEmpName().toString());
		
	
	}
}
