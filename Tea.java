/**
 * Tea.java : represents one tea, containing all data 
 * from CaffeinatedBeverage and brew temperatrue in Celsius
 * 
 * 
 */

public class Tea extends CaffeinatedBeverage {

    // CONSTANT VARIABLES

    public static final int DEFAULT_BREW_TEMP = 90;

    // INSTANCE VARIABLES
    private int brewTemp;

    //CONSTRUCTORS
    /**
     * Full constructor with error handling (shuts down on invalid data)
     * 
     * @param name beverage name
     * @param ouunces number of fluid ounces in beverage container ( not total capacity of container)
     * @param price cost of beverage, either purchase or material cost
     * @param brewTempp temperature tea is brewed at (in Celsius)
     */
    public Tea(String name, int ounces, double price, int brewTemp) {
        //set old data
        super(name, ounces, price);
        // set new data
        if (!this.setBrewTemp(brewTemp)) {
            System.out.println("ERROR: Bad data given to full Tea constructor.");
            System.exit(0);
        }
    }

    /**
     * Default constructor using constant variable default values
     * 
     */
    public Tea() {
        super();
        this.setBrewTemp(DEFAULT_BREW_TEMP);
    }

    /**
     * Copy constructor creates a dep copy of all instance variables
     */

    public Tea(Tea original) {
        if (original != null) {
            this.setAll(original.getName(), original.getOunces(), original.getPrice(), original.brewTemp);
        } else {
            System.out.println("ERROR: null data given to copy Tea constructor");
            System.exit(0);
        }
     }
    // SETTERS/MUTATORS

    /**
     * Set brew temperature for object with error checking
     * @param brewTemp brewing temperature in celsius
     * 
     * @return bollean true if >0, false if not
     */
    public boolean setBrewTemp(int brewTemp) {
        if (brewTemp > 0) {
            this.brewTemp = brewTemp;
            return true;
        } else {
            return false;
        }

    }
    
    /**
     * Sets all valid instance variables
     * 
     * @param name beverage name
     * @param ounces number of fluid ounces in cup not total capacity of cup
     * @param price cost of beverage, either purchase price or material cost
     * @param brewTemp temperature tea is brewed at (in Celsius)
     * 
     * @return boolean true if all four parameters are valid
     */

     public boolean setAll(String name, int ounces, double price, int brewTemp) {
         return super.setAll(name, ounces, price) && this.setBrewTemp(brewTemp);
    }

    // GETTERS

    /**
     * Gets temperature of brew
     * @return returns temp of brew
     */

    public int getBrewTemp() {
        return this.brewTemp;
    }
     
    @Override
    public boolean equals(Object other) {
        if (other == null || other instanceof Tea) {
            return false;
        }
        Tea otherTea = (Tea) other;
        return super.equals(otherTea) && this.brewTemp == otherTea.brewTemp;
    }

    public String toString() {
        String caffeineString = super.toString();
        int colonLocation = caffeineString.indexOf(":");
        caffeineString = caffeineString.substring(colonLocation + 2); //cut off front label from CaffeinatedBeverage

        return String.format("Tea %s, brewed @ %d Celsius", caffeineString, this.brewTemp);
    }


    
}
