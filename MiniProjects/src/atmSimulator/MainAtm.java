package atmSimulator;

import java.util.Scanner;

//Start with Multiple Accounts option.
//Add Mini Statement (last 5 transactions).
//Add PIN retry limit (3 attempts).
//Extend with Savings vs Current accounts.

public class MainAtm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Atm a=new Atm();
		Scanner sc=new Scanner(System.in);
		int choice;
		
		
		do {
			System.out.println("Enter Choice  : ");
			System.out.println("1. Deposite");
			System.out.println("2. Check Balance");
			System.out.println("3. Withdraw");
			System.out.println("4. Statement");
			System.out.println("5. Change Pin");
			System.out.println("6. Add new account");
			choice =sc.nextInt();
			
			switch(choice) {
			case 1: a.deposite(); a.saveDataIntoFile(); break;
			case 2 : a.checkbalance();  break;
			case 3: try{
				a.withdraw(); a.saveDataIntoFile(); 
				} 
			catch(LimitCrossedException e) { 
				System.out.println(e.getMessage());
					}
			break;
			case 4: a.statement(); break;
			case 5: a.changePin(); break;
			case 6: a=new Atm(); break;
			case 7: System.out.println("Thank You"); break;
			default : System.out.println("Wrong Choice : ");
			}
		}while(choice != 7);
	}
}
