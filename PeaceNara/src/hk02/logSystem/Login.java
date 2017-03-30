package hk02.logSystem;

import java.util.Scanner;
import hk02.market.Market;

public class Login {
	int num = 0;
	String loginId = "";
	String loginPw = "";
	Scanner sc = new Scanner(System.in);
	//	List<User> userList; 
	// 이 클래스의 모든 userList -> Membership.userList로 바꿈
//	Market market = new Market();

	
	public Login() {
	}
	
//	public Login(List<User> userList) {
//		this.userList = userList;
//	}

	public void login(Market market) {
		while (true) {
			System.out.println("--로그인--------------------------------------------------------------------------------------");
			System.out.print("아이디 : ");
			loginId = sc.nextLine();
			System.out.print("비밀번호 : ");
			loginPw = sc.nextLine();

			int idx = 0;
			for (int i = 0; i < Membership.userList.size(); i++) {
				if (loginId.equals(Membership.userList.get(i).getId()) && loginPw.equals(Membership.userList.get(i).getPw())) {
					break;
				} else {
					idx++;
				}
			}

			if (idx >= Membership.userList.size()) {
				System.out.println("일치하는 회원이 없습니다.");
				break;
			} else if (idx >= 0) {
				System.out.println("\n"+Membership.userList.get(idx).getId() + "님, 로그인하셨습니다.");
				market.helloMarket(Membership.userList.get(idx));
//				memberOut();
			}
		}
	}
}
