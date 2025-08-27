package atmSimulator;


public class Transaction {
	String currentDateTime;
	String type;
	double amount;
	
	public Transaction(String type, double amount, String currentDateTime) {
		this.type=type;
		this.amount=amount;
		this.currentDateTime=currentDateTime;
	}
	
	@Override
	public String toString() {
		return "[ "+type+" "+amount+" "+currentDateTime+" ]";
	}
}
