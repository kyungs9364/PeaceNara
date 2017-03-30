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
	private ArrayList<Goods> buyGoodsList; // 구매내역
	private ArrayList<Goods> sellGoodsList; // 판매내역

	// 더미
	public User() {
	
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
	
	//더미용 생성자
	public User(String id, String pw, String cellPhone) {
		this.id = id;
		this.pw = pw;
		this.cellPhone = cellPhone;
		this.pwCheck = pw;
		this.balance = 10000000;
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
				"--내 정보-------------------------------------------------------------------------------------");
		System.out.println("ID         : " + getId());
		System.out.println("전화번호 : " + getCellPhone());
		System.out.println("잔액      : " + getBalance() + "원");
		System.out.println("----------------------------------------------------------------------------------------------");
	}
	
	// Market클래스에서 가져왔음.
	public void printSellList() {
		System.out.println("--판매 내역-----------------------------------------------------------------------------------");
		System.out.println(" No\t게시글명\t\t\t  가격\t\t 판매자\t\t    날짜\t 상태");
		System.out.println("==============================================================================================");
		for (int i = getSellGoodsList().size() - 1; i >= 0; i--) { // 역순으로 게시글을
																	// 보이게함.(최신글
																	// 순.)
			System.out.println(getSellGoodsList().get(i));
		}
		System.out.println("----------------------------------------------------------------------------------------------");
	}

	// Market클래스에서 가져왔음.
	public void printBuyList() {
		System.out.println(
				"--구매 내역-----------------------------------------------------------------------------------");
		System.out.println(" No\t게시글명\t\t\t  가격\t\t 판매자\t\t    날짜\t 상태");
		System.out.println("==============================================================================================");
		for (int i = getBuyGoodsList().size() - 1; i >= 0; i--) { // 역순으로 게시글을
																	// 보이게함.(최신글
																	// 순.)
			System.out.println(getBuyGoodsList().get(i));
		}
		System.out.println("----------------------------------------------------------------------------------------------");
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
