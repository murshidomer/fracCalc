import java.util.Scanner;

public class FractionCalculator {

    public static void main(String[] args) {
        String operator;
        FractionCalculator fractionCalculator = new FractionCalculator();
        Scanner scanner = new Scanner(System.in);
        fractionCalculator.welcome();
        do {
            operator = fractionCalculator.getOperation(scanner);
            char operatorChar = operator.charAt(0);
            Fraction fraction, fraction2, result;
            switch (operatorChar) {
                case '+':
                    fraction = fractionCalculator.getFraction(scanner);
                    fraction2 = fractionCalculator.getFraction(scanner);
                    result = fraction.add(fraction2);
                    System.out.println(fraction +" " +operatorChar + " " + fraction2+" = "+ result);
                    break;
                case '*':
                    fraction = fractionCalculator.getFraction(scanner);
                    fraction2 = fractionCalculator.getFraction(scanner);
                    result = fraction.multiply(fraction2);
                    System.out.println(fraction +" " +operatorChar + " " + fraction2+" = "+ result);
                    break;
                case '/':
                    fraction = fractionCalculator.getFraction(scanner);
                    fraction2 = fractionCalculator.getFraction(scanner);
                    result = fraction.divide(fraction2);
                    System.out.println(fraction +" " +operatorChar + " " + fraction2+" = "+ result);
                    break;
                case '-':
                    fraction = fractionCalculator.getFraction(scanner);
                    fraction2 = fractionCalculator.getFraction(scanner);
                    result = fraction.subtract(fraction2);
                    System.out.println(fraction +" " +operatorChar + " " + fraction2+" = "+ result);
                    break;

            }
        } while (!(operator.equalsIgnoreCase("q")));
        System.exit(0);
    }

    public void welcome() {
        System.out.print("This program is a fraction calculator \n" +
                "It will add subtract, multply and divide fractions until you type Q to quit \n" +
                "Please enter your fractions in the form a/b, where a and b are integers. \n");
    }

    public String getOperation(Scanner operatorInput) {
        operatorInput = new Scanner(System.in);
        System.out.println("-------------------------------------------------------------------------------");
        System.out.print("Please enter an operation (+, -, /, *, = or Q to quit): ");
        String operatorString = operatorInput.next();
        while (!(operatorString.equals("+") || operatorString.equals("-") || operatorString.equals("/")
                || operatorString.equals("*") || operatorString.equals("=") ||
                operatorString.equalsIgnoreCase("q"))) {
            System.out.println("Invalid input (+, -, /, *, = or Q to quit): ");
            operatorString = operatorInput.next();
        }
        return operatorString;
    }

    public Fraction getFraction(Scanner fractionInput) {
        boolean result;
        String stringInput;
        String pattern1 = "-?\\d+/\\d+";
        int numerator, denominator;
        FractionCalculator fractionCalculator = new FractionCalculator();
        System.out.print("Please enter a fraction (a/b) or integer (a): ");
        stringInput = fractionInput.nextLine();
        result = fractionCalculator.validtFraction(stringInput);
        while (!(result)) {
            System.out.print("Invalid Fraction. Please enter (a/b) or (a), where a and b " +
                    "are integers and b is not zero: ");
            stringInput = fractionInput.nextLine();
            result = fractionCalculator.validtFraction(stringInput);
        }
        Fraction fraction;
        if ((stringInput.matches(pattern1))) {
            String[] elements = stringInput.split("/");
            numerator = Integer.parseInt(elements[0]);
            denominator = Integer.parseInt(elements[1]);
            fraction = new Fraction(numerator, denominator);
        } else {
            numerator = Integer.parseInt(stringInput);
            fraction = new Fraction(numerator);
        }
        return fraction;
    }

    public boolean validtFraction(String input) {
        String pattern1 = "-?\\d+/\\d+";
        String pattern2 = "-?\\d+";
        return input.matches(pattern1) || input.matches(pattern2);
    }

}