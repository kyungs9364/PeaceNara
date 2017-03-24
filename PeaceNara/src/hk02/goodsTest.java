package hk02;

import java.util.ArrayList;

import hk02.goods.Goods;

public class GoodsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Goods> goodsList = new ArrayList<Goods>();
		int cnt = 1;

		goodsList.add(new Goods("V20", "가개통","LG-F800K" ,"LG" ,cnt++, 500000, "skd", "2017/03/23"));
		goodsList.add(new Goods("갤럭시 S7", "6개월 사용","SM-G930S","삼성", cnt++, 450000, "ksw", "2017/03/23"));
		goodsList.add(new Goods("G5", "1년 사용","G5","LG-F700S", cnt++, 300000, "skd", "2017/03/23"));
		goodsList.add(new Goods("iPhone 7", "3개월 사용","iPhone 7","Apple", cnt++, 600000, "skd", "2017/03/23"));

		int n = goodsList.size();
		goodsList.add(new Goods());
		goodsList.get(n).setTitle("갤럭시 노트7");
		goodsList.get(n).setContent("폭발하지 않아요");
		goodsList.get(n).setModel("SM-N930k");
		goodsList.get(n).setCompany("삼성");
		goodsList.get(n).setNumber(5);
		goodsList.get(n).setPrice(550000);
		goodsList.get(n).setSeller("skd");		
		
		System.out.println(" No    제목\t   가격\t 판매자\t    등록일\t 상태");
		for (int i = goodsList.size()-1; i >= 0; i--) {
			System.out.println(goodsList.get(i));
		}
	}
}
