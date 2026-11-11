/**
 * Represents a meal sold at the cafe.
 *
 * @author Adrian Dais
 * @version 4.0
 */
public class Meal extends Menu_item {

    private boolean upsized;
    private int extraSides;

    /**
     * Default constructor.
     */
    public Meal() {
        super();
        upsized = false;
        extraSides = 0;
    }

    /**
     * Parameterized constructor.
     *
     * @param name meal name
     * @param basePrice meal price
     * @param itemCode item code
     * @param upsized upsizing option
     * @param extraSides number of extra sides
     */
    public Meal(String name, double basePrice,
                String itemCode, boolean upsized,
                int extraSides) {

        super(name, basePrice, itemCode);
        this.upsized = upsized;
        setExtraSides(extraSides);
    }

    /**
     * Computes meal price.
     *
     * @return final meal price
     */
    @Override
    public double computePrice() {

        double price = basePrice;

        // Adds 20 pesos if the meal is upsized.
        if (upsized) {
            price += 20;
        }

        price += extraSides * 12;

        return price;
    }

    /**
     * Returns meal description.
     *
     * @return meal description
     */
    @Override
    public String getDescription() {

        String description = name;

        // Shows the upsized option.
        if (upsized) {
            description += " (Upsized)";
        }

        // Shows the number of extra sides.
        if (extraSides > 0) {
            description += " +" + extraSides + " side(s)";
        }

        return description + " [" + getItemCode() + "]";
    }

    /**
     * Checks if meal is upsized.
     *
     * @return true if upsized
     */
    public boolean isUpsized() {
        return upsized;
    }

    /**
     * Sets upsizing option.
     *
     * @param upsized upsizing option
     */
    public void setUpsized(boolean upsized) {
        this.upsized = upsized;
    }

    /**
     * Gets extra sides.
     *
     * @return number of extra sides
     */
    public int getExtraSides() {
        return extraSides;
    }

    /**
     * Sets extra sides.
     *
     * @param extraSides number of extra sides
     */
    public void setExtraSides(int extraSides) {

        // Prevents a negative number of extra sides.
        if (extraSides < 0) {
            System.out.println("Error: extra sides cannot be negative.");
        } else {
            this.extraSides = extraSides;
        }
    }
}
