/**
 * Represents a beverage sold at the cafe.
 *
 * @author Romeo Pamplona
 * @version 2.0
 */
public class Beverage extends Menu_item {

    private String size;

    /**
     * Default constructor.
     */
    public Beverage() {
        super();
        size = "S";
    }

    /**
     * Parameterized constructor.
     *
     * @param name beverage name
     * @param basePrice beverage price
     * @param itemCode item code
     * @param size beverage size
     */
    public Beverage(String name, double basePrice,
                    String itemCode, String size) {

        super(name, basePrice, itemCode);
        setSize(size);
    }

    /**
     * Computes beverage price based on size.
     *
     * @return final beverage price
     */
    @Override
    public double computePrice() {

        double price = basePrice;

        // Large adds 25 pesos, medium adds 15 pesos.
        if (size.equalsIgnoreCase("L")) {
            price += 25;
        } else if (size.equalsIgnoreCase("M")) {
            price += 15;
        } else {
            price = basePrice;
        }

        return price;
    }

    /**
     * Returns beverage description.
     *
     * @return beverage description
     */
    @Override
    public String getDescription() {
        return name + " (" + size + ") [" + getItemCode() + "]";
    }

    /**
     * Gets beverage size.
     *
     * @return beverage size
     */
    public String getSize() {
        return size;
    }

    /**
     * Sets beverage size.
     *
     * @param size new beverage size
     */
    public void setSize(String size) {

        // Accepts only small, medium, or large.
        if (size.equalsIgnoreCase("S")
                || size.equalsIgnoreCase("M")
                || size.equalsIgnoreCase("L")) {

            this.size = size.toUpperCase();

        } else {
            System.out.println("Invalid size. Use S, M, or L.");
        }
    }
}
