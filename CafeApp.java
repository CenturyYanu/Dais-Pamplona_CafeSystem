/**
 * Main class for the Campus Cafe Ordering System.
 *
 * @author Adrian Dais and Romeo Pamplona
 * @version 7.0
 */
public class CafeApp {

    /**
     * Main method of the program.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {

        // Creating customers using the three constructors.
        Customer customer1 = new Customer(
                "Adrian R. Dais", "Student");

        Customer customer2 = new Customer(
                "Romeo E. Pamplona");

        Customer customer3 = new Customer(
                "Daisy R. Elmaco", "Regular");


        // Creating beverage objects.
        Beverage latte = new Beverage(
                "Iced Latte", 95, "B-01", "L");

        // Using the default Beverage constructor.
        Beverage hotChocolate = new Beverage();

        hotChocolate.setName("Hot Chocolate");
        hotChocolate.setBasePrice(-5);
        hotChocolate.setBasePrice(80);
        hotChocolate.setItemCode("B-02");
        hotChocolate.setSize("M");

        Beverage americano = new Beverage(
                "Americano", 105, "B-03", "L");

        Beverage lemonade = new Beverage(
                "Fresh Lemonade", 90, "B-04", "M");


        // Creating pastry objects.
        Pastry ensaymada = new Pastry(
                "Ensaymada", 45, "P-01", true);

        Pastry chocolateCake = new Pastry(
                "Chocolate Cake", 101, "P-02", true);

        Pastry cookie = new Pastry(
                "Cookie", 40, "P-03", false);


        // Creating meal objects.
        Meal chickenAdobo = new Meal();

        chickenAdobo.setName("Chicken Adobo");
        chickenAdobo.setBasePrice(110);
        chickenAdobo.setItemCode("M-01");
        chickenAdobo.setUpsized(true);
        chickenAdobo.setExtraSides(-1);
        chickenAdobo.setExtraSides(1);

        Meal beefTapa = new Meal(
                "Beef Tapa", 130, "M-02", false, 0);


        // Cafe heading.
        System.out.println("===================================");
        System.out.println("====== BAI Cafe & BAikery Shop =====");
        System.out.println("===================================");


        // First order: Student.
        Order order1 = new Order("1001", customer1);

        order1.addItem(latte);
        order1.addItem(ensaymada);
        order1.addItem(chickenAdobo);

        // Trying to add a fourth item.
        order1.addItem(cookie);


        // Second order: New Buyer.
        Order order2 = new Order("1002", customer2);

        order2.addItem(hotChocolate);
        order2.addItem(beefTapa);


        // Third order: Regular Customer.
        Order order3 = new Order("1003", customer3);

        order3.addItem(americano);
        order3.addItem(chocolateCake);
        order3.addItem(lemonade);


        // Printing all receipts.
        order1.printReceipt();
        order2.printReceipt(20);
        order3.printReceipt();


        // Closing message.
        System.out.println("===================================");
        System.out.println("=== SALAMAT BAI!!! Come Back Again ===");
        System.out.println("===================================");
    }
}
