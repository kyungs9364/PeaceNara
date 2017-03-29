package hk02.logSystem;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import hk02.user.User;

public class Membership {

	User user = new User();
	public static List<User> userList = new ArrayList<>();

	public Membership() {
		userList.add(new User("jhrrr", "a123123", "a123123", "010-1234-5678", 500000));
		userList.add(new User("yksss", "b123123", "b123123", "010-1234-5678", 300000));
	}

	public void memberMenu() {
		int num = 0;
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println("\t1.로그인    2.회원가입");
			System.out.println("-------------------------------------------------------------------------------");
			try { 
				num = sc.nextInt();
				Login login = new Login(userList);
				switch (num) {
				case 1:
					login.login();
					login.memberOut();
					break;
				case 2:
					input();
					login.login();
					break;

				default:
					System.out.println("1과 2 중에 입력하세요");
				}

			} catch (InputMismatchException e) {
				System.out.println("숫자를 입력하세요");
				sc.nextLine();
			}
		}
	}

	public boolean isCellphone(String str) {
		return str.matches("(01[016789])-(\\d{3,4})-(\\d{4})");
	}

	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("--회원가입--------------------------------------------------------------------");
		while (true) {
			System.out.print("아이디 : ");
			String id = sc.nextLine().replaceAll("\\s", "");
			if (id.length() > 10) {
				System.out.println("열글자 이하로 입력하세요.");
				continue;
			}
			if (id.length() < 5) {
				System.out.println("다섯글자 이상으로 입력하세요.");
				continue;
			}
			user.setId(id);
			break;
		}

		String pw = "";
		while (true) {
			System.out.print("비밀번호 : ");
			pw = sc.nextLine().replaceAll("\\s", "");
			if (pw.length() > 10) {
				System.out.println("열다섯글자 이하로 입력하세요.");
				continue;
			}
			if (pw.length() < 4) {
				System.out.println("네글자 이상으로 입력하세요.");
				continue;
			}
			user.setPw(pw);
			break;
		}

		while (true) {
			System.out.print("비밀번호 확인 : ");
			String pwCheck = sc.nextLine().replaceAll("\\s", "");
			if (!pw.equals(pwCheck)) {
				System.out.println("다시 확인해 주세요");
				continue;
			}
			user.setPwCheck(pwCheck);
			break;
		}

		while (true) {
			System.out.print("핸드폰번호 : ");
			String cellPhone = sc.nextLine().replaceAll("\\s", "");
			isCellphone(cellPhone);
			user.setCellPhone(cellPhone);
			break;
		}

		while (true) {
			System.out.print("잔액 : ");
			int balance = sc.nextInt();
			try {
				user.setBalance(balance);
			} catch (InputMismatchException e) {
				System.out.println("숫자를 입력하세요");
				sc.nextLine();
			}
			break;
		}

		while (true) {
			System.out.println("등록하시겠습니까?(y/n)");
			String str = sc.next();
			if (str.equalsIgnoreCase("y")) {
				userList.add(new User(user.getId(), user.getPw(), user.getPwCheck(), user.getCellPhone(),
						user.getBalance()));
				System.out.println("감사합니다. 가입되셨습니다.");
			} else if (str.equalsIgnoreCase("n")) {
				System.out.println("등록이 취소되었습니다.");
			} else {
				System.out.println("다시 입력해주세요.");
				continue;
			}
			break;
		}
	}
}