import java.util.Scanner;

public class FractionCalculator {
    //enter fractoins and operations, calculate result
    //run until told to quit

    public String getOperation(Scanner scanner) {
        String s = null;
        return s;
    }

/*    public Fraction getFraction(Scanner scanner) {

    }
    public boolean validtFraction(String input) {

    }*/


    public static void main(String[] args) {
        System.out.println("This program is a fraction calculator \n" +
                "It will add subtract, multply and divide fractions until you type Q to quit \n" +
                "Please enter your fractions in the form a/b, where a and b are integers. \n" +
                "-------------------------------------------------------------------------------\n" +
                "Please enter an operation (+, -, /, *, = or Q to quit):");
        int a = 1/2;
        int b = 1/2;
        int c = a + b;
        System.out.println(c);

    }
}
