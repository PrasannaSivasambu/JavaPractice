import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return Objects.hash(this.department);
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.name+" "+this.department+" "+this.salary;
    }
}
public class TotalSalaryDepartmentwise {

    public static void main(String[] args) {
        Employee em=new Employee("Alice", "H", 5000);
        
     List<Employee> employees = Arrays.asList(
            new Employee("Alice", "HR", 50000),
            new Employee("Bob", "IT", 70000),
            new Employee("Charlie", "HR", 60000),
            new Employee("David", "IT", 80000)
        );

        List<Employee> employees1 = Arrays.asList(
            new Employee("blice", "HR", 60000),
            new Employee("Cob", "IT", 80000),
            new Employee("Dharlie", "HR", 70000),
            new Employee("Eavid", "IT", 100000)
        );

        List<Employee> employees2 = Arrays.asList(
            new Employee("mlice", "HR", 60000),
            new Employee("mob", "IT", 80000),
            new Employee("mharlie", "HR", 70000),
            new Employee("mavid", "IT", 100000)
        );

        employees.stream().collect(Collectors.toMap(key->key.department, value->value.salary, (v1,v2)->v1+v2))
        .entrySet().stream().forEach(c->System.out.println(c.getKey()+" "+c.getValue()));

        Employee e1=new Employee("Alice", "IT", 50000);
        Employee e2=new Employee("Bob", "IT", 70000);

        Stream.concat(employees1.stream(),Stream.concat(employees2.stream(), employees.stream())).map(e->e.name).forEach(System.out::println);

        System.out.println(e1.equals(e2));
        System.out.println("jiol "+employees.contains(em));

        int hash = Objects.hash("key");
        System.out.println(hash);





        
    }

        
    
}
