class ManufacturingController {

    static int productCount = 0;

    static String productName = "";

    public static String requestProduct(String product) {
        // write your code here
        productCount++;
        productName = product;
        return String.format("%d. Requested %s", productCount, productName);
    }

    public static int getNumberOfProducts() {
        // write your code here
        return productCount;
    }

    public static void main(String[] args) {
        System.out.println(Commands.STAY.ordinal());
    }
}
enum Commands {
    SIT, DOWN, STAY, COME
}