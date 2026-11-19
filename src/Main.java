import java.util.ArrayList;
import java.util.Scanner;
//yeah
public class Main {
    public static void main(String[] args) {

        ArrayList <Product> products = new ArrayList<>();

        Product milk = new Product("Milk", 1.50, 20);
        Product bread = new Product("Bread", 2.00, 15);
        Product eggs = new Product("Eggs", 3.50, 10);
        Product rice = new Product("Rice", 2.75, 25);
        products.add(milk);
        products.add(bread);
        products.add(eggs);
        products.add(rice);

        Scanner sc = new Scanner(System.in);
        boolean menuRunner = true;
        while (menuRunner) {
            System.out.println("1. View all products");
            System.out.println("2. Add product");
            System.out.println("3. Update price");
            System.out.println("4. Update stock");
            System.out.println("5. Check stock");
            System.out.println("6. Search product");
            System.out.println("7. See total stock value");
            System.out.println("8. Remove product completely");

            System.out.println("0. Exit application");

            System.out.print("Choose an option: ");
            String choice = sc.nextLine();

            switch (choice){
                case "1":
                    if (products.isEmpty()){
                        System.out.println("No products found!");
                    } else {
                        for (Product product: products){
                            System.out.println(product);
                        }
                    }
                    break;
                case "2":
                    addProduct(products, sc);
                    break;

                case "3":
                    updatePrice(products, sc);
                    break;

                case "4":
                    updateStock(products, sc);
                    break;

                case "5":
                    checkStock(products, sc);
                    break;

                case "6":
                    searchProduct(products, sc);
                    break;

                case "7":
                    System.out.println(calculateTotalValue(products));
                    break;

                    case "8":
                removeProduct(products, sc);
                break;

                case "0":
                    System.out.println("See you next time!");
                    return;
            }
        }
    }

    //Methods below
    public static void addProduct(ArrayList<Product> products, Scanner sc) {
        System.out.print("Enter product name: ");
        String name = sc.nextLine();

        System.out.print("Enter product price: ");
        double price = sc.nextDouble();

        System.out.print("Enter product stock: ");
        int stock = sc.nextInt();

        sc.nextLine();

        Product addProduct = new Product(name, price, stock);
        products.add(addProduct);
        System.out.println(name + " successfully added!");
    }

    public static void updatePrice(ArrayList<Product> products, Scanner sc) {

        System.out.print("What product would you like to update the price? ");
        String name = sc.nextLine();

        System.out.print("Type new price: ");
        double price = sc.nextDouble();

        sc.nextLine();

        boolean nameFound = false;
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                nameFound = true;
                product.setPrice(price);
            }
        }

        if (nameFound) {
            System.out.println(name + " price updated!");
        } else {
            System.out.println("Product not found!");
        }
    }

    public static void updateStock(ArrayList <Product> products, Scanner sc){

        System.out.print("What product would you like to update the stock? ");
        String name = sc.nextLine();

        System.out.println("Type new stock ");
        int stock = sc.nextInt();

        sc.nextLine();

        boolean nameFound = false;
        for (Product product: products){
        if (product.getName().equalsIgnoreCase(name)){
            nameFound = true;
            product.addStock(stock);
              }
            }

        if (nameFound) {
            System.out.println(name + " Stock updated");
        } else {
            System.out.println("Product not found!");
            }

        }

     public static void removeOutOfStock (ArrayList <Product> products){
        ArrayList <Product> productsToRemove = new ArrayList<>();
        for (Product product: products){
            if (product.getStock() == 0){
            productsToRemove.add(product);
        }
     }
        for (Product product: productsToRemove){
            products.remove(product);
        }
    }

    public static double calculateTotalValue(ArrayList <Product> products) {
        double totalValue = 0;
        for (Product product: products){
            totalValue += product.getPrice() * product.getStock();
        }
        return totalValue;
    }

    public static void checkStock(ArrayList <Product> products, Scanner sc){

        System.out.print("What product would you like to check stock for? ");
        String productName = sc.nextLine();

        boolean foundName = false;
        for(Product product: products){
            if (product.getName().equalsIgnoreCase(productName)){
                foundName = true;
                System.out.println(product.getName() + " has " + product.getStock() + " in stock!");
            }
        }

        if (!foundName){
            System.out.println("Product not found!");
        }
    }

    public static void searchProduct(ArrayList <Product> products, Scanner sc){
        System.out.print("Type your product: ");
        String name = sc.nextLine();
        for (Product product : products){
            if (name.equalsIgnoreCase(product.getName())){
                System.out.println(product);
            }
        }
    }

    public static void removeProduct (ArrayList <Product> products, Scanner searchForName){
        boolean nameFound = false;

        System.out.print("What product would you like to remove? ");
        String name = searchForName.nextLine();

        Product productToRemove = null;

        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                nameFound = true;
                productToRemove = product;
            }
        }

        if (nameFound) {
            products.remove(productToRemove);
            System.out.println(name + " removed");
            System.out.println("Current list:");
            System.out.println(products);

        } else {
            System.out.println("product not found!");
        }

    }

}