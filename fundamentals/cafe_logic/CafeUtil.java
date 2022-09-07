import java.util.ArrayList;
import java.util.Arrays;

public class CafeUtil {
    
    public int getStreakGoal(int numWeeks) {
        int sum = 0;
        for (int i = 1; i <= numWeeks; i ++){
            sum = sum + i;
        }
        return sum;
    }

    public double getOrderTotal(double[] prices){
        double sum = 0;
        for (int i = 0; i < prices.length; i++){
            sum = sum + prices[i];
        }
        return sum;
    }

    public void displayMenu(ArrayList<String> menuItems){
        // String name = myArray.get(0)
        for (int i = 0; i < menuItems.size(); i++){
            System.out.println(i + " " + menuItems.get(i));
        }
    }

    public void addCustomer(ArrayList<String> customers){
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.println("Hello," + " " + userName);
        System.out.printf("There are %s people in front of you", customers.size());
        customers.add(userName);
    }
}