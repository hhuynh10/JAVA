package ordersAndItems;

public class TestOrders {
    public static void main(String[] args) {
    
        Item item1 = new Item();
        item1.name = "mocha";
        item1.total = 3.5;
        
        Item item2 = new Item();
        item2.name = "latte";
        item2.total = 2.5;

        Item item3 = new Item();
        item3.name = "dripped coffee";
        item3.total = 4.0;

        Item item4 = new Item();
        item4.name = "cappuchino";
        item4.total = 5.5;
    
        Order order1 = new Order();
        order1.name = "Cindhuri";
        
        Order order2 = new Order();
        order2.name = "Jimmy";
        order2.items.add(item2);
        order2.total += item2.total;

        Order order3 = new Order();
        order3.name = "Noah";

        Order order4 = new Order();
        order4.name = "Sam";
    
        // Application Simulations
        // Use this example code to test various orders' updates
        System.out.printf("Name: %s\n", order1.name);
        System.out.printf("Total: %s\n", order1.total);
        System.out.printf("Ready: %s\n", order1.ready);

        System.out.printf("Total: %s\n", order2.total);
    }

}
