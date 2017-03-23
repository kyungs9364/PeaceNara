package hk02.user;

import java.util.ArrayList;

public class User {

	private String id; // ID
	private String pw; // Password
	private int balance; // 잔액
	private ArrayList<Goods> uploadedGoodsList; // 팔려고 업로드한 상품 리스트
	
	public User(String id, String pw, int balance){
		this.id = id;
		this.pw = pw;
		this.balance = balance;
		this.uploadedGoodsList = null; // goods클래스 올라오면 수정
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
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public ArrayList<Goods> getUploadedGoodsList() {
		return uploadedGoodsList;
	}
	public void setUploadedGoodsList(ArrayList<Goods> uploadedGoodsList) {
		this.uploadedGoodsList = uploadedGoodsList;
	}
}
