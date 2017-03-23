package hk02.user;

import java.util.ArrayList;

import hk02.goods.Goods;

public class User {

	private String id; // ID
	private String pw; // Password
	private int balance; // 잔액
	private ArrayList<Goods> buyGoodsList; // 자신이 구매한 리스트 추가  ex)구매내역?
	private ArrayList<Goods> uploadedGoodsList; // 팔려고 업로드한 상품 리스트
	
	public User(String id, String pw, int balance){
		this.id = id;
		this.pw = pw;
		this.balance = balance;
		this.buyGoodsList = new ArrayList<Goods>();
		this.uploadedGoodsList = new ArrayList<Goods>();
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
	public ArrayList<Goods> getBuyGoodsList() {
		
		return buyGoodsList;
	}

	public void setBuyGoodsList(ArrayList<Goods> buyGoodsList, int buyNumber) {
		buyGoodsList.add(new Goods());
		this.buyGoodsList.add(buyGoodsList.get(buyNumber));
	}
	public ArrayList<Goods> getUploadedGoodsList() {
		return uploadedGoodsList;
	}
	public void setUploadedGoodsList(ArrayList<Goods> uploadedGoodsList) {
		this.uploadedGoodsList = uploadedGoodsList;
	}

}
