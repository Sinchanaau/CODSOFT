import java.util.*;
class BankAccount{
	String name,username,password,accountno;
	float balance=100000f;
	int transactions=0;
	String transactionHistory="";
	
	public void register() {
		Scanner sc=new Scanner(System.in);
		System.out.print("\n\t\t\tEnter your name -\n\t\t\t");
		this.name=sc.nextLine();
		System.out.print("\n\t\t\tEnter your username -\n\t\t\t");
		this.username=sc.nextLine();
		System.out.print("\n\t\t\tEnter your password -\n\t\t\t");
		this.password=sc.nextLine();
		System.out.print("\n\t\t\tEnter your Account Number -\n\t\t\t");
		this.accountno=sc.nextLine();
		System.out.print("\n\t\t\tRegistration Completed....Kindly Login");
	}
	
	public boolean login() {
		boolean isLogin=false;
		Scanner sc=new Scanner(System.in);
		while(!isLogin) {
			System.out.print("\n\t\t\tEnter your Username -\n\t\t\t");
			String UserName=sc.nextLine();
			if(UserName.equals(username)) {
				while(!isLogin) {
					System.out.print("\n\t\t\tEnter your Password -\n\t\t\t");
					String Password=sc.nextLine();
					if(Password.equals(password)) {
						System.out.print("\n\t\t\tLogin Successfull !!\n\t\t\t");
						isLogin=true;
					}
					else {
						System.out.print("\n\t\t\tIncorrect Password\n\t\t\t");
					}
				}
			}
			else {
				System.out.print("\n\t\t\tUserName Inavalid\n\t\t\t");
			}
		}
		return isLogin;
	}
	
	 public void withdraw() {
		 System.out.print("\n\t\t\tEnter the amount to withdraw -\n\t\t\t");
		 Scanner sc=new Scanner(System.in);
		 float amount=sc.nextFloat();
		 try {
			 if(balance>amount) {
				 transactions++;
				 balance=balance-amount;
				 System.out.println("\n\t\t\tWithdraw Successful");
				 String str=amount+ " Rs Withdrawed";
				 transactionHistory=transactionHistory.concat(str);
			 }
			 else {
				 System.out.println("\n\t\t\tInsufficient Balance");
			 }
		 }
		 catch(Exception e) {
			 
		 }
	 }
	 
	 public void deposit() {
		 System.out.print("\n\t\t\tEnter the amount to deposit -\n\t\t\t");
		 Scanner sc=new Scanner(System.in);
		 float amount=sc.nextFloat();
		 try {
			 if(amount<=100000f) {
				 transactions++;
				 balance=balance+amount;
				 System.out.println("\n\t\t\tSuccessfully Deposited");
				 String str=amount+ " Rs deposited";
				 transactionHistory=transactionHistory.concat(str);
			 }
			 else {
				 System.out.println("\n\t\t\tPlease deposit amount below the limit");
			 }
		 }
		 catch(Exception e) {
			 
		 }
	 }
	 
	 public void transfer() {
		 Scanner sc=new Scanner(System.in);
		 System.out.print("\n\t\t\tEnter receipent name --\t\t\t");
		 String receipent=sc.nextLine();
		 System.out.print("\n\t\t\tEnter the amount to transfer - \t\t\t");
		 float amt=sc.nextFloat();
		 try {
			 if(balance>=amt) {
				 if(amt<=50000f) {
					 transactions++;
					 balance-=amt;
					 System.out.println("\n\t\t\tSuccessfully transfered to " +receipent);
					 String str=amt+ " Rs transfered to "+receipent+ " ";
					 transactionHistory=transactionHistory.concat(str);
				 }
				 else {
					 System.out.println("\n\t\t\tPlease enter the amount below the limit");
				 }
			 }
			 else {
				 System.out.println("\n\t\t\tInsufficient Balance");
			 }
		 }
		 catch(Exception e) {
			 
		 }
	 }
	 
	 public void checkBalance() {
		 System.out.println("\n\t\t\t"+balance+ "Rs");
	 }
	 
	 public void transHistory() {
		 if(transactions==0) {
			 System.out.println("\n\t\t\tNo Transactions yet");
		 }
		 else {
			 System.out.println("\n\t\t\t" + transactionHistory);
		 }
	 }
  }
public class ATM{
	public static int takeIntegerInput(int Limit) {
		int input=0;
		boolean flag=false;
		while(!flag) {
			try {
				Scanner sc=new Scanner(System.in);
				input=sc.nextInt();
				flag=true;
				if(flag && input >Limit ||  input < 1 ) {
					System.out.println("\t\t\tChosee the number between 1 to "+Limit);
					flag=false;
				}
			}
			catch(Exception e) {
				System.out.println("\t\t\tEnter only integer values");
			}
		};
		return input;
	}
	
	public static void main(String[] args) {
		System.out.println("\t\t\t*****WELCOME TO ATM SYSTEM*****\t\t\t");
		System.out.println("\t\t\t1.Register");
		System.out.println("\t\t\t2.Exit");
		System.out.print("\t\t\tEnter your Choice\n\t\t\t");
		int choice=takeIntegerInput(2);
		if(choice==1) {
			BankAccount b=new BankAccount();
			b.register();
			while(true) {
				System.out.println("\t\t\t1.Login");
				System.out.println("\t\t\t2.Exit");
				System.out.print("\t\t\tEnter your choice -\n\t\t\t");
				int ch=takeIntegerInput(2);
				if(ch==1){
					if(b.login()) {
						System.out.println("\t\t\t*****WELCOME "+b.name+ " *****");
						boolean isFinished=false;
						while(!isFinished) {
							System.out.print("\n\t\t\t1.Withdraw");
							System.out.print("\n\t\t\t2.Deposit");
							System.out.print("\n\t\t\t3.Transfer");
							System.out.print("\n\t\t\t4.Check Balance");
							System.out.print("\n\t\t\t5.Transaction History");
							System.out.print("\n\t\t\t6.Exit");
							System.out.print("\n\t\t\tEnter your choice --\n\t\t\t");
							int c=takeIntegerInput(6);
							switch(c) {
							case 1:
								b.withdraw();
								break;
							case 2:
								b.deposit();
								break;
							case 3:
								b.transfer();
								break;
							case 4:
								b.checkBalance();
								break;
							case 5:
								b.transHistory();
								break;
							case 6:
								 isFinished=true;
								 break;
							}	
						}
					}
				}
				else {
					System.exit(0);
				}
			}
		}
		else {
			System.exit(0);
		}
	}
}