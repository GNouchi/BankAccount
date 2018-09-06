package folderOne.bankaccount;

public class bankAccountTest {
	public static void main(String[]args){
		BankAccount test1 = new BankAccount();
		test1.getCheckbal();
		test1.getSavbal();
		BankAccount.getBankTotal();
		test1.deposit("savings", 25);
		test1.deposit("checking", 50);
		BankAccount.getBankTotal();
		test1.withdraw("savings", 25);
//		test1.withdraw("checking", 50);
		BankAccount.getBankTotal();
		test1.getBalance();
		}
}
