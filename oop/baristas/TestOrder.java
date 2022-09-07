import java.util.ArrayList;

public class TestOrder {
    public static void main(String [] args) {

        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order("Hung");
        Order order4 = new Order("Mike");
        Order order5 = new Order("Julien");

        Item item1 = new Item("Black Coffee", 5.0);
        Item item2 = new Item("Latte", 4.5);
        Item item3 = new Item("Refresher", 3.5);
        Item item4 = new Item("Cappuchino", 5.5);
        Item item5 = new Item("Tea", 3.0);

        order3.addItem(item5);
        order3.addItem(item3);
        order3.display();

        order4.addItem(item1);
        order4.addItem(item4);
        order4.display();

        order5.addItem(item3);
        order5.addItem(item2);
        order5.display();

        order4.setReady(true);
        System.out.println(order4.getStatusMessage());
        System.out.println(order4.getOrderTotal());

        order5.setReady(false);
        System.out.println(order5.getStatusMessage());
        System.out.println(order5.getOrderTotal());
    }
}