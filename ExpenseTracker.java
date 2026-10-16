import java.util.Scanner;
class ExpenseTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double income = 0;
        double expenses = 0;
        System.out.print("Enter your monthly income: ");
        income = sc.nextDouble();
        System.out.print("Enter your total expenses: ");
        expenses = sc.nextDouble();
        double balance = income - expenses;
        System.out.println("Remaining Balance: " + balance);
        sc.close();
    }
}
