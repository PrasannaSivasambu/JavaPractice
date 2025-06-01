public class Check {

    public void method(int i, double d){
        System.out.println("hi");
    }
    public void method(double i, int d){
        System.out.println("hello");
    }

    public static void main(String[] args) {
        Check c= new Check();
        c.method(1,2);
    }
}
