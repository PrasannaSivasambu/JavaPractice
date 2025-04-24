import java.util.*;
import java.util.stream.Collectors;

class Employee {
    public long id;
    public String name;
    public Department dept;

    public Employee(long id, String name, Department dept) {
        this.id = id;
        this.name = name;
        this.dept = dept;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "id : " + id + " Name :" +name+ " Dept : "+ dept.deptName;
    }
   
}

class Department {
    public long deptId;
    public String deptName;

    public Department(long deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }
    @Override
    public boolean equals(Object obj) {

        Department d=(Department)obj; 
        // TODO Auto-generated method stub
        return this.deptName.equals(d.deptName);
    }
}

public class EmployeeMain {
    public static void main(String[] args) {
        List<Employee> list = Arrays.asList(
            new Employee(1, "Alice", new Department(101, "HR")),
            new Employee(2, "Bob", new Department(102, "Finance")),
            new Employee(3, "Charlie", new Department(101, "HR"))
        );

        // Corrected grouping logic
        Map<String, List<Employee>> map = list.stream()
            .collect(Collectors.groupingBy(e -> e.dept.deptName));

        // Print the grouped result
        map.forEach((deptName, employees) -> {
            System.out.println(deptName + ": " + employees.stream()
                .map(emp -> emp.name)
                .collect(Collectors.joining(", ")));
        });

        String s1 = new String("siva"); // Forces storage in String Pool
        String s2 = "siva";

        System.out.println(s1 == s2); // true (both refer to the same object in the pool)

        Department d=new Department(101, "HR");
        Department e=new Department(101, "HR");
       System.out.println( e.equals(d));


       List<Employee> listee = Arrays.asList(
            new Employee(1, "Alice", new Department(101, "HR")),
            new Employee(2, "Bob", new Department(102, "Finance")),
            new Employee(3, "Charlie", new Department(101, "HR")),
            new Employee(1, "Kal", new Department(101, "HR")),
            new Employee(2, "lbob", new Department(102, "Finance")),
            new Employee(3, "Puth", new Department(101, "HR"))
        );

        list.stream().collect(Collectors.groupingBy(ew->ew.dept.deptId)).values()
        .stream().flatMap(ee->ee.stream().sorted((e1,e2)->Long.compare(e2.id, e1.id)).limit(1)).forEach(System.out::println);
        

list.stream().collect(Collectors.groupingBy(ew->ew.dept.deptId,Collectors.maxBy((e1,e2)->Long.compare(e1.id, e2.id)))).values().stream().forEach(o->System.out.println(o.get()));;
    }
}
