import java.util.Scanner;
import java.text.NumberFormat;

public class Main {

    public static void main(String[] args) {

        final byte MONTHS_INYEAR = 12;
        final byte PERCENT = 100;
        int principle;
        float annualInterest;
        float monthlyInterest;
        byte years;
        int numberOfPayments;

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.print("Principle: ($1K - $1M)");
            principle = scanner.nextInt();

            if (principle >=1000 && principle <= 1000000)
                break;
            System.out.println("Enter a value between 1000 and 1000000");

        }

        while (true) {

            System.out.print("Annual Interest Rate: ");
            annualInterest = scanner.nextFloat();
            if (annualInterest >= 1 && annualInterest <= 30) {
                monthlyInterest = annualInterest / PERCENT / MONTHS_INYEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30");

        }
        
        while(true) {

            System.out.print("Period (Years): ");
            years = scanner.nextByte();
            if (years >=1 && years <=30) {
                numberOfPayments = years * MONTHS_INYEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30");
            
        }

        double mortgage = principle * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)) / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    
    }
    
}