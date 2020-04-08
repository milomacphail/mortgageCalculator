package mortgageCalculator;


import java.util.Scanner;
import java.lang.Math;
import java.text.NumberFormat;

public class Main {

	final static byte MONTHS_IN_YEAR = 12;
	final static byte PERCENT = 100;
	
	public static void main(String[] args) {

				Scanner scanner = new Scanner(System.in);
				
				int principal = (int)readNumber("Principal: ", 1000, 1_000_000);
				float annualInterestRate = (float)readNumber("Annual Interest Rate: ", 0, 100);
				int mortgageTerm = (int)readNumber("Term of mortgage in years:", 1, 30 );
	
				double mortgage = calculateMortgage(principal, annualInterestRate, mortgageTerm);
				System.out.println();
				System.out.println("MORTGAGE");
				System.out.println("--------");
				System.out.println("Mortgage: $" + mortgage);
				
				System.out.println();
				System.out.println("PAYMENT SCHEDULE");
				System.out.println("----------------");
				for (short month = 1; month <= mortgageTerm * MONTHS_IN_YEAR; month++) {
					double balance = calculateBalance(principal, annualInterestRate, mortgageTerm, month);
					System.out.println(NumberFormat.getCurrencyInstance().format(balance));
				}
	}
			public static double readNumber(String prompt, double min, double max) {
				Scanner scanner = new Scanner(System.in);
				double value;
				while(true) {
					System.out.print(prompt);
					value = scanner.nextFloat();
					if(value >= min && value <= max)
						break;
					System.out.println("Enter a value between " + min + " and " + max +".");
				}
				return value;
			}
			
			public static double calculateMortgage(int principal, float annualInterestRate, int mortgageTerm) {
				float numberOfPayments = mortgageTerm * MONTHS_IN_YEAR;
				float monthlyMortgageRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
				double mortgagePayment = principal * (monthlyMortgageRate * Math.pow(1 + monthlyMortgageRate, numberOfPayments))/ (Math.pow(1 + monthlyMortgageRate, numberOfPayments) - 1);
				return mortgagePayment;
			}
			
			public static double calculateBalance (int principal, float annualInterestRate, int mortgageTerm, short numberOfPaymentsMade) {
				float numberOfPayments = mortgageTerm * MONTHS_IN_YEAR;
				float monthlyMortgageRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
				double balance = principal * (Math.pow(1 + monthlyMortgageRate, numberOfPayments) - Math.pow(1 + monthlyMortgageRate, numberOfPaymentsMade)) /
						 (Math.pow(1 + monthlyMortgageRate, numberOfPayments));
				
				return balance;
			}


			
	}
