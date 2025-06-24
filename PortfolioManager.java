import java.util.ArrayList;
import java.util.Scanner;

// Class representing a Stock
class Stock {
    private String name;
    private int quantity;
    private double price;

    public Stock(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public double getTotalValue() {
        return quantity * price;
    }

    public String getName() {
        return name;
    }

    public void displayStock() {
        System.out.println("Stock: " + name + ", Quantity: " + quantity + ", Price: " + price + ", Total Value: " + getTotalValue());
    }
}

// Portfolio class to manage multiple stocks
class Portfolio {
    private ArrayList<Stock> stocks;

    public Portfolio() {
        stocks = new ArrayList<>();
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
        System.out.println(stock.getName() + " added to the portfolio.");
    }

    public void removeStock(String name) {
        for (int i = 0; i < stocks.size(); i++) {
            if (stocks.get(i).getName().equalsIgnoreCase(name)) {
                stocks.remove(i);
                System.out.println(name + " removed from the portfolio.");
                return;
            }
        }
        System.out.println("Stock " + name + " not found in the portfolio.");
    }

    public void displayPortfolio() {
        if (stocks.isEmpty()) {
            System.out.println("Portfolio is empty.");
        } else {
            System.out.println("Your Portfolio:");
            for (Stock stock : stocks) {
                stock.displayStock();
            }
        }
    }

    public double calculateTotalPortfolioValue() {
        double total = 0;
        for (Stock stock : stocks) {
            total += stock.getTotalValue();
        }
        return total;
    }
}

// Main class
class PortfolioManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Portfolio portfolio = new Portfolio();

        while (true) {
            System.out.println("\nPortfolio Menu:");
            System.out.println("1. Add Stock");
            System.out.println("2. Remove Stock");
            System.out.println("3. Display Portfolio");
            System.out.println("4. Show Total Portfolio Value");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter stock name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter price per stock: ");
                    double price = scanner.nextDouble();
                    Stock stock = new Stock(name, quantity, price);
                    portfolio.addStock(stock);
                    break;

                case 2:
                    System.out.print("Enter stock name to remove: ");
                    String stockName = scanner.nextLine();
                    portfolio.removeStock(stockName);
                    break;

                case 3:
                    portfolio.displayPortfolio();
                    break;

                case 4:
                    System.out.println("Total Portfolio Value: " + portfolio.calculateTotalPortfolioValue());
                    break;

                case 5:
                    System.out.println("Exiting Portfolio Manager. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}