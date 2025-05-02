import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Employe {
    String name;
    int age;
    double salary;
    Department department;
    boolean isPermanent;

    Employe(String name,
    int age,
    double salary,
    Department department,
    boolean isPermanent){
        this.age=age;
        this.department=department;
        this.isPermanent=isPermanent;
        this.name=name;
        this.salary=salary;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.name+" "+this.age+" "+this.department.name+" "+this.salary+" "+this.isPermanent;
    }
    // constructor, getters, setters
}

class Department {
    String name;
    Company company;
    String location;

    Department(String name, Company company, String location){
    this.company=company;
    this.location=location;
    this.name=name;
}
    // constructor, getters, setters
}

class Company {
    String name;
    int rating; // 1 to 5
    Company(String name, int rating){
        this.name=name;
        this.rating=rating;
    }
    // constructor, getters, setters
}



public class StreamSolution {
    public static void main(String[] args) {
        Company google = new Company("Google", 5);
        Company amazon = new Company("Amazon", 4);
        Company xyzCorp = new Company("XYZ Corp", 3);

        Department devBangaloreGoogle = new Department("Development", google, "Bangalore");
        Department qaBangaloreAmazon = new Department("QA", amazon, "Bangalore");
        Department devHyderabadAmazon = new Department("Development", amazon, "Hyderabad");
        Department hrBangaloreXYZ = new Department("HR", xyzCorp, "Bangalore");

        List<Employe> employees = List.of(
        new Employe("Alice", 30, 120000, devBangaloreGoogle, true),
        new Employe("Bob", 28, 115000, devBangaloreGoogle, true),
        new Employe("Charlie", 35, 125000, devBangaloreGoogle, false), // not permanent
        new Employe("David", 40, 110000, qaBangaloreAmazon, true),
        new Employe("Eva", 29, 112000, qaBangaloreAmazon, true),
        new Employe("Frank", 32, 108000, qaBangaloreAmazon, false), // not permanent
        new Employe("Grace", 27, 100000, devHyderabadAmazon, true), // not in Bangalore
        new Employe("Heidi", 45, 130000, hrBangaloreXYZ, true) // company rating < 4
);

employees.stream()
.filter(em->em.isPermanent && em.department.location=="Bangalore" 
        && (em.department.company.rating==4 || em.department.company.rating==5))
.collect(Collectors.groupingBy(e->e.department.name,Collectors.maxBy(Comparator.comparing(el->el.salary))))
.values().stream().forEach(m->System.out.println( m.get())) ;


    }
}
