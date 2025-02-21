public class YerbaMate extends Tea {

    // CONSTANT VARIABLES
    public static final int DEFAULT_NUM_PASSES = 0;

    // INSTANCE VARIABLES
    private int numPasses;

    // CONSTRUCTORS

    /**
     * Full constructor with error handling (shuts down on invalid data)
     * 
     * @param name beverage name
     * @param ounces amount of fluid ounces in beverage containr (not amount of container size)
     * @param price price of beverage either price or material cost
     * @param brewTemp temperature of beverage (in Celsius)
     * @param numPasses
     */


    public YerbaMate(String name, int ounces, double price, int brewTemp, int numPasses) {
        super(name, ounces, price, brewTemp);
        if (!this.setNumPasses(numPasses)) {
            System.out.println("Error: bad data given to full YerbaMate Constructor");
            System.exit(0);
        }
    }
     
    /**
     * Default constructor using constant variables default values
     */
    public YerbaMate() {
        super();
        this.setNumPasses(DEFAULT_NUM_PASSES);

    }

    /**
     * Copy constructor creates a deep copy of all instance variables
     */

    public YerbaMate(YerbaMate original) {
        if (original != null) {
            this.setAll(original.getName(), original.getOunces(), original.getPrice(), original.getBrewTemp(),original.getNumPasses());
        } else {
            System.out.println("ERROR: null data given to copy YerbaMate constructor.");
            System.exit(0);
        }
     }


    

    // SETTERS/MUTATORS
    /**
     * Set number of passes with error checking
     * @param numPasses number of passes between people that have shared the YerbaMate
     *
     * @return boolean true if valid (>=0), false otherwise
     */
    
    private boolean setNumPasses(int numPasses) {
        if (numPasses >= 0) {
            this.numPasses = numPasses;
            return true;
        } else {
            return false;
        }
    }
    /**
     * Set all valid instance variables
     * @param name
     * @param ounces
     * @param price
     * @param brewTemp
     * @param numPasses
     * 
     * @return boolean true if all five parameters are valid
     */

    public boolean setAll(String name, int ounces, double price, int brewTemp, int numPasses) {
        return super.setAll(name, ounces, price, brewTemp) && this.setNumPasses(numPasses);

    }

    /**
     * Increments numPasses and prints a notification to the console that the mate 
     * was passed, along with current count
     */
    public void passMate() {
        this.numPasses++;
        System.out.println("Passed the mate, current # of passes: " + this.numPasses);
    }
     
    /**
     * When given a number of ounces of water that were added
     * will add tot he ounces from CaffeinatedBeverage
     */
    public void refill(int ounces) {
        if (ounces > 0) {
            this.setOunces(this.getOunces() + ounces);
        }
    }
    
    //GETTERS/ACCESSORS
    /**
     * Gets number of passes between people that have shared ta drink from the Mate
     * 
     * @return number of passes of mate
     */

    public int getNumPasses() {
        return this.numPasses;
    }
     
    @Override
    public boolean equals(Object other) {
        if (other == null || this.getClass() != other.getClass()) {
            return false;
        }
        YerbaMate otherMate = (YerbaMate) other;
        return super.equals(otherMate) && this.numPasses == otherMate.numPasses;
    }




     @Override
     public String toString() {
         String teaString = super.toString();
         int colonLocation = teaString.indexOf(":");
         teaString = teaString.substring(colonLocation + 2); //cut off front label from Tea

         return String.format("YerbaMate: %s, %d passes so far", teaString, this.numPasses);
     }



}
