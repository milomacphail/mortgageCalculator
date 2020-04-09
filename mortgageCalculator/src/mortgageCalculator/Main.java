package mortgageCalculator;

import java.util.Scanner;
import java.lang.Math;
import java.text.NumberFormat;

public class Main {
	
	public static void main(String[] args) {

				int principal = (int)Console.readNumber("Principal: ", 1000, 1_000_000);
				float annualInterestRate = (float)Console.readNumber("Annual Interest Rate: ", 0, 100);
				byte mortgageTerm = (byte)Console.readNumber("Term of mortgage in years:", 1, 30 );
				
				var calculator =  new MortgageCalculator(principal, annualInterestRate, mortgageTerm);
				var report = new MortgageReport(calculator);
				
				report.printMortgage();
				report.printPaymentSchedule();
	
				}
	}
