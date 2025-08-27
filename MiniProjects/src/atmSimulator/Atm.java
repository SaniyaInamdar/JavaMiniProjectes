package atmSimulator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Scanner;

public class Atm extends Account {
	Scanner sc = new Scanner(System.in);
	int pin;
	int depositeID, withdrawId, balanceId, statementId, changePinId;
	double depositAmount;
	double withdrawAmount;
	Account a;
	Transaction t;

	public Atm() {
		super.AcceptDetails();
	}

	public void deposite() {

		System.out.println("Enter Account No To deposit : ");
		depositeID = sc.nextInt();
		System.out.println("Enter Pin  : ");
		pin = sc.nextInt();
		Iterator<Account> itr = super.accountList.iterator();
		while (itr.hasNext()) {
			Account a = itr.next();
			if (a.getAccountNo() == this.depositeID && a.getPin() == this.pin) {
				System.out.println("Enter Deposite Amount : ");
				depositAmount = sc.nextDouble();
				a.setBalance(a.getBalance() + depositAmount);
			 a.transactionList.add(new Transaction("Deposite : ", depositAmount, LocalDateTime.now().toString()));
			}
		}
	}

	public void checkbalance() {
		System.out.println("Enter Account no to check balance : ");
		balanceId = sc.nextInt();
		System.out.println("Enter Pin  : ");
		pin = sc.nextInt();
		Iterator<Account> itr = super.accountList.iterator();
		while (itr.hasNext()) {
			Account a = itr.next();
			if (a.getAccountNo() == this.balanceId && a.getPin() == this.pin) {
				System.out.println(a.getBalance());
			}

		}
	}

	public void withdraw() throws LimitCrossedException{
		boolean success = false;
		System.out.println("Enter Account No :");
		withdrawId = sc.nextInt();
		System.out.println("Enter Pin : ");
		pin = sc.nextInt();
		Iterator<Account> itr = super.accountList.iterator();
		while (itr.hasNext()) {
			Account a = itr.next();
			if (a.getAccountNo() == this.withdrawId && a.getPin() == this.pin) {
				System.out.println("Enter Withraw Amount : ");
				withdrawAmount = sc.nextDouble();
				if (withdrawAmount >= 25000) {
						throw new LimitCrossedException("Limit Croswed : Amount is greater than 250000");
				}
				if (withdrawAmount <= super.getBalance()) {
					a.setBalance(a.getBalance() - withdrawAmount);
					a.transactionList.add(new Transaction("Withdraw : ", withdrawAmount, LocalDateTime.now().toString()));
				}
			}
		}
	}

	public void statement() {
		System.out.println("Enter Account no  :");
		statementId = sc.nextInt();
		System.out.println("Enter Pin : ");
		pin = sc.nextInt();
		for (Account acc : super.accountList) {
		    if (acc.getAccountNo() == statementId && acc.getPin() == pin) {
		        if (acc.transactionList.isEmpty()) {
		            System.out.println("No Transactions yet.");
		        } else {
		            for (Transaction t : acc.transactionList) {
		                System.out.println(t);
		            }
		        }
		    }
		}
	}

	public void changePin() {
		System.out.println("Enter Account No  :");
		changePinId = sc.nextInt();
		System.out.println("Enter Current Pin : ");
		int currentPin = sc.nextInt();
		Iterator<Account> itr = super.accountList.iterator();
		while (itr.hasNext()) {
			a = itr.next();
			if (a.getAccountNo() == changePinId && a.getPin() == currentPin) {
				System.out.println("Enter pin to Update : ");
				int updatePin = sc.nextInt();
				System.out.println("Enter Again Pin to update : ");
				int updatePin2 = sc.nextInt();
				if (updatePin == updatePin2) {
					a.setPin(updatePin2);
					System.out.println("Updated Suceefully");
				}
			}
		}

	}

	public void saveDataIntoFile() {
		String fileUrl = "D:\\Eclipse\\MiniProjects\\src\\atmSimulator\\SaveDataFolder\\ATMDATA.txt";
		File f = new File(fileUrl);
		try {
			f.createNewFile();
			FileWriter fw = new FileWriter(f, true);
			for (Account acc : super.accountList) {
				fw.write("Id : " + acc.getId() + " Name : " + acc.getName() + " AccountNo  :" + acc.getAccountNo()
						+ " Balance : " + acc.getBalance() + "\n");
			}
			fw.flush();
			fw.close();
			System.out.println("Data Saved....");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
