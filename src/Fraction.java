import java.util.Scanner;

import static java.lang.StrictMath.abs;
import static java.lang.StrictMath.copySign;

public class Fraction {
    //hold numberator, denominator
    private int numerator ;
    private int denominator ;


    public Fraction(int numerator, int denominator) throws IllegalArgumentException {
        this.numerator = numerator;
        this.denominator = denominator;
        if (denominator == 0) throw new IllegalArgumentException();
        if (denominator < 0) StrictMath.copySign(numerator, denominator);
    }


    public static void main(String[] args) {
        System.out.println("Enter n % d ");
        Scanner scanner = new Scanner(System.in);
        int numerator, denominator;
        numerator = scanner.nextInt();
        denominator = scanner.nextInt();
        Fraction fraction = new Fraction(numerator, denominator);
    }

}

