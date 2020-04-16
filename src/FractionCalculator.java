import java.util.Scanner;

public class FractionCalculator {
    //enter fractions and operations, calculate result
    //run until told to quit
    private final String message = "Invalid Fraction. Please enter (a/b) or (a), where a and b " +
            "are integers and b is not zero: ";

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

    public Fraction getFraction(Scanner inputFraction) {
        Fraction fraction;
        String s;
        String pattern1 = "\\d+/\\d+" ;
        String pattern2 = "\\d+";
        int numerator, denominator;
        System.out.println("Please enter a fraction (a/b) or integer (a): ");
        s = inputFraction.nextLine();
        while (!(s.matches(pattern1)||s.matches(pattern2))) {
            System.out.println(message);
            s = inputFraction.next();
        }
        if (s.matches(pattern1)) {
            String[] elements = s.split("/");
            numerator = Integer.parseInt(elements[0]);
            denominator = Integer.parseInt(elements[1]);
            fraction = new Fraction(numerator, denominator);
        } else {
            numerator = Integer.parseInt(s);
            fraction = new Fraction(numerator);
        }
        return fraction;
    }

 /*   public boolean validtFraction(String input) {

    }*/


    public static void main(String[] args) {
        System.out.println("This program is a fraction calculator \n" +
                "It will add subtract, multply and divide fractions until you type Q to quit \n" +
                "Please enter your fractions in the form a/b, where a and b are integers. \n" +
                "-------------------------------------------------------------------------------\n");
        FractionCalculator fractionCalculator = new FractionCalculator();
        Fraction fraction = new Fraction();
        Scanner scanner = new Scanner(System.in);
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