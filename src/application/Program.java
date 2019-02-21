package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptons.DomainExceptions;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter account data");
		System.out.print("Number: ");
		int number = scanner.nextInt();
		System.out.print("Holder: ");
		scanner.nextLine();
		String holder = scanner.nextLine();
		try {
			System.out.print("Initial balance: ");
			double balance = scanner.nextDouble();
			System.out.print("Withdraw limit: ");
			double withdrawLimit = scanner.nextDouble();
			
			Account account = new Account(number, holder, balance, withdrawLimit);
			
			System.out.println();
			System.out.print("Enter amount for withdraw: ");
			Double amount = scanner.nextDouble();
			account.withdraw(amount);
			System.out.println(account);
			
		} catch (DomainExceptions e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
		
		scanner.close();

	}

}
