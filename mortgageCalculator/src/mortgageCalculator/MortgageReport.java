package mortgageCalculator;

import java.text.NumberFormat;

public class MortgageReport {
	
		private MortgageCalculator calculator;
		
		private NumberFormat currency; 
	
		public MortgageReport(MortgageCalculator calculator) {
			this.calculator = calculator;
			currency = NumberFormat.getCurrencyInstance();
		}
		
		public void printMortgage() {
			double mortgage = calculator.calculateMortgage();
			String mortgageFormatted = currency.format(mortgage);
			System.out.println();
			System.out.println("MORTGAGE");
			System.out.println("--------");
			System.out.println(mortgageFormatted);
		}
		
		public void printPaymentSchedule(){
			System.out.println();
			System.out.println("PAYMENT SCHEDULE");
			System.out.println("----------------");
			for (double balance : calculator.getRemainingBalances())
				System.out.println(currency.format(balance));
	}
}
