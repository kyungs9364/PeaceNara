package hk02.goods;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import hk02.market.Market;

public class Goods {
	private String title = ""; // 게시물 제목
	ArrayList<String> content = new ArrayList<String>();
	// private String content = ""; // 게시물 내용
	private int number = 0; // 게시물 번호

	private String company = ""; // 판매 물품 제조사명
	private int price = 0; // 판매 물품 가격

	private String seller = ""; // 판매자 (id or 이름)
	private String cellPhone; // 전화번호 : 010-0000-0000

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

	public Goods(String title, String content, String company, int price, String seller, String cellPhone,
			String time) {
		// 더미 데이터 입력을 위한 생성자
		this.title = title;
		this.content.add(content);
		this.company = company;
		this.number = Market.goodsList.size() + 1;
		this.price = price;
		this.seller = seller;
		this.cellPhone = cellPhone;
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

	public ArrayList<String> getContent() {
		return content;
	}

	public void setContent(ArrayList<String> content) {
		this.content = content;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
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

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
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

	public String getStock() {
		if (stock) {
			return "판매중";
		} else {
			return "판매완료";
		}
	}

	public String getTime2() {
		return time2;
	}
	
	@Override
	public String toString() {
		System.out.printf("%3d  %.20s", number, title);
		if(title.getBytes().length < 30){
			for (int i = 0; i <= (30 - title.getBytes().length); i++){
				System.out.print(" ");
			}
		}
		System.out.printf("\t %d\t     %s\t", price, seller);
		if(seller.getBytes().length < 10){
			System.out.print("\t");
		}
		System.out.printf(" %s\t", time);
		System.out.printf("%4s",getStock());
		return "";
	}

}
