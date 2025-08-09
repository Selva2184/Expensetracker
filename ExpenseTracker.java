import java.io.*;
import java.util.*;
import java.util.stream.*;

class Expense {
    String date;
    String category;
    double amount;

    Expense(String date, String category, double amount) {
        this.date = date;
        this.category = category;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("%s | %s | Rs.%.2f", date, category, amount);
    }
}

class ExpenseTracker {
    static List<Expense> expenses = new ArrayList<>();
    static String fileName = "expenses.txt";

    public static void main(String args[]) {
        loadExpenses();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Expense Tracker ---");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. View Total by Category");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("Date (YYYY-MM-DD): ");
                    String date = sc.nextLine().trim();
                    System.out.print("Category: ");
                    String category = sc.nextLine().trim();
                    System.out.print("Amount: ");
                    String amtStr = sc.nextLine().trim();
                    try {
                        double amount = Double.parseDouble(amtStr);
                        expenses.add(new Expense(date, category, amount));
                        saveExpenses();
                        System.out.println("Expense added.");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid amount. Please enter a number.");
                    } catch (IOException e) {
                        System.out.println("Error saving expense: " + e.getMessage());
                    }
                    break;
                case "2":
                    if (expenses.isEmpty()) {
                        System.out.println("No expenses recorded.");
                    } else {
                        expenses.forEach(System.out::println);
                    }
                    break;
                case "3":
                    System.out.print("Enter category: ");
                    String cat = sc.nextLine().trim();
                    double total = expenses.stream()
                            .filter(e -> e.category.equalsIgnoreCase(cat))
                            .mapToDouble(e -> e.amount)
                            .sum();
                    System.out.printf("Total in '%s': Rs.%.2f%n", cat, total);
                    break;
                case "4":
                    System.out.println("Exiting. Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    static void loadExpenses() {
        File f = new File(fileName);
        if (!f.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split(",");
                if (parts.length < 3) continue;
                String date = parts[0].trim();
                String category = parts[1].trim();
                double amount = Double.parseDouble(parts[2].trim());
                expenses.add(new Expense(date, category, amount));
            }
        } catch (IOException e) {
            System.out.println("Error reading expenses file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Skipping invalid entry in expenses file.");
        }
    }

    static void saveExpenses() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Expense e : expenses) {
                bw.write(e.date + "," + e.category + "," + e.amount);
                bw.newLine();
            }
        }
    }
}
