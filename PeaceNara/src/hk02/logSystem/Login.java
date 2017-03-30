package hk02.logSystem;

import java.util.List;
import java.util.Scanner;

import hk02.market.Market;
import hk02.user.User;

public class Login {
	int num = 0;
	String loginId = "";
	String loginPw = "";
	Scanner sc = new Scanner(System.in);
	List<User> userList;
	Market market = new Market();

	public Login(List<User> userList) {
		this.userList = userList;
	}

	public void login() {
		while (true) {
			System.out.println("-------로그인-------");
			System.out.println("아이디 : ");
			loginId = sc.nextLine();
			System.out.println("비밀번호 : ");
			loginPw = sc.nextLine();

			int idx = 0;
			for (int i = 0; i < userList.size(); i++) {
				if (loginId.equals(userList.get(i).getId()) && loginPw.equals(userList.get(i).getPw())) {
					break;
				} else {
					idx++;
				}
			}

			if (idx >= userList.size()) {
				System.out.println("일치하는 회원이 없습니다.");
			} else if (idx >= 0) {
				System.out.println(userList.get(idx).getId() + "님 로그인 성공");
				market.helloMarket(userList.get(idx));
				memberOut();
			}
		}
	}

	public void memberOut() {
		String inputPw = null;
		while (true) {
			System.out.println("1.회원탈퇴");
			num = sc.nextInt();

			if (num == 1) {
				System.out.println("비밀번호 입력 : ");
				inputPw = sc.next();
				if (!(inputPw.equals(loginPw))) {
					System.out.println("비밀번호를 확인해주세요.");
					continue;
				}

				int idx = 0;
				for (int i = 0; i < userList.size(); i++) {
					if (loginId.equals(userList.get(i).getId()) && loginPw.equals(userList.get(i).getPw())) {
						break;
					} else {
						idx++;
					}
				}

				if (idx >= userList.size()) {
					System.out.println("일치하는 회원이 없습니다.");
				} else if (idx >= 0) {
					userList.remove(idx);
					System.out.println(loginId + "님 탈퇴되었습니다.");
					break;
				}

			} else {
				System.out.println("다시 입력하세요");
				continue;
			}
		}
	}
}
