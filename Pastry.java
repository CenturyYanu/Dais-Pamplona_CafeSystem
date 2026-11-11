/**
 * Represents a pastry sold at the cafe.
 *
 * @author Romeo Pamplona and Adrian Dais
 * @version 3.0
 */
public class Pastry extends Menu_item {

    private boolean warmed;

    /**
     * Default constructor.
     */
    public Pastry() {
        super();
        warmed = false;
    }

    /**
     * Parameterized constructor.
     *
     * @param name pastry name
     * @param basePrice pastry price
     * @param itemCode item code
     * @param warmed warming option
     */
    public Pastry(String name, double basePrice,
                  String itemCode, boolean warmed) {

        super(name, basePrice, itemCode);
        this.warmed = warmed;
    }

    /**
     * Computes pastry price.
     *
     * @return final pastry price
     */
    @Override
    public double computePrice() {

        double price = basePrice;

        // Adds 10 pesos when the pastry is warmed.
        if (warmed) {
            price += 10;
        }

        return price;
    }

    /**
     * Returns pastry description.
     *
     * @return pastry description
     */
    @Override
    public String getDescription() {

        if (warmed) {
            return name + " (Warmed) [" + getItemCode() + "]";
        } else {
            return name + " [" + getItemCode() + "]";
        }
    }

    /**
     * Checks if pastry is warmed.
     *
     * @return true if warmed
     */
    public boolean isWarmed() {
        return warmed;
    }

    /**
     * Sets warming option.
     *
     * @param warmed warming option
     */
    public void setWarmed(boolean warmed) {
        this.warmed = warmed;
    }
}
