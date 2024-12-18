import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Employee {
    String name;
    String department;
    double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        Employee e=(Employee)obj;
        
        System.out.println(super.getClass()==obj.getClass());
        return this.department==e.department;
    }
}
public class TotalSalaryDepartmentwise {

    public static void main(String[] args) {
        
     List<Employee> employees = Arrays.asList(
            new Employee("Alice", "HR", 50000),
            new Employee("Bob", "IT", 70000),
            new Employee("Charlie", "HR", 60000),
            new Employee("David", "IT", 80000)
        );

        employees.stream().collect(Collectors.toMap(key->key.department, value->value.salary, (v1,v2)->v1+v2))
        .entrySet().stream().forEach(c->System.out.println(c.getKey()+" "+c.getValue()));

        Employee e1=new Employee("Alice", "IT", 50000);
        Employee e2=new Employee("Bob", "IT", 70000);

        System.out.println(e1.equals(e2));
    }

        
    
}
