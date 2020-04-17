import java.util.Scanner;

public class FractionCalculator {

    private final String message = "Invalid Fraction. Please enter (a/b) or (a), where a and b " +
            "are integers and b is not zero: ";

    private static int numerator, denominator;

    public void welcome() {
        System.out.println("This program is a fraction calculator \n" +
                "It will add subtract, multply and divide fractions until you type Q to quit \n" +
                "Please enter your fractions in the form a/b, where a and b are integers. \n" +
                "-------------------------------------------------------------------------------\n");
        ;
    }

    public String getOperation(Scanner operatorInput) {
        operatorInput = new Scanner(System.in);
        String operatorString = "";
        System.out.println("Please enter an operation (+, -, /, *, = or Q to quit:");
        while (!(operatorString.equals("+") || operatorString.equals("-") || operatorString.equals("/")
                || operatorString.equals("*") || operatorString.equals("="))) {
            if (operatorString.equalsIgnoreCase("q")) System.exit(0);
            operatorString = operatorInput.next();
            System.out.println(message);
        }
        return operatorString;
    }

    public Fraction getFraction(Scanner fractionInput) {
        boolean result;

        String stringInput;
        Fraction fraction;
        FractionCalculator fractionCalculator = new FractionCalculator();
        System.out.println("Please enter a fraction (a/b) or integer (a): ");
        stringInput = fractionInput.nextLine();
        result = fractionCalculator.validtFraction(stringInput);
        while (!(result)) {
            System.out.println(message);
            stringInput = fractionInput.nextLine();
            result = fractionCalculator.validtFraction(stringInput);
        }
        if ((denominator > 0))
            fraction = new Fraction(numerator, denominator);
        else
            fraction = new Fraction(numerator);
        return fraction;
    }

    public boolean validtFraction(String input) {
        String pattern1 = "-?\\d+/\\d+";
        String pattern2 = "-?\\d+";
//        int numerator, denominator;
        if (!(input.matches(pattern1) || input.matches(pattern2))) return false;
        if (input.matches(pattern1)) {
            String[] elements = input.split("/");
            numerator = (Math.abs(Integer.parseInt(elements[0])));
            denominator = Integer.parseInt(elements[1]);
        } else {
            numerator = Math.abs(Integer.parseInt(input));
        }
        return true;
    }


    public static void main(String[] args) {
        FractionCalculator fractionCalculator = new FractionCalculator();
        Fraction fraction = new Fraction();
        Scanner scanner = new Scanner(System.in);
        fractionCalculator.welcome();
//        String operation = fractionCalculator.getOperation(scanner);
        fraction = fractionCalculator.getFraction(scanner);
//        char operatorChar = operation.charAt(0);

/*
        switch (operatorChar) {
            case '+':

        }
*/
    }

}