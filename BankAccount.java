package folderOne.bankaccount;
import java.util.Random;
import java.util.Collections;

public class BankAccount {
	static String star = String.join("", Collections.nCopies(25, "*"));
	private String acctnum;
	private double checkbal;
	private double savbal;
	private static int numAccounts;
	private static double bankTotal;
	public BankAccount(){
		numAccounts++;
		acctnum = acctNumGen();
		System.out.println("BankAccount class created! : " + acctnum +"\n"+ star);
	}
	public static void getBankTotal() {
		System.out.println("bankTotal is: " + bankTotal+"\n"+ star);
	}
	private static String acctNumGen() {
		Random r  = new Random();
		long tempNum = 0;
		for (int i = 0 ; i < 10; i++) {
			tempNum = (tempNum *10) + r.nextInt(9);
		}
		String numString = Long.toString(tempNum);
		return numString;
	}
	
	public double getCheckbal() {
		System.out.println("Checking Balance is : " + this.checkbal);
		return this.checkbal;
	}
	public double getSavbal() {
		System.out.println("Checking Balance is : " + this.savbal);
		return this.savbal;
	}
	public void deposit(String chosenacct, double depamt) {
		if (depamt > 0) {			
			if (chosenacct.equals("checking")==true){
				this.checkbal+=depamt;
				bankTotal+=depamt;
				System.out.println("Despoited " +depamt +" to checking");
			}
			else if (chosenacct.equals("savings")==true){
				this.savbal+=depamt;			
				bankTotal+=depamt;
				System.out.println("Despoited " +depamt +" to savings");
			}
		}
		else {System.out.println("error deposit could not be processed for : "+ chosenacct +" " + depamt+ " , please see your banker");
		}
	}
	public void withdraw(String chosenacct, double wdamt) {
		if (wdamt > 0) {
			if (chosenacct.equals("checking")==true ){
				if (this.checkbal - wdamt>=0) {
					this.checkbal-=wdamt;
					bankTotal-=wdamt;
					System.out.println("Withdrew " +wdamt +" from checking");
				}
				else {System.out.println("NSF - WD could not be processed for : "+ chosenacct +" -" + wdamt+ " , please see your banker");}
			}
			else if (chosenacct.equals("savings")==true){
				if (this.savbal- wdamt>=0) {
					this.savbal-=wdamt;			
					bankTotal-=wdamt;
					System.out.println("Withdrew " +wdamt +" from savings");
				}
				else {System.out.println("NSF - WD could not be processed for : "+ chosenacct +" -" + wdamt+ " , please see your banker");}
			}
			else {System.out.println("error deposit could not be processed for : "+ chosenacct +" " + wdamt+ " , please see your banker");}
		}
		else {System.out.println("error deposit could not be processed for : "+ chosenacct +" " + wdamt+ " , please see your banker");
		}	
	}
	public void getBalance() {
		double tempbal = checkbal+savbal;
		System.out.println("Your Total Balance is: " + tempbal);
	}
}
