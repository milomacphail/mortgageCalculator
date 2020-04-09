package mortgageCalculator;

import java.text.NumberFormat;

public class MortgageCalculator {
	
	private final static byte MONTHS_IN_YEAR = 12;
	private final static byte PERCENT = 100;
	private int principal;
	private float annualInterestRate;
	private byte mortgageTerm;
	
	public MortgageCalculator(int principal, float annualInterestRate, byte mortgageTerm) {
		this.principal = principal;
		this.annualInterestRate = annualInterestRate;
		this.mortgageTerm = mortgageTerm;
	}

	public double calculateMortgage() {
		float numberOfPayments = getNumberOfPayments();
		float monthlyMortgageRate = getMonthlyMortgageRate();
		double mortgagePayment = principal 
				* (monthlyMortgageRate * Math.pow(1 + monthlyMortgageRate, numberOfPayments))
				/ (Math.pow(1 + monthlyMortgageRate, numberOfPayments) - 1);
		return mortgagePayment;
	}

	public double calculateBalance(short numberOfPaymentsMade) {
		float numberOfPayments = getNumberOfPayments();
		float monthlyMortgageRate = getMonthlyMortgageRate();
		double balance = principal
				* (Math.pow(1 + monthlyMortgageRate, numberOfPayments)
				- Math.pow(1 + monthlyMortgageRate, numberOfPaymentsMade))
				/ (Math.pow(1 + monthlyMortgageRate, numberOfPayments));
		return balance;
	}
	
	public double[] getRemainingBalances()
	{
		var balances = new double[getNumberOfPayments()];
		for (short month = 1; month <= balances.length; month++)
			balances[month -1] = calculateBalance(month);
		return balances;
	}
	
	private float getMonthlyMortgageRate()
	{
		return annualInterestRate / PERCENT / MONTHS_IN_YEAR; 
	}
	
	private int getNumberOfPayments()
	{
		return mortgageTerm * MONTHS_IN_YEAR;
	}
}