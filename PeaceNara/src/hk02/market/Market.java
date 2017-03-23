package hk02.market;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import hk02.goods.Goods;
import hk02.user.User;

public class Market {
	private ArrayList<Goods> goodsList = new ArrayList<Goods>(); // 총 상품리스트

	public Market() { // 마켓 생성시 더미 항목들 입력.
		int cnt = 1;
		goodsList.add(new Goods("V20", "가개통", "LG-F800K", "LG", cnt++, 500000, "skd", "2017/03/23"));
		goodsList.add(new Goods("갤럭시 S7", "6개월 사용", "SM-G930S", "삼성", cnt++, 450000, "ksw", "2017/03/23"));
		goodsList.add(new Goods("G5", "1년 사용", "G5", "LG-F700S", cnt++, 300000, "skd", "2017/03/23"));
		goodsList.add(new Goods("iphone 7", "3개월 사용", "iPhone 7", "Apple", cnt++, 600000, "skd", "2017/03/23"));

	}

	public void goodsListPrint() {

		for (Goods goods : goodsList) {
			System.out.println(goods);
		}

	}

	public void buy(/* 유저가들어옴 */) {
		// user 객체로 buylist를 불러온다.
		// 현재 임시로 user 객체를 생성
		User user = new User("kyungss", "1234", 1000000);
		Scanner scan = new Scanner(System.in); // 지역변수로 써서 메소드 호출이후 메모리에서
												// 삭제시키기위함.

		goodsListPrint();

		for (int i = 0; i < 2; i++) {
			System.out.println("\n구매할 물품 번호를 입력해주세요.");

			try {
				int goodsNum = scan.nextInt();

				if (goodsNum < goodsList.size() && goodsNum > 0
						&& user.getBalance() >= goodsList.get(goodsNum - 1).getPrice()) {
					user.setBalance(user.getBalance() - goodsList.get(goodsNum - 1).getPrice());
					user.setBuyGoodsList(goodsList, (goodsNum - 1));
					goodsList.remove(goodsNum - 1);
					
				} else if (goodsNum >= goodsList.size() || goodsNum <= 0) {
					System.out.println("물품번호를 다시 확인하여 주십시오.");
					
				} else if (user.getBalance() < goodsList.get(goodsNum - 1).getPrice()) {
					System.out.println(goodsList.get(goodsNum - 1).getTitle() + "을 구매하시기에 소지하신 금액이 "
							+ (goodsList.get(goodsNum - 1).getPrice() - user.getBalance()) + "만큼 부족합니다.\n");
				}

				System.out.println("소지하신 금액은 " + user.getBalance() + "\n");
				goodsListPrint();  // 현재 리스트가 제거되지 않고 잔여현상이 발생.
				
			} catch (InputMismatchException e) {
				scan.nextLine();
				System.out.println("숫자만 입력해주세요.");
			}

			catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
		}

		System.out.println("\n내가 구매한 목록 ------");
		for (Goods goods : user.getBuyGoodsList()) {
			System.out.println(goods);
		}
		System.out.println("------------------");

	}

	public void sell(/* 유저가들어옴 */) {
		Scanner scan = new Scanner(System.in); // 지역변수로 써서 메소드 호출이후 메모리에서
												// 삭제시키기위함.
		
		// 자신이 구매한 내역에서 올릴것인지 새로운 것을 올릴 것인지 선택 후
		// 진행하는 방향도 생각중에 있음.

		goodsList.add(new Goods());

		System.out.println("제목을 입력해주세요.");
		String input = scan.nextLine();
		goodsList.get(goodsList.size() - 1).setTitle(input);

		// System.out.println("내용을 입력해주세요.");
		// temp= scan.nextLine();
		// goodsList.get(goodsList.size()-1).setContent(temp);

		// System.out.println("모델명을 입력해주세요.");
		// temp= scan.nextLine();
		// goodsList.get(goodsList.size()-1).setModel(temp);

		goodsList.get(goodsList.size() - 1).setNumber(goodsList.size());

		System.out.println("가격을 입력해주세요.");
		input = scan.nextLine();
		goodsList.get(goodsList.size() - 1).setPrice(Integer.parseInt(input));

		System.out.println("판매자 명을 입력해주세요.");
		input = scan.nextLine();
		goodsList.get(goodsList.size() - 1).setSeller(input);
//		goodsList.get(goodsList.size() - 1).setSeller(user.getName 예정);

		goodsListPrint();

	}
}
