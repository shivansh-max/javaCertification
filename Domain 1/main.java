import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Hello welcome to calculator, please enter which operation (+,-,*,/) >> ");
        String operation = sc.nextLine();
        System.out.print("Please enter the first number: ");
        float num1 = Float.parseFloat(sc.nextLine());
        System.out.print("Please enter the second number: ");
        float num2 = Float.parseFloat(sc.nextLine());

        switch (operation) {
            case "+":
                System.out.println(num1 + num2);
                break;
            case "-":
                System.out.println(num1 - num2);
                break;
            case "*":
                System.out.println(num1 * num2);
                break;
            case "/":
                System.out.println(num1 / num2);
                break;
            default:
                System.out.println("Invalid operation");
                break;
        }
    }
}