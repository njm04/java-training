package com.company;

public class MortgageCalculator {
    private static final int MONTHS_IN_YEAR = 12;
    private static final int PERCENT = 100;
    private int principal;
    private int period;
    private float annualInterestRate;

    public MortgageCalculator(int principal, int period, float annualInterestRate) {
        this.principal = principal;
        this.period = period;
        this.annualInterestRate = annualInterestRate;
    }

    public double calculateBalance(int numberOfPaymentsMade) {

        int periodInMonths = getPeriodInMonths();
        float monthlyInterestRate = getMonthlyInterestRate();

        double balance = principal
                * (Math.pow(1 + monthlyInterestRate, periodInMonths) -
                Math.pow(1 + monthlyInterestRate, numberOfPaymentsMade)) /
                (Math.pow(1 + monthlyInterestRate, periodInMonths) - 1);

        return  balance;
    }

    public double calculateMortgage() {
        int periodInMonths = getPeriodInMonths();
        float monthlyInterestRate = getMonthlyInterestRate();

        double mortgage = (principal * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, periodInMonths)) /
                (Math.pow(1 + monthlyInterestRate, periodInMonths) - 1);

        return mortgage;
    }

    public double[] getMonthlyBalance() {
        double[] balances = new double[getPeriodInMonths()];
        for (short month = 1; month <= balances.length; month++)
            balances[month - 1] = calculateBalance(month);

        return balances;
    }

    public int getPeriodInMonths() {
        return period * MONTHS_IN_YEAR;
    }

    private float getMonthlyInterestRate() {
        return annualInterestRate / PERCENT / MONTHS_IN_YEAR;
    }
}
