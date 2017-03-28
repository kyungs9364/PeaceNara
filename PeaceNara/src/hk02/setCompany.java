package hk02;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import hk02.goods.Goods;
import hk02.goods.ViewGoods;

public class setCompany {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Goods> goodsList = new ArrayList<Goods>();
		{
			Scanner sc = new Scanner(System.in);
			ViewGoods vg = new ViewGoods();
			ArrayList<String> tmp = new ArrayList<String>();
			
			int num = 0;

			goodsList.add(new Goods("V20팝니다.", "가개통", "LG", 1, 500000, "skd", "2017/03/18"));
			goodsList.add(new Goods("갤럭시 S7팔아요", "6개월 사용", "삼성", 2, 450000, "ksw", "2017/03/20"));
			goodsList.add(new Goods("G5", "1년 사용했습니다.", "LG", 3, 300000, "skd", "2017/03/19"));
			goodsList.add(new Goods("iphone 7", "3개월째 사용 중", "Apple", 4, 600000, "skd", "2017/03/23"));

			// goodsList.get(0).getTitle().length()

			
			tmp.add("이것은");
			tmp.add("게시판의");
			tmp.add("텍스트 표시 기능을");
			tmp.add("테스트 하기 위한");
			tmp.add("내용입니다.");
			
			goodsList.add(new Goods());
			goodsList.get(4).setTitle("소니 엑스페리아는 아직 죽지 않았다구요");
			goodsList.get(4).setNumber(5);
			goodsList.get(4).setPrice(500000);
			goodsList.get(4).setSeller("skd");
			goodsList.get(4).setContent(tmp);
			
			while (true) {
				System.out.println("판매하실 기기의 제조사를 선택해주세요.");
				System.out.println("1. 삼성 / 2. Apple / 3. LG / 4. 팬택 / 5. Sony / 6. 이외 기타 제조사");
				try {
					num = sc.nextInt();
					if(num == 1){
						goodsList.get(4).setCompany("삼성");
						break;
					}else if(num == 2){
						goodsList.get(4).setCompany("Apple");
						break;
					}else if(num == 3){
						goodsList.get(4).setCompany("LG");
						break;
					}else if(num == 4){
						goodsList.get(4).setCompany("팬택");
						break;
					}else if(num == 5){
						goodsList.get(4).setCompany("Sony");
						break;
					}else if(num == 6){
						goodsList.get(4).setCompany("기타");
						break;
					}else{
						System.out.println("표시된 범위 내에서 선택해주세요.");
					}
				} catch (InputMismatchException e) {
					// TODO: handle exception
					System.out.println("번호로 선택해주세요.");	
					sc.nextLine();					
				}
			}		
			vg.viewGoods(goodsList.get(4));
		}
	}
}
