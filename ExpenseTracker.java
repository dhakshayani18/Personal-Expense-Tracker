import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
class ExpenseTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Validate monthly income
        double income;
        do {
            System.out.print("Enter your monthly income: ");
            income = sc.nextDouble();
            if (income <= 0) {
                System.out.println(
                    "Income must be greater than zero. Try again."
                );
            }
        } while (income <= 0);
        // Validate number of expenses
        int count;
        do {
            System.out.print("How many expenses do you want to enter? ");
            count = sc.nextInt();
            if (count <= 0) {
                System.out.println("Enter at least one expense.");
            }
        } while (count <= 0);
        // Create arrays
        String[] categories = new String[count];
        double[] expenses = new double[count];
        double total = 0;
        // Get expense details
        for (int i = 0; i < count; i++) {
            System.out.print(
                "Enter category for expense " + (i + 1) + ": "
            );
            categories[i] = sc.next();
            // Validate expense amount
            do {
                System.out.print("Enter amount: ");
                expenses[i] = sc.nextDouble();
                if (expenses[i] < 0) {
                    System.out.println(
                        "Expense cannot be negative. Try again."
                    );
                }
            } while (expenses[i] < 0);
            total = total + expenses[i];
        }
        // Calculate remaining balance
        double balance = income - total;
        // Display expense summary
        System.out.println("\n===== EXPENSE SUMMARY =====");
        for (int i = 0; i < count; i++) {
            System.out.println(
                categories[i] + ": " + expenses[i]
            );
        }
        System.out.println("Monthly Income: " + income);
        System.out.println("Total Expenses: " + total);
        System.out.println("Remaining Balance: " + balance);
        // Save summary to a file
        try {
            FileWriter writer = new FileWriter("expenses.txt");
            writer.write("===== EXPENSE SUMMARY =====\n");
            writer.write("Monthly Income: " + income + "\n");
            writer.write("\nExpense Details:\n");
            for (int i = 0; i < count; i++) {
                writer.write(
                    categories[i] + ": " + expenses[i] + "\n"
                );
            }
            writer.write("Total Expenses: " + total + "\n");
            writer.write("Remaining Balance: " + balance + "\n");
            writer.close();
            System.out.println("\nExpenses saved successfully!");
            System.out.println("File name: expenses.txt");
        } catch (IOException e) {
            System.out.println(
                "An error occurred while saving the file."
            );
        }
        sc.close();
    }
}