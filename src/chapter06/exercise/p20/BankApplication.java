package chapter06.exercise.p20;

import java.util.Scanner;

public class BankApplication {
	private static Account[] accountArray = new Account[100];
	private static Scanner scanner = new Scanner(System.in);
	
	private static int size = 0;

	public static void main(String[] args) {
		boolean run = true;
		
		while(run) {
			System.out.println("--------------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("--------------------------------------------------");
			System.out.print("선택>");
			
			int selectNo = scanner.nextInt();
			
			if (selectNo == 1) {
				createAccount();
			} else if (selectNo == 2) {
				accountList();
			} else if (selectNo == 3) {
				deposit();
			} else if (selectNo == 4) {
				withdraw();
			} else if (selectNo == 5) {
				run = false;
			}
		}
		
		System.out.println("프로그램 종료");
	}
	
	private static void createAccount() {
		System.out.println("--------");
		System.out.println("계좌생성");
		System.out.println("--------");
		System.out.print("계좌번호:");
		String ano = scanner.next();
		System.out.print("계좌주:");
		String owner = scanner.next();
		System.out.print("초기입금액:");
		int balance = scanner.nextInt();
		
		accountArray[size] = new Account(ano, owner, balance);
		size++;
		
		System.out.println("결과: 계좌가 생성되었습니다.");
	}
	
	private static void accountList() {
		System.out.println("--------");
		System.out.println("계좌목록");
		System.out.println("--------");
		
		for (int i = 0; i < size; i++) {
			String ano = accountArray[i].getAno();
			String owner = accountArray[i].getOwner();
			int balance = accountArray[i].getBalance();
			
			System.out.println(ano + "\t" + owner + "\t" + balance);
		}
	}
	
	private static void deposit() {
		System.out.println("--------");
		System.out.println("예금");
		System.out.println("--------");
		
		System.out.print("계좌번호: ");
		String ano = scanner.next();
		
		Account account = findAccount(ano);
		
		System.out.print("예금액:");
		int money = scanner.nextInt();
		int total = money + account.getBalance();
		
		account.setBalance(total);
		System.out.println("결과: 예금이 성공되었습니다.");
	}
	
	private static Account findAccount(String ano) {
		for (int i = 0; i < size; i++) {
			if (accountArray[i].getAno().equals(ano)) {
				return accountArray[i];
			}
		}
		return null;
	}

	private static void withdraw() {
		System.out.println("--------");
		System.out.println("출금");
		System.out.println("--------");
		System.out.print("계좌번호: ");

		String ano = scanner.next();
		
		Account account = findAccount(ano);
		
		System.out.print("출금액:");
		int money = scanner.nextInt();
		int result = account.getBalance() - money;
		
		account.setBalance(result);
		System.out.println("결과: 출금이 성공되었습니다.");
	}

//	private static Account findAccount(String ano) {
//		for (int i = 0; i < size; i++) {
//			if (accountArray[i].getAno().equals(ano)) {
//				return accountArray[i];
//			}
//		}
//		
//		return null;
//	}
	
}
