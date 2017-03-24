//package hk02.user;
//
//import java.util.Scanner;
//
//
//public class MyPage {
//	// 로그인 한 유저 변수를
//	// public static User loginUser라고 가정하고 작성함
//	
//	// my page 메뉴
//	// 1. 내 정보 확인
//	// 2. 비밀번호 변경
//	// 3. 마이페이지 종료
//	// 마이페이지 쓸 때 myPageMenu()만 끼워넣으면 됨
//	public void myPageMenu() {
//		while(true) {
//			System.out.println("\n\n-----------------------------My Page---------------------------");
//			System.out.println("원하는 메뉴의 번호를 입력하세요.");
//			System.out.println("1. 내 정보 확인");
//			System.out.println("2. 비밀번호 변경");
//			System.out.println("3. 종료");
//	
//			if(input123() == 1){
//				printUserInfo(); // 내 정보 출력
//			} else if(input123() == 2){
//				updatePw(); // 비밀번호 변경
//			} else {
//				System.out.println("My Page를 벗어납니다.");
//				System.out.println("---------------------------------------------------------------\n");
//				break; // 마이페이지 벗어나기
//			}
//		}
//	}
//	
//	// Scanner로 String으로 입력받아서 int반환 (유효성검사: 1, 2, 3)
//	private int input123(){
//		Scanner scan = new Scanner(System.in);
//		String tmp = null;
//		int result = 0;
//		while(true) {
//			tmp = scan.next().trim();
//			if(tmp.matches("[123]")){
//				result = Integer.parseInt(tmp);
//				break;
//			}else{
//				System.out.println("잘못 입력하셨습니다.");
//				System.out.println("원하는 메뉴의 번호를 입력해주세요.");
//				continue;
//			}
//		}
//		return result;
//	}
//	
//	// 비밀번호 수정 (ID, 잔액은 수정 불가)
//	public void updatePw(){
//		System.out.println("\n비밀번호를 수정합니다.");
//		
//		if(checkPw()){
//			inputNewPw();
//		}
//	}
//	
//	// 새 비밀번호 입력
//	private void inputNewPw(){
//		Scanner scan = new Scanner(System.in);
//		String pw1 = "";
//		String pw2 = "";
//		
//		while(true) {
//			System.out.println("\n새로운 비밀번호를 입력해주세요.");
//			pw1 = scan.nextLine().trim();
//			
//			System.out.println("다시 한 번 입력해주세요.");
//			pw2 = scan.nextLine().trim();
//			
//			if(pw1.equals(pw2)){ // 입력한 두 개의 비밀번호가 같으면
//				loginUser.setPw(pw1);
//				System.out.println("비밀번호를 변경했습니다.");
//				return;
//			}else{
//				System.out.println("입력한 두 비밀번호가 다릅니다.");
//				System.out.println("처음부터 다시 입력합니다.");
//				continue;
//			}
//		}
//	}
//	
//	// 비밀번호 변경 전에 이전 비밀번호 확인
//	private boolean checkPw(){
//		// 비밀번호 5회 이상 틀리면 변경안되는 기능 추가 고려
//		System.out.println("이전 비밀번호를 입력하세요.");
//		
//		Scanner scan = new Scanner(System.in);
//		String tmp = null;
//		
//		while(true) {
//			tmp = scan.nextLine().trim(); // 비밀번호 입력
//			
//			if(tmp.equals(loginUser.getPw())){ 
//				System.out.println("입력한 비밀번호가 맞습니다.");
//				return true; // 입력한 비번이 맞으면 true 반환
//			}
//			
//			System.out.println("입력한 비밀번호가 맞지 않습니다.");
//			System.out.println("다시 입력해주세요.");
//		}
//	}
//	
//	/** printUserInfo() 출력물(예정)
//	 * 
//	 * -----------------------------내 정보---------------------------
//	 * ID   	: admin
//	 * 잔액	: 10000원
//	 * --------------------------등록한 물품--------------------------
//	 * 아직 goods class가 안올라와서 모름...
//	 * 
//	 */
//	public void printUserInfo() {
//		System.out.println("-----------------------------내 정보-----------------------------");
//		System.out.println("ID\t\t: " + loginUser.getId());
//		System.out.println("잔액\t: " + loginUser.getBalance()+"원"); 
//		System.out.println("--------------------------판매중인 물품--------------------------");
//		for (int i = 0; i < loginUser.getUploadedGoodsList().size(); i++) {
//			// goods class 업로드되면 다시 확인
//			System.out.println(loginUser.getUploadedGoodsList().get(i));
//		}
//		System.out.println("-------------------------------------------------------------------");
//	}
//}
