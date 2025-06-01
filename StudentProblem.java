import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class  Student {
    int roll;
    int age;
    String name;
    char grade;

    Student(int roll,int age, String name, char grade){
        this.age=age;
        this.grade=grade;
        this.name=name;
        this.roll=roll;
    }
    @Override
    public String toString() {
        // TODO Auto-generate'd method stub
        return age+" "+grade+" "+name+" "+roll;
    }
}

public class StudentProblem {
    public static void main(String[] args) {
        Student s1=new Student(1, 11, "raj", 'A');
        Student s2=new Student(2, 12, "ram", 'B');
        Student s3=new Student(3, 13, "raju", 'C');
        Student s4=new Student(4, 14, "rajesh", 'C');
        Student s5=new Student(5, 15, "rahu", 'E');
        Student s6=new Student(6, 16, "rahulo", 'A');
        Student s7=new Student(7, 16, "rahul", 'A');

        List<Student> s= new ArrayList<>(Arrays.asList(s1,s2,s3,s4,s5,s6,s7));
        Double df= s.stream().map(se->se.age).mapToInt(Integer::valueOf).average().getAsDouble();
        System.out.println(df);
        String e="Java is a Programming Language";
        System.out.println( e.chars().mapToObj(Character::toString).collect(Collectors.toMap(key->key, value->1,(v1,v2)->v1+v2,LinkedHashMap::new)));
        System.out.println(e.chars().mapToObj(Character::toString).sorted((w1,w2)->w2.compareTo(w1)).collect(Collectors.toList()));
        
        // Class<?> c=Class.forName("StudentProblem");
        // System.out.println(c);

        int ge=10;

        System.out.println( s.stream().collect(Collectors.groupingBy(el->el.grade,Collectors.collectingAndThen(Collectors.toList(), l->l.stream()
        .sorted(
            (a,b)->Integer.compare(b.age, a.age)==0 
            ?Integer.compare(a.name.length(), b.name.length())
            :Integer.compare(b.age, a.age)
            )
        .toList()))) );
       s1.name.length();
    }
}
