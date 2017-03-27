package hk02.logSystem;

import java.util.List;
import java.util.Scanner;

import hk02.user.User;

public class Login {
	String loginId = "";
	String loginPw = "";
	Membership membership = new Membership();
	Scanner sc = new Scanner(System.in);
	List<User> userList;

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
			} else {
				System.out.println(userList.get(i).getId() + " 일치하지 않습니다.");
			}
		}

	}
}
