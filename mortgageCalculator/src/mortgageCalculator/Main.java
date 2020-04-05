package mortgageCalculator;


import java.util.Scanner;
import java.lang.Math;

public class Main {

	public static void main(String[] args) {

				Scanner scanner = new Scanner(System.in);
				
				int principal = 1;
				while(true) {
					System.out.print("Principal: ");
					principal = scanner.nextInt();
					if(principal >= 1000 && principal <= 1_000_000) {
						System.out.println(principal);
						break;
					}
					System.out.println("Enter a value between $1000 and $1000000");
				}
				
				double annualInterestRate = -0.1;
				
				while(true) {
					System.out.print("Annual Interest Rate: ");
					annualInterestRate = scanner.nextDouble();
					if(annualInterestRate >= 0)
					{
						System.out.println(annualInterestRate);
						break;
					}
					System.out.println("Interest rate must be higher than 0%: ");
				}
			
				
				int mortgageTerm = -1;
				
				while(true) {
					System.out.print("Mortage term: ");
					mortgageTerm = scanner.nextInt();
					if(mortgageTerm >= 0)
					{
						System.out.println("Mortgage term is: " + mortgageTerm + " years.");
						break;
					}
					System.out.println("Mortgage term must be more than 0 years.");
				}
			
				
				int months = mortgageTerm * 12;
				System.out.println("Months: " + months);
				double monthlyRate = ((annualInterestRate/100) / 12);
				System.out.println("Monthly Rate: " + monthlyRate);
				double monthlyMortgageInterest = principal * (monthlyRate * Math.pow(1 + monthlyRate, months))/ (Math.pow(1 + monthlyRate, months) - 1);
				System.out.println("$"+monthlyMortgageInterest);

			}
	}
