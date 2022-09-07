public class CafeJava {
    public static void main(String[] args) {
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        double mochaPrice = 3.5;
        double coffeePrice = 2.3;
        double lattePrice = 4.0;
        double cappuPrice = 4.5;
    
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";
    
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = false;
        boolean isReadyOrder3 = true;
        boolean isReadyOrder4 = false;
    
        System.out.println(generalGreeting + customer1);
        System.out.println(customer1 + pendingMessage + displayTotalMessage + cappuPrice);

        if (isReadyOrder4){
            System.out.println(customer4 + readyMessage);
        }
        else{
            System.out.println(customer4 + pendingMessage);
        }

        System.out.println(customer2 + "," + displayTotalMessage + (2 * lattePrice));
        if (isReadyOrder2){
            System.out.println(customer2 + readyMessage);
        }
        else{
            System.out.println(customer2 + pendingMessage);
        }

        System.out.println(customer3 + "," + displayTotalMessage + (coffeePrice - lattePrice));
    }
}
