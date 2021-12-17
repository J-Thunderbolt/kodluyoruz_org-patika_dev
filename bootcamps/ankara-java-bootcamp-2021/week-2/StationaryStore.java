import java.util.*;
import java.util.stream.Collectors;

/**
 * StationaryStore
 */
public class StationaryStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> productMap = new HashMap<String, Integer>() {
            {
                put("Kalem", 1);
                put("Defter", 9);
                put("Silgi", 9);
                put("Kitap Ayracı", 0);
            }
        };
        int decision;
        List<String> messageList = new ArrayList<String>() {
            {
                add("1. Add Product(s)");
                add("2. Show Products List");
                add("3. Show Total Number of Products");
                add("4. Show Total Number of Product Types");
                add("5. Exit");
                add("Select an operation(1-5): ");
            }
        };

        String message = messageList.stream().map(Object::toString).collect(Collectors.joining("\n"));

        System.out.println("**** STATIONARY STOCK SYSTEM ****");

        try (scanner) {
            decision = getIntInput(message, "[1-5]", scanner);

            while (decision != 5) {
                switch (decision) {
                    case 1:
                        addProduct(scanner, productMap);
                        break;
                    case 2:
                        System.out.println("\nCurrent stocks:\n" + productMapToString(productMap));
                        break;
                    case 3:
                        System.out.println("Total products count:" + getTotalProductsCount(productMap));
                        break;
                    case 4:
                        System.out.println("Total product types count: " + getProductTypesCount(productMap));
                        break;
                }
                decision = getIntInput(message, "[1-5]", scanner);
            }
        }

    }

    private static void addProduct(Scanner scanner, HashMap<String, Integer> productMap) {
        int decision = 1;
        String productName;
        int productCount;

        while (decision == 1) {
            System.out.print("Name of the product: ");
            productName = scanner.nextLine();

            productCount = getIntInput("Product count (0-199): ", "([0-9]|[1-9][0-9]|[1][0-9][0-9])", scanner);

            addProductToMap(productName, productCount, productMap);

            decision = getIntInput("\nPress 1 to add one more product, 2 to exit: ", "[1-2]", scanner);
        }
    }

    public static void addProductToMap(String productName, int productBoughtCount, Map<String, Integer> productMap) {
        Integer productCount;
        if (productName == null) {
            return;
        }
        productCount = productMap.get(productName);
        if (productCount == null) {
            productCount = productBoughtCount;
        } else {
            productCount += productBoughtCount;
        }
        productMap.put(productName, productCount);
    }

    public static String productMapToString(Map<String, Integer> productMap) {
        String products2String;
        if (productMap.size() == 0) {
            return null;
        }
        products2String = productMap.keySet().stream().map(key -> key + ": " + productMap.get(key))
                .collect(Collectors.joining(", ", "{ ", " }\n"));
        return products2String;
    }

    public int getProductCount(String productName, Map<String, Integer> productMap) {
        if (productName == null || productMap.get(productName) == null) {
            return -1;
        }
        return productMap.get(productName);
    }

    public static int getTotalProductsCount(Map<String, Integer> productMap) {
        return productMap.values().stream().mapToInt(count -> count).sum();

    }

    public static int getProductTypesCount(HashMap<String, Integer> productMap) {
        return productMap.size();
    }

    public void clear(Map<String, Integer> productMap) {
        productMap.clear();
    }

    public static int getIntInput(String message, String interval, Scanner scanner) {
        int userInput;
        System.out.print(message);

        while (!scanner.hasNextInt() || !scanner.hasNext(interval)) {
            System.out.println("Entered value must be a number or valid");
            System.out.print(message);
            scanner.next();
        }
        userInput = scanner.nextInt();
        scanner.nextLine();
        return userInput;
    }
}