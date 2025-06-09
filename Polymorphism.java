class Animal{
    public void sound(){
        System.out.println("ee");
    }
}

class Dog extends Animal{
    public void sound(){
        System.out.println("bark");
    }
}

class Cat extends Animal{
    public void sound(){
        System.out.println("meow");
    }
}


public class Polymorphism {
    public static void main(String[] args) {
        Animal a=new Dog();
        Animal c=(Animal)a;
        Animal d=new Animal();
        // Animal b=(Dog)d; 
        a.sound();
        c.sound();
        d.sound();
        // b.sound();

        Dog dd= new Dog();
        Cat ca= (Cat) dd;
    }
}
