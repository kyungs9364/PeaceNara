package hk02.goods;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Goods {
	private String title = ""; // 게시물 제목
	private String content = ""; // 게시물 내용
	private int number = 0; // 게시물 번호

	private String model = ""; // 판매 물품 모델명
	private String company = ""; // 판매 물품 제작사명
	private int price = 0; // 판매 물품 가격

	private String seller = ""; // 판매자 (id or 이름)

	private String time = ""; // 게시 시간(yyyy/MM/DD)
	private String time2 = ""; // 게시 시간(HH/mm/ss) 상세 게시물을 표시할 때 사용하거나
								// 리스트를 표시 할 때 time값이 오늘이면 시간으로 표시하는 것을 고려

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");

	private boolean stock = false; // 재고(판매중과 판매완료를 구분하기 위해 존재)

	public Goods() {
		Date today = new Date(); // 게시물이 생성 될 때 시간 기록
		this.time = sdf.format(today);
		this.time2 = sdf2.format(today);
		this.stock = true; // 게시물이 생성되었다는 것은 판매중이라는 의미
	}

	public Goods(String title, String content, String model, String company, int number, int price, String seller,
			String time) {
		
		// 더미 데이터 입력을 위한 생성자
		this.title = title;
		this.content = content;
		this.number = number;
		this.price = price;
		this.seller = seller;
		this.time = time; 
		this.time2 = "00:00:00"; // 더미데이터의 time2는 따로 기록하지 않을 생각
		this.stock = true;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public boolean isStock() {
		return stock;
	}

	public void setStock(boolean stock) {
		this.stock = stock;
	}

	
	@Override // 미완성
	public String toString() {
		System.out.printf("%3d  제목: %-9s\t가격: %d\t판매자: %s\t게시일: %s",number,title,price,seller,time);
		return "";
		// number + "\t제목: " + title + "\t\t가격: " + price + "\t판매자: " + seller + "\t게시일 " + time;
	}	

}
