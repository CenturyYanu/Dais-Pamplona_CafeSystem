/**
 * Abstract parent class for cafe menu items.
 *
 * @author Romeo Pamplona
 * @version 1.0
 */
public abstract class Menu_item {

    protected String name;
    protected double basePrice;
    private String itemCode;

    /**
     * Default constructor.
     */
    public Menu_item() {
        name = "Unknown Item";
        basePrice = 0;
        itemCode = "N/A";
    }

    /**
     * Parameterized constructor.
     *
     * @param name item name
     * @param basePrice item price
     * @param itemCode item code
     */
    public Menu_item(String name, double basePrice, String itemCode) {
        this.name = name;
        setBasePrice(basePrice);
        this.itemCode = itemCode;
    }

    /**
     * Computes the price of the item.
     *
     * @return item price
     */
    public abstract double computePrice();

    /**
     * Returns item description.
     *
     * @return item description
     */
    public String getDescription() {
        return name + " [" + itemCode + "]";
    }

    /**
     * Gets item name.
     *
     * @return item name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets item name.
     *
     * @param name new item name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets base price.
     *
     * @return base price
     */
    public double getBasePrice() {
        return basePrice;
    }

    /**
     * Sets base price.
     *
     * @param basePrice new item price
     */
    public void setBasePrice(double basePrice) {

        // Prevents a negative item price.
        if (basePrice < 0) {
            System.out.println("Error: base price cannot be negative.");
        } else {
            this.basePrice = basePrice;
        }
    }

    /**
     * Gets item code.
     *
     * @return item code
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * Sets item code.
     *
     * @param itemCode new item code
     */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }
}
