public class TacoStand {
    // Constants
    public static final double ASADA_PRICE = 2.50;
    public static final double POLLO_PRICE = 1.75;
    public static final double LENGUA_PRICE = 3.00;
    public static final double ULTIMATE_PRICE = 18.00;

    // Inventory
    private static int asadaCount, polloCount, lenguaCount, ultimateCount;
    private static double totalFunds;

    public static void initialize() {
        asadaCount = 0;
        polloCount = 0;
        lenguaCount = 0;
        ultimateCount = 0;
        totalFunds = 0.0;
    }

    public static void addTotalFunds(double amount) {
        totalFunds += amount;
    }

    public static void orderSupplies(int amountPerTacoType) {
        asadaCount = amountPerTacoType;
        polloCount = amountPerTacoType;
        lenguaCount = amountPerTacoType;
        ultimateCount = amountPerTacoType;
    }

    public static void printMenu() {
        System.out.println("\nMenu options:");
        System.out.println("----------------------------------------");
        System.out.printf("1. Carne Asada (Steak)   [$ %.2f]\n", ASADA_PRICE);
        System.out.printf("2. Pollo Asado (Chicken) [$ %.2f]\n", POLLO_PRICE);
        System.out.printf("3. Lengua (Beef Tongue)  [$ %.2f]\n", LENGUA_PRICE);
        System.out.printf("4. Ultimate Taco         [$ %.2f]\n", ULTIMATE_PRICE);
        System.out.println("----------------------------------------");
    }

    public static boolean areTacosAvailable(int option, int quantity) {
        switch (option) {
            case 1: return quantity <= asadaCount;
            case 2: return quantity <= polloCount;
            case 3: return quantity <= lenguaCount;
            case 4: return quantity <= ultimateCount;
            default: return false;
        }
    }

    public static void updateTotalFunds(int option, int quantity) {
        switch (option) {
            case 1:
                totalFunds += ASADA_PRICE * quantity;
                asadaCount -= quantity;
                break;
            case 2:
                totalFunds += POLLO_PRICE * quantity;
                polloCount -= quantity;
                break;
            case 3:
                totalFunds += LENGUA_PRICE * quantity;
                lenguaCount -= quantity;
                break;
            case 4:
                totalFunds += ULTIMATE_PRICE * quantity;
                ultimateCount -= quantity;
                break;
        }
    }

    public static String getStatus() {
        return """
            ----------------------------------------
            MCC Taco Stand Status
            ----------------------------------------
            Funds Available:       $""" + String.format("%.2f", totalFunds) + """
            
            ----------------------------------------
            # of Asada Left:        """ + asadaCount + " tacos\n" +
                "# of Pollo Left:        " + polloCount + " tacos\n" +
                "# of Lengua Left:       " + lenguaCount + " tacos\n" +
                "# of Ultimate Left:     " + ultimateCount + " tacos\n" +
                "----------------------------------------";
    }
}
