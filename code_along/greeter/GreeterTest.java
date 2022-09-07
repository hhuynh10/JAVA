public class GreeterTest{
    public static void main(String[] args){
        Greeter g = new Greeter();

        String greeting = g.greet();
        String greetwithname = g.greet("Hung Huynh");

        if (greeting.equals("Hello World") || greetwithname.equals("Hello Hung Huynh")){
            System.out.println("Test successful!");
        } else {
            System.out.println("Test fail");
        }
    }
}