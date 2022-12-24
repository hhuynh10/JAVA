package cafe_util;

import java.util.ArrayList;

public class CafeUtil {
    
    public int getStreakGoal(int numWeeks){
        int total = 0;
        for (int i = 0; i <= numWeeks; i++){
            total += i;
        }
        return total;
    }

    public double getOrderTotal(double[] prices){
        double total = 0;
        for (int i = 0; i < prices.length; i++){
            total += prices[i];
        }
        return total;
    }

    
    public void displayMenu(ArrayList<String> menuItems){
        for (int i = 0; i < menuItems.size(); i++){
            System.out.println(i + " " + menuItems.get(i));
        }
    }

    public void addCustomer(ArrayList<String> customers){
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.println("Hello, " + userName);

        System.out.printf("There are %s people in front of you", customers.size());
        customers.add(userName);
    }

    public void printPriceChart(String product, double price, int maxQuantity){
        for (int i = 0; i <= maxQuantity; i++){
            System.out.print(i + price);
        }
    }
}
