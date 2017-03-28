package hk02.logSystem;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import hk02.user.User;

public class Membership {
	Scanner sc = new Scanner(System.in);
	int num = 0;

	User user = new User();
	List<User> userList;

	public Membership() {
		this.userList = new ArrayList<>();
		// id = user.getId();
		// pw=user.getPw();
		// pwCheck=user.getPwCheck();
	}

	public void memberMenu() {
		System.out.println("-------------------");
		System.out.println("1.로그인    2.회원가입");
		System.out.println("-------------------");
		while (true) {
			try {
				num = sc.nextInt();
				Login login = new Login(userList);

				switch (num) {
				case 1:
					login.login();
					break;
				case 2:
					input();
					list();
					login.login();
					break;
				}
				if (num != 1 || num != 2) {
					System.out.println("1과 2 중에 입력하세요");
				}
			} catch (InputMismatchException e) {
				System.out.println("숫자를 입력하세요");
				sc.nextLine();
			}
		}
	}

	public void id() {

		// while (true) {
		System.out.print("아이디 : ");
		user.setId(sc.next());
		if (user.getId().length() > 10) {
			System.out.println("열글자 이하로 입력하세요.");
		}
		if (user.getId().length() < 5) {
			System.out.println("다섯글자 이상으로 입력하세요.");
		}
		sc.nextLine();
		// }
	}

	public void pw() {
		// while (true) {
		System.out.print("비밀번호 : ");
		user.setPw(sc.nextLine());
		if (user.getPw().length() > 10) {
			System.out.println("열다섯글자 이하로 입력하세요.");
		}
		if (user.getPw().length() < 5) {
			System.out.println("다섯글자 이상으로 입력하세요.");
		}
		sc.nextLine();
		// }
	}

	public void pwCheck() {
		// while (true) {
		System.out.println("비밀번호 확인 : ");
		user.setPwCheck(sc.nextLine());
		if (!user.getPw().equals(user.getPwCheck())) {
			System.out.println("다시 확인해 주세요");
		}
		sc.nextLine();
		// }
	}

	public void cellPhone() {
		System.out.println("핸드폰번호 : ");
		user.setCellPhone(sc.nextLine());
	}

	public void balance() {
		System.out.println("잔액 : ");

		try {
			user.setBalance(sc.nextInt());
		} catch (InputMismatchException e) {
			System.out.println("숫자를 입력하세요");
			sc.nextLine();
		}
	}

	public void member() {
		userList.add(new User("jhr", "a123", "a123", "010-1234-1234", 500000));
		userList.add(new User("yks", "b123", "b123", "010-1234-5678", 300000));
	}

	public void input() {
		System.out.println("---------회원가입---------");
		id();
		pw();
		pwCheck();
		cellPhone();
		balance();

		System.out.println("등록하시겠습니까?(y/n)");
		if (sc.nextLine().equals("y")) {
			userList.add(
					new User(user.getId(), user.getPw(), user.getPwCheck(), user.getCellPhone(), user.getBalance()));
			System.out.println("감사합니다. 가입되셨습니다.");
		} else {
			System.out.println("등록이 취소되었습니다.");
		}
	}

	public void list() {
		member();
		for (int i = 0; i < userList.size(); i++) {
			System.out.println(userList.get(i).toString());
		}

	}

}