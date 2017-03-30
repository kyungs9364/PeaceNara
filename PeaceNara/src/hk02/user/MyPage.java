package hk02.user;

import java.util.Scanner;

import hk02.goods.ReNumbering;
import hk02.logSystem.Membership;
import hk02.market.Market;

// 사용법
// MyPage myPage = new MyPage();
// myPage.myPage(user);
// 매개변수로 로그인한 유저 넣어줄 것.

public class MyPage {
	
	public MyPage() {
		// TODO Auto-generated constructor stub
	}
	
	// my page 메뉴
	// 1. 내 정보 확인
	// 2. 비밀번호 변경
	// 3. 마이페이지 종료
	public boolean myPage(User user) {
		int num = 0;
		while(true) {
			System.out.println("--My Page-------------------------------------------------------------------------------------");
			System.out.println("원하는 메뉴의 번호를 입력하세요.");
			System.out.println("1. 내 정보 확인");
			System.out.println("2. 비밀번호 변경");
			System.out.println("3. 회원 탈퇴");
			System.out.println("4. 이전 메뉴");
			System.out.println("----------------------------------------------------------------------------------------------");
			num = InputCheck.input1234();
			if(num == 1) {
				user.printUserInfo(); // 내 정보 출력
				continue;
			} else if(num == 2) {
				updatePw(user); // 비밀번호 변경
				continue;
			} else if(num == 3) {
				memberOut(user);
				return false;
			} else {
				System.out.println("----------------------------------------------------------------------------------------------");
				System.out.println("My Page를 벗어납니다.");
				System.out.println("----------------------------------------------------------------------------------------------");
				return true; // 마이페이지 벗어나기
			}
		}
	}
	
	// 비밀번호 수정 (ID, 잔액은 수정 불가)
	public void updatePw(User user){
		System.out.println("비밀번호를 수정합니다.");
		if(checkPw(user)){
			inputNewPw(user);
		}
	}
	
	// 새 비밀번호 입력
	public void inputNewPw(User user){
		Scanner scan = new Scanner(System.in);
		String pw1 = "";
		String pw2 = "";
		while(true) {
			System.out.println("새로운 비밀번호를 입력해주세요.");
			System.out.print("> ");
			pw1 = scan.nextLine().trim();
			
			System.out.println("다시 한 번 입력해주세요.");
			System.out.print("> ");
			pw2 = scan.nextLine().trim();
			
			if(pw1.equals(pw2)){ // 입력한 두 개의 비밀번호가 같으면
				user.setPw(pw1);
				System.out.println("비밀번호를 변경했습니다.");
				return;
			}else{
				System.out.println("입력한 두 비밀번호가 다릅니다.");
				System.out.println("처음부터 다시 입력합니다.");
				continue;
			}
		}
	}
	
	// 비밀번호 변경 전에 이전 비밀번호 확인
	public boolean checkPw(User user){
		System.out.println("비밀번호를 입력하세요.");
		Scanner scan = new Scanner(System.in);
		String tmp = null;
		
		while(true) {
			System.out.print("> ");
			tmp = scan.nextLine().trim(); // 비밀번호 입력
			
			if(tmp.equals(user.getPw())){ 
				System.out.println("입력한 비밀번호가 맞습니다.");
				return true; // 입력한 비번이 맞으면 true 반환
			}
			
			System.out.println("입력한 비밀번호가 맞지 않습니다.");
			System.out.println("다시 입력해주세요.");
		}
	}
	
	// 회원 탈퇴
	public void memberOut(User user) {
		Scanner sc = new Scanner(System.in);
		System.out.println("회원 탈퇴를 진행합니다.");
		
		String ans = ""; // 정말 탈퇴할지 묻는 질문에 대한 대답 y/n
		boolean tmp = false;
		
		while (true) {
			System.out.println("정말 탈퇴하시겠습니까? (Y / N)");
			ans = InputCheck.inputYN();
			
			tmp = checkPw(user);
			
			int idx = 0;
			for (int i = 0; i < Membership.userList.size(); i++) {
				if (user.getId().equals(Membership.userList.get(i).getId()) && user.getPw().equals(Membership.userList.get(i).getPw())) {
					break;
				} else {
					idx++;
				}
			}
			
			if (idx >= Membership.userList.size()) {
				System.out.println("일치하는 회원이 없습니다.");
			} else if (idx >= 0) {
				removeGoodsInList(user);
				Membership.userList.remove(idx);
				ReNumbering rN = new ReNumbering();
				rN.reNumbering();
				
				System.out.println(user.getId() + "님 탈퇴되었습니다.");
				break;
			}
		}
	}
	
	public void removeGoodsInList(User user) {
		for (int i = 0; i < user.getSellGoodsList().size(); i++) {
			if(user.getSellGoodsList().get(i).getSeller().equals(user.getId())
					&& user.getSellGoodsList().get(i).getStock().equals("판매중")){
				Market.goodsList.remove(user.getSellGoodsList().get(i));
			}
		}
	}
}
