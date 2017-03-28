package hk02.user;

import java.util.ArrayList;

import hk02.goods.Goods;

public class User {

	private String id; // ID : 문자, 특수문자, 숫자 다 가능. 나중에 loginSystem에서 회원가입할 때 공백
						// 제거 예정.
	private String pw; // Password : 나중에 loginSystem에서 회원가입할 때 공백 제거 예정.
	private String pwCheck; // PasswordCheck
	private String cellPhone; // 전화번호 : 010-0000-0000
	private int balance; // 잔액 : 123456원
	private ArrayList<Goods> buyGoodsList; // 자신이 구매한 리스트
	private ArrayList<Goods> sellGoodsList; // 팔려고 업로드한 상품 리스트

	// 더미
	public User() {
		this.id = "강석원";
		this.pw = "1234";
		this.cellPhone = "010-1234-5678";
		this.balance = 305000;
		this.buyGoodsList = new ArrayList<Goods>();
		this.sellGoodsList = new ArrayList<Goods>();
		buyGoodsList.add(new Goods("V20", "가개통", "LG-F800K", "LG", 1, 500000, "skd", "2017/03/23"));
		buyGoodsList.add(new Goods("갤럭시 S7", "6개월 사용", "SM-G930S", "삼성", 2, 450000, "ksw", "2017/03/20"));
		buyGoodsList.add(new Goods("G5", "1년 사용", "G5", "LG-F700S", 3, 300000, "skd", "2017/03/19"));
		buyGoodsList.add(new Goods("iphone 7", "3개월 사용", "iPhone 7", "Apple", 4, 600000, "skd", "2017/03/23"));
		for (int i = 0; i < buyGoodsList.size(); i++) {
			buyGoodsList.get(i).setStock(false);
		}
		sellGoodsList.add(new Goods("V20", "가개통", "LG-F800K", "LG", 1, 500000, "skd", "2017/03/23"));
		sellGoodsList.add(new Goods("갤럭시 S7", "6개월 사용", "SM-G930S", "삼성", 2, 450000, "ksw", "2017/03/20"));
		sellGoodsList.add(new Goods("G5", "1년 사용", "G5", "LG-F700S", 3, 300000, "skd", "2017/03/19"));
		sellGoodsList.add(new Goods("iphone 7", "3개월 사용", "iPhone 7", "Apple", 4, 600000, "skd", "2017/03/23"));
	}

	// 이 생성자는 삭제 예정
	public User(String id, String pw, int balance) {
		this.id = id;
		this.pw = pw;
		this.cellPhone = "010-0000-0000";
		this.balance = balance;
		this.buyGoodsList = new ArrayList<Goods>();
		this.sellGoodsList = new ArrayList<Goods>();
	}

	// 생성자
	public User(String id, String pw, String pwCheck, String cellPhone, int balance) {
		this.id = id;
		this.pw = pw;
		this.cellPhone = cellPhone;
		this.pwCheck = pwCheck;
		this.balance = balance;
		this.buyGoodsList = new ArrayList<Goods>();
		this.sellGoodsList = new ArrayList<Goods>();
	}

	// 회원정보 출력
	public void printUserInfo() {
		System.out.println();
		printInfo(); // 이름, 전화번호, 잔액 출력
		printSellList(); // 판매중인 물품리스트 출력
		printBuyList(); // 구매내역 출력
	}

	// 이름, 전화번호, 잔액 출력
	public void printInfo() {
		System.out.println(
				"--내 정보------------------------------------------------------------------------------------------------------------------");
		System.out.println("ID         : " + getId());
		System.out.println("전화번호 : " + getCellPhone());
		System.out.println("잔액      : " + getBalance() + "원");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------\n");
	}

	// Market클래스에서 가져왔음.
	public void printSellList() {
		System.out.println(
				"--판매중인 물품----------------------------------------------------------------------------------------------------------");
		System.out.println(" 번호  게시글명     가격   판매자     날짜         상태");
		System.out.println("============================================================================");
		for (int i = getSellGoodsList().size() - 1; i >= 0; i--) { // 역순으로 게시글을
																	// 보이게함.(최신글
																	// 순.)
			System.out.println(getSellGoodsList().get(i));
		}
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------\n");
	}

	// Market클래스에서 가져왔음.
	public void printBuyList() {
		System.out.println(
				"--구매 내역---------------------------------------------------------------------------------------------------------------");
		System.out.println(" 번호  게시글명     가격   판매자     날짜         상태");
		System.out.println("============================================================================");
		for (int i = getBuyGoodsList().size() - 1; i >= 0; i--) { // 역순으로 게시글을
																	// 보이게함.(최신글
																	// 순.)
			System.out.println(getBuyGoodsList().get(i));
		}
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------\n");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getPwCheck() {
		return pwCheck;
	}

	public void setPwCheck(String pwCheck) {
		this.pwCheck = pwCheck;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public ArrayList<Goods> getBuyGoodsList() {
		return buyGoodsList;
	}

	public void setBuyGoodsList(ArrayList<Goods> buyGoodsList) {
		this.buyGoodsList = buyGoodsList;
	}

	public void setBuyGoodsList(ArrayList<Goods> buyGoodsList, int buyNumber) {
		this.buyGoodsList.add(buyGoodsList.get(buyNumber));
	}

	public ArrayList<Goods> getSellGoodsList() {
		return sellGoodsList;
	}

	public void setSellGoodsList(ArrayList<Goods> sellGoodsList, int sellNumber) {
		this.sellGoodsList.add(sellGoodsList.get(sellNumber));
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", pw=" + pw + ", pwCheck=" + pwCheck + "]";
	}
}
