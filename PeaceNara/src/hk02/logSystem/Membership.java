package hk02.logSystem;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import hk02.market.Market;
import hk02.user.InputCheck;
import hk02.user.User;

public class Membership {

	User user = new User();
	public static List<User> userList = new ArrayList<>();
	
	public Membership() {		
		
	}

	public void memberMenu(Market market) {
		int num = 0;
		Login login = new Login(); //userList를 static으로 선언했으니 관련 내용 바꿈
//		Login login = new Login(userList);

		while (true) {
			System.out.println("----------------------------------------------------------------------------------------------");
			System.out.println("              1.로그인          2.회원가입         3.종료");
			System.out.println("----------------------------------------------------------------------------------------------");
			num = InputCheck.input123(); // MyPage의 유효성검사 가져다 씀.
			System.out.println();
			switch (num) {
				case 1:
					login.login(market);
					continue;
				case 2:
					input();
					continue;
				case 3:
					System.out.println("PeaceNara를 종료합니다.");
					System.exit(1);
				default:
					break;
			}
		}
	}

	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("--회원가입------------------------------------------------------------------------------------");
		
		String id = null; 
		while (true) {
			System.out.print("아이디 : ");
			id = sc.nextLine().replaceAll("\\s", "");
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

		String pwCheck = null;
		while (true) {
			System.out.print("비밀번호 확인 : ");
			pwCheck = sc.nextLine().replaceAll("\\s", "");
			if (!pw.equals(pwCheck)) {
				System.out.println("다시 확인해 주세요");
				continue;
			}
			user.setPwCheck(pwCheck);
			break;
		}

		String cellPhone = null;
		while (true) {
			System.out.print("핸드폰번호(ex: 010-1234-5678) : ");
			cellPhone = sc.nextLine().replaceAll("\\s", "");
			if(!isCellphone(cellPhone)) {
				System.out.println("올바른 형식으로 입력해주세요.");
				continue;
			}
			user.setCellPhone(cellPhone);
			break;
		}

		int balance = 0;
		while (true) {
			System.out.print("잔액(\\) : ");
			try {
				balance = sc.nextInt();
				user.setBalance(balance);
				break;
			} catch (InputMismatchException e) {
				System.out.println("숫자를 입력하세요");
				sc.nextLine();
			}
		}

		String str = null;
		while (true) {
			System.out.println("등록하시겠습니까?(y/n)");
			str = sc.next();
			if (str.equalsIgnoreCase("y")) {
				userList.add(new User(user.getId(), user.getPw(), user.getPwCheck(), user.getCellPhone(),
						user.getBalance()));
				System.out.println("감사합니다. 가입되셨습니다.\n");
			} else if (str.equalsIgnoreCase("n")) {
				System.out.println("등록이 취소되었습니다.\n");
			} else {
				System.out.println("다시 입력해주세요.");
				continue;
			}
			break;
		}
	}
	
	public boolean isCellphone(String str) {
		return str.matches("(01[016789])-(\\d{3,4})-(\\d{4})");
	}
}