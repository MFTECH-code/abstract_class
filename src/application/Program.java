package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.Payer;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Payer> payers = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		for (int i = 1; i < n + 1; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char cp = sc.next().charAt(0);
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Anual income: ");
			double anualIncome = sc.nextDouble();
			if (cp == 'i') {
				System.out.print("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();
				payers.add(new Individual(name, anualIncome, healthExpenditures));
			} else if (cp == 'c') {
				System.out.print("Number of employees: ");
				int numberOfEmployees = sc.nextInt();
				payers.add(new Company(name, anualIncome, numberOfEmployees));
			} else {
				System.out.println("Not found payer type...");
			}
		}
		
		System.out.println();
		double sumOfTaxes = 0;
		System.out.println("TAXES PAID:");
		for (Payer payer : payers) {
			System.out.printf("%s: $%.2f%n", payer.getName(), payer.tax());
			sumOfTaxes += payer.tax();
		}
		
		System.out.println();
		System.out.println("TOTAL TAXES: $" + String.format("%.2f", sumOfTaxes));
		
		
		sc.close();
	}

}
