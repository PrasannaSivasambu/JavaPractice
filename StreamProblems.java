import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;



public class StreamProblems {
    public static void main(String[] args) {
              
     List<Employee> employees = Arrays.asList(
            new Employee("Alice", "HR", 50000),
            new Employee("Bob", "IT", 70000),
            new Employee("Charlie", "HR", 60000),
            new Employee("Puth", "HR", 70000),
            new Employee("David", "IT", 80000)
        );

       System.out.println(  employees.stream().collect(Collectors.toMap(
            key->key.department,
            value-> value.salary,
            (v1,v2)->(v1>v2)?v1:v2)));

       Set<Employee> e=new HashSet<>(employees);     

       System.out.println(e);
       System.out.println(employees);
    }
}
