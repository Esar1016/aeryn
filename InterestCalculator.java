import java.util.Scanner;

public class InterestCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double principal = 0.0;
        double rate = 0.0;
        int years = 0;
        int n = 0;

        try {
            // 获取用户输入
            System.out.print("Enter the principal amount: ");
            principal = scanner.nextDouble();

            System.out.print("Enter the annual interest rate (in %): ");
            rate = scanner.nextDouble();

            System.out.print("Enter the duration of the loan (in years): ");
            years = scanner.nextInt();

            // 检查输入的有效性
            if (principal <= 0 || rate <= 0 || years <= 0) {
                System.out.println("Error: All values must be greater than zero.");
            } else {
                // 计算简单利息和总金额
                double simpleInterest = principal * (rate / 100) * years;
                double totalSimpleAmount = principal + simpleInterest;

                System.out.printf("For a principal amount of $%.2f at an annual interest rate of %.2f%% for %d years:\n", principal, rate, years);
                System.out.printf("The interest accrued is: $%.2f\n", simpleInterest);
                System.out.printf("The total amount to be paid back is: $%.2f\n", totalSimpleAmount);

                // 计算复利
                System.out.print("Enter the number of times interest is compounded per year: ");
                n = scanner.nextInt();

                if (n <= 0) {
                    System.out.println("Error: The number of times compounded per year must be greater than zero.");
                } else {
                    double compoundInterest = principal * Math.pow((1 + (rate / 100) / n), n * years) - principal;
                    double totalCompoundAmount = principal + compoundInterest;

                    System.out.printf("The compound interest accrued is: $%.2f\n", compoundInterest);
                    System.out.printf("The total amount to be paid back with compound interest is: $%.2f\n", totalCompoundAmount);
                }
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Please enter numeric values for the principal, rate, and an integer for the years and compounding frequency.");
        } finally {
            scanner.close();  // 关闭扫描器
        }
    }
}
