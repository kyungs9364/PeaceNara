package hk02.logSystem;

import java.util.List;
import java.util.Scanner;

import hk02.market.Market;
import hk02.user.User;

public class Login {
	int num = 0;
	String loginId = "";
	String loginPw = "";
	Membership membership = new Membership();
	Scanner sc = new Scanner(System.in);
	List<User> userList;
	Market market = new Market();

	public Login(List<User> userList) {
		this.userList = userList;
	}

	public void login() {
		System.out.println("-------로그인-------");
		System.out.println("아이디 : ");
		loginId = sc.nextLine();
		System.out.println("비밀번호 : ");
		loginPw = sc.nextLine();

		for (int i = 0; i < userList.size(); i++) {
			if (loginId.equals(userList.get(i).getId()) && loginPw.equals(userList.get(i).getPw())) {
				System.out.println(userList.get(i).getId() + "님 로그인 성공");
				market.helloMarket(userList.get(i));
				memberOut(num);
			} else {
				System.out.println(userList.get(i).getId() + " 일치하지 않습니다.");
			}
		}
	}

	public void memberOut(int num) {
		while (true) {
			System.out.println("1.회원탈퇴");
			num = sc.nextInt();

			System.out.println("비밀번호 입력 : ");
			loginPw = sc.next();

			if (num == 1) {
				for (int i = 0; i < userList.size(); i++) {
					if (loginPw.equals(loginPw)) {
						if (loginId.equals(userList.get(i).getId()) && loginPw.equals(userList.get(i).getPw())) {
							userList.remove(i);
							System.out.println(loginId + "님 탈퇴되었습니다.");
						}
					} else {
						System.out.println("비밀번호를 확인해주세요.");
					}
				}
			} else {
				System.out.println("다시 입력하세요");
				continue;
			}

		}
	}
}
