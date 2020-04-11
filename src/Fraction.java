import java.util.Scanner;

import static java.lang.StrictMath.abs;
import static java.lang.StrictMath.copySign;

public class Fraction {
    //hold numberator, denominator
    private double numerator ;
    private double denominator ;


    public Fraction(double numerator, double denominator) throws IllegalArgumentException {
        this.numerator = numerator;
        this.denominator = denominator;
        if (denominator == 0) throw new IllegalArgumentException();
        if (denominator < 0) copySign(numerator, denominator);
    }


    public static void main(String[] args) {
        System.out.println("Enter n % d ");
        Scanner scanner = new Scanner(System.in);
        double numerator, denominator;
        numerator = scanner.nextInt();
        denominator = scanner.nextInt();
        Fraction fraction = new Fraction(numerator, denominator);
    }

}

