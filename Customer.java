/**
 * Represents a cafe customer.
 *
 * @author Romeo Pamplona
 * @version 5.0
 */
public class Customer {

    private String name;
    private boolean student;
    private boolean regular;
    private int loyaltyPoints;

    /**
     * Default constructor.
     */
    public Customer() {
        name = "Unknown Customer";
        student = false;
        regular = false;
        loyaltyPoints = 0;
    }

    /**
     * Constructor with customer name.
     *
     * @param name customer name
     */
    public Customer(String name) {
        this.name = name;
        student = false;
        regular = false;
        loyaltyPoints = 0;
    }

    /**
     * Constructor with name and customer type.
     *
     * @param name customer name
     * @param customerType customer type
     */
    public Customer(String name, String customerType) {
        this.name = name;
        student = false;
        regular = false;
        loyaltyPoints = 0;

        setCustomerType(customerType);
    }

    /**
     * Gets customer name.
     *
     * @return customer name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets customer name.
     *
     * @param name new customer name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Checks if customer is a student.
     *
     * @return student status
     */
    public boolean isStudent() {
        return student;
    }

    /**
     * Sets student status.
     *
     * @param student student status
     */
    public void setStudent(boolean student) {
        this.student = student;
        regular = false;
    }

    /**
     * Checks if customer is regular.
     *
     * @return regular status
     */
    public boolean isRegular() {
        return regular;
    }

    /**
     * Gets customer type.
     *
     * @return customer type
     */
    public String getCustomerType() {

        if (student) {
            return "Student";
        } else if (regular) {
            return "Regular";
        } else {
            return "New Buyer";
        }
    }

    /**
     * Sets customer type.
     *
     * @param customerType new customer type
     */
    public void setCustomerType(String customerType) {

        if (customerType.equalsIgnoreCase("Student")) {
            student = true;
            regular = false;

        } else if (customerType.equalsIgnoreCase("Regular")) {
            student = false;
            regular = true;

        } else {
            student = false;
            regular = false;
        }
    }

    /**
     * Gets loyalty points.
     *
     * @return loyalty points
     */
    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    /**
     * Sets loyalty points.
     *
     * @param loyaltyPoints new loyalty points
     */
    public void setLoyaltyPoints(int loyaltyPoints) {

        // Prevents negative loyalty points.
        if (loyaltyPoints < 0) {
            System.out.println("Error: loyalty points cannot be negative.");
        } else {
            this.loyaltyPoints = loyaltyPoints;
        }
    }

    /**
     * Adds a specific number of points.
     *
     * @param points points to add
     */
    public void addPoints(int points) {

        if (points >= 0) {
            loyaltyPoints += points;
        }
    }

    /**
     * Adds one point for every 50 pesos spent.
     *
     * @param amount amount spent
     */
    public void addPoints(double amount) {

        if (amount >= 0) {
            loyaltyPoints += (int) (amount / 50);
        }
    }
}
