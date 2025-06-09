import java.util.HashSet;
import java.util.Set;

class Person {
    String name;
    String email; // email uniquely identifies a person

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // equals compares only email (correct as per our logic)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return email.equals(person.email);
    }

    // hashCode uses different field: name (wrong!)
    @Override
    public int hashCode() {
        return name.hashCode();
    }
}


public class EqualsHashcode {
     public static void main(String[] args) {
        Set<Person> people = new HashSet<>();

        Person p1 = new Person("Alice", "alice@example.com");
        Person p2 = new Person("Alicia", "alice@example.com"); // Same email, so logically same person

        people.add(p1);
        people.add(p2); // Should NOT be added (duplicate by equals())

        System.out.println("Set size: " + people.size()+" "+p1.equals(p2));
        for (Person p : people) {
            System.out.println(p.name + " - " + p.email);
        }
    }
}
