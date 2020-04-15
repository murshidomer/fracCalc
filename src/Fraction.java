import java.util.Objects;
import java.util.Scanner;

public class Fraction {
    //hold numberator, denominator
    private int numerator;
    private int denominator;


    public Fraction() {
        numerator = 0;
        denominator = 1;
    }

    public Fraction(int numerator) {
        this.numerator = numerator;
        denominator = 1;
    }

    public Fraction subtract(Fraction other) {
        Fraction subtractionResult = new Fraction();
        subtractionResult.numerator =
                (this.numerator * other.denominator) - (other.numerator * this.denominator);
        subtractionResult.denominator = this.denominator * other.denominator;
        return subtractionResult;

    }
    public Fraction divide(Fraction other) {
        Fraction divisionResult = new Fraction();
        divisionResult.numerator = other.numerator * this.denominator;
        divisionResult.denominator = other.denominator * this.numerator;
        return divisionResult;
    }

    public Fraction multiply(Fraction other) {
        Fraction mutliplicationResult = new Fraction();
        mutliplicationResult.numerator = other.numerator * this.numerator;
        mutliplicationResult.denominator = other.denominator * this.denominator;
        return mutliplicationResult;
    }


    public Fraction(int numerator, int denominator) throws IllegalArgumentException {
        this.numerator = numerator;
        this.denominator = denominator;
        if (denominator == 0) throw new IllegalArgumentException();
        if (denominator < 0) {
            this.numerator *= Integer.signum(denominator);
            this.denominator *= Integer.signum(denominator);
        }

    }

    public void toLowestTerms() {
        int divisor = gcd(this.numerator, this.denominator);
        this.numerator /= divisor;
        this.denominator /= divisor;

    }

    public static int gcd(int num, int den) {
        int remainder = 0, temp = 0;
        while (!(num == 0 || den == 0)) {
            temp = num;
            remainder = num % den;
            num = den;
            den = remainder;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println("Enter fraction ");
        Scanner scanner = new Scanner(System.in);
        int numerator, denominator;
        numerator = scanner.nextInt();
        denominator = scanner.nextInt();
        Fraction fraction = new Fraction(numerator, denominator);
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public double toDouble() {
        double result = numerator / denominator;
        return result;
    }

    public Fraction add(Fraction other) {
        Fraction additionResult = new Fraction();
        additionResult.numerator =
                (this.numerator * other.denominator) + (other.numerator * this.denominator);
        additionResult.denominator = this.denominator * other.denominator;
        return additionResult;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()||!(o instanceof Fraction)) return false;
        Fraction other = (Fraction)o;
        other.toLowestTerms();
        this.toLowestTerms();
        if (other.numerator == this.numerator && other.denominator == this.denominator) {
            return Objects.equals(other, this);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }


}

