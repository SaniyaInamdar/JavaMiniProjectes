package atmSimulator;

import java.util.ArrayList;
import java.util.Scanner;

public class Account extends Person{
	Scanner sc=new Scanner(System.in);
	private long accountno;
	private double balance;
	private int pin;
	ArrayList<Account> accountList=new ArrayList<Account>();
	ArrayList<Transaction> transactionList=new ArrayList<Transaction>();
	public Account() {
		
	}
	
	public void setAccountNo(long accountno) {
		this.accountno=accountno;
	}
	public long getAccountNo() {
		return accountno;
	}
	
	public void setBalance(double balance) {
		this.balance=balance;
	}
	public double getBalance() {
		return balance;
	}
	
	public void setPin(int pin) {
		this.pin=pin;
	}
	public int getPin() {
		return pin;
	}
	public void AcceptDetails() {
		System.out.println("Enter Details : ");
		System.out.println("Enter id : ");
		super.setId(sc.nextInt());
		System.out.println("Enter name : ");
		super.setName(sc.next());
		System.out.println("Enter Account No : ");
		this.setAccountNo(sc.nextLong());
		System.out.println("Enter pin to set");
		this.setPin(sc.nextInt());
		System.out.println("Enter Balance to add : ");
		this.setBalance(sc.nextDouble());
		accountList.add(this);
	}

}
