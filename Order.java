/**
 * Represents a cafe order.
 *
 * @author Adrian Dais and Romeo Pamplona
 * @version 7.0
 */
public class Order {

    private Customer customer;
    private Menu_item item1;
    private Menu_item item2;
    private Menu_item item3;
    private int itemCount;
    private String orderId;

    /**
     * Parameterized constructor.
     *
     * @param orderId order identification
     * @param customer customer who placed the order
     */
    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        itemCount = 0;
    }

    /**
     * Adds an item to the order.
     *
     * @param item menu item
     * @return true if item was added
     */
    public boolean addItem(Menu_item item) {

        // Checks if the item is valid.
        if (item == null) {
            System.out.println("Invalid item.");
            return false;

        } else if (itemCount == 0) {
            item1 = item;
            itemCount++;
            return true;

        } else if (itemCount == 1) {
            item2 = item;
            itemCount++;
            return true;

        } else if (itemCount == 2) {
            item3 = item;
            itemCount++;
            return true;

        } else {
            System.out.println("Order is full. Cannot add "
                    + item.getName() + ".");
            return false;
        }
    }

    /**
     * Computes subtotal of all items.
     *
     * @return subtotal
     */
    public double computeSubtotal() {

        double subtotal = 0;

        if (item1 != null) {
            subtotal += item1.computePrice();
        }

        if (item2 != null) {
            subtotal += item2.computePrice();
        }

        if (item3 != null) {
            subtotal += item3.computePrice();
        }

        return subtotal;
    }

    /**
     * Computes total with customer discount.
     *
     * @return total after discount
     */
    public double computeTotal() {

        double subtotal = computeSubtotal();
        double total;

        // Students and regular customers receive 10% discount.
        if (customer.isStudent() || customer.isRegular()) {
            total = subtotal - (subtotal * 0.10);
        } else {
            total = subtotal;
        }

        return total;
    }

    /**
     * Computes total after discount and voucher.
     *
     * @param voucher voucher amount
     * @return final total
     */
    public double computeTotal(double voucher) {

        double total = computeTotal() - voucher;

        // Prevents the total from becoming negative.
        if (total < 0) {
            return 0;
        } else {
            return total;
        }
    }

    /**
     * Prints receipt without voucher.
     */
    public void printReceipt() {
        printReceipt(0);
    }

    /**
     * Prints receipt with voucher.
     *
     * @param voucher voucher amount
     */
    public void printReceipt(double voucher) {

        double subtotal = computeSubtotal();
        double discount = 0;

        // Computes discount for students and regular customers.
        if (customer.isStudent() || customer.isRegular()) {
            discount = subtotal * 0.10;
        }

        double total = computeTotal(voucher);

        
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customer.getName());
        System.out.println("Customer Type: "
                + customer.getCustomerType());
        
        // Displays the first item.
        if (item1 != null) {
            System.out.printf("%s - $%.2f%n",
                    item1.getDescription(),
                    item1.computePrice());
        }

        // Displays the second item.
        if (item2 != null) {
            System.out.printf("%s - $%.2f%n",
                    item2.getDescription(),
                    item2.computePrice());
        }

        // Displays the third item.
        if (item3 != null) {
            System.out.printf("%s - S%.2f%n",
                    item3.getDescription(),
                    item3.computePrice());
        }

        System.out.println("===================================");

        System.out.printf("Subtotal: $%.2f%n", subtotal);
        System.out.printf("Discount: -$.2f%n", discount);

        // Displays voucher only when it is greater than zero.
        if (voucher > 0) {
            System.out.printf("Voucher: -$.2f%n", voucher);
        }

        System.out.println("===================================");

        System.out.printf("TOTAL: $%.2f%n", total);

        // Updates customer loyalty points.
        customer.addPoints(total);

        System.out.println("Loyalty Points: "
                + customer.getLoyaltyPoints());

       
    }
}
