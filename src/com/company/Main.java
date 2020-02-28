package com.company;

public class Main {

    public static void main(String[] args) {

        int principal = (int) Console.readNumber("Principal", 1000, 1_000_000);
        float annualInterestRate = (float) Console.readNumber("Annual Interest Rate", 0, 30);
        int period = (int) Console.readNumber("Period (Years)", 0, 30);

        var calculator = new MortgageCalculator(principal, period, annualInterestRate);
        var report = new MortgageReport(calculator);
        report.printMortgage();
        report.printPaymentSchedule();
    }


}
