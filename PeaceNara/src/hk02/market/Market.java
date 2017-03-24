package hk02.market;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import hk02.goods.Goods;
import hk02.user.User;

public class Market {
	private ArrayList<Goods> goodsList; // 총 상품리스트
	// private MyPage myPage = new MyPage();

	public Market() { // 마켓 생성시 더미 항목들 입력.
		int cnt = 1;
		goodsList = new ArrayList<Goods>(); // 총 상품리스트
		goodsList.add(new Goods("V20", "가개통", "LG-F800K", "LG", cnt++, 500000, "skd", "2017/03/23"));
		goodsList.add(new Goods("갤럭시 S7", "6개월 사용", "SM-G930S", "삼성", cnt++, 450000, "ksw", "2017/03/20"));
		goodsList.add(new Goods("G5", "1년 사용", "G5", "LG-F700S", cnt++, 300000, "skd", "2017/03/19"));
		goodsList.add(new Goods("iphone 7", "3개월 사용", "iPhone 7", "Apple", cnt++, 600000, "skd", "2017/03/23"));

	}

	public void helloMarket() {
		Scanner scan = new Scanner(System.in);
		System.out.println("\n*-PeaceNara에 오신걸 환영합니다.-*");
		Menu.helloMenuPrint();

		while (true) {
			System.out.println("\n>> 보고싶거나 하고싶은 번호를 입력해주세요.");
			try {
				int input = scan.nextInt();
				switch (input) {
				case 1:
					allGoodsListPrint();
					break;
				case 2:
					buy();
					break;
				case 3:
					sell();
					break;
				case 4:
					// page.myPageMenu();
					System.out.println("미구현");
					break;
				case 5:
					// logout();
					System.out.println("미구현");
					break;
				default:
					System.out.println("번호는 1~5까지만 있습니다.. 다시입력해주세요.");
					break;
				}
			} catch (InputMismatchException e) {
				scan.nextLine();
				System.out.println("번호만 입력해주세요.");
			}
		}
	}

	public void allGoodsListPrint() {
		System.out.println("--물품 목록-----------------------------------------------------------------");
		System.out.println(" 번호  제품명     가격   판매자     날짜         상태");
		System.out.println("============================================================================");
		for (int i = goodsList.size() - 1; i >= 0; i--) { // 역순으로 게시글을 보이게함.(최신글
															// 순.)
			System.out.println(goodsList.get(i));
		}
		System.out.println("----------------------------------------------------------------------------");
	}

	public void sellGoodsListPrint() {
		System.out.println("--물품 목록-----------------------------------------------------------------");
		System.out.println(" 번호  제품명     가격   판매자     날짜         상태");
		System.out.println("============================================================================");
		for (int i = goodsList.size() - 1; i >= 0; i--) { // 역순으로 게시글을 보이게함.(최신글
															// 순.)
			if (goodsList.get(i).getStock().equals("판매중")) {
				System.out.println(goodsList.get(i));
			}
		}
		System.out.println("----------------------------------------------------------------------------");
	}

	public void buy() {
		// user 객체로 buylist를 불러온다.
		// 현재 임시로 user 객체를 생성
		Scanner scan = new Scanner(System.in);

		sellGoodsListPrint();
		Menu.buyMenuPrint();
		try {
			int input = scan.nextInt();
			switch (input) {
			case 1: // 아래 상황을 buy를 오버로딩해서 사용하고 case 1: 메소드명. 만 적을 계획.
				myBuy();
			case 2:
				helloMarket();
				break;

			default:
				System.out.println("번호는 1~2까지만 있습니다.. 다시입력해주세요.");
				buy();
				break;
			}
		} catch (InputMismatchException e) {
			scan.nextLine();
			System.out.println("숫자만 입력해주세요.\n");
			buy();
		}

	}

	public void myBuy() {
		Scanner scan = new Scanner(System.in); // 지역변수로 써서 메소드 호출이후 메모리에서
												// 삭제시키기위함.
		User user = new User("kyungss", "1234", 1000000);

		while (true) {
			try {
				System.out.println("@ 구매하실 물품번호를 입력해주세요.");
				int goodsNum = scan.nextInt();

				if (goodsNum <= goodsList.size() && goodsNum > 0
						&& user.getBalance() >= goodsList.get(goodsNum - 1).getPrice()
						&& goodsList.get(goodsNum - 1).getStock().equals("판매중")) {

					user.setBalance(user.getBalance() - goodsList.get(goodsNum - 1).getPrice());
					user.setBuyGoodsList(goodsList, (goodsNum - 1));
					goodsList.get(goodsNum - 1).setStock(false);

				} else if (goodsNum > goodsList.size() || goodsNum <= 0) {
					System.out.println("물품번호를 다시 확인하여 주십시오.\n"); // 4번 안됨

				} else if (goodsList.get(goodsNum - 1).getStock().equals("판매완료")) {
					System.out.println("판매가 완료된 제품입니다.\n");

				} else if (user.getBalance() < goodsList.get(goodsNum - 1).getPrice()) {
					System.out.println(goodsList.get(goodsNum - 1).getTitle() + "을 구매하시기에 소지하신 금액이 "
							+ (goodsList.get(goodsNum - 1).getPrice() - user.getBalance()) + " 원 만큼 부족합니다.\n");
				}

				System.out.println("소지하신 금액은 " + user.getBalance() + " 원 입니다.\n");
				scan.nextLine(); // 다음 scanner 사용을 위해 다음커서 이동

			} catch (InputMismatchException e) {
				scan.nextLine();
				System.out.println("숫자만 입력해주세요.");
				// 이부분에서 main으로 돌아가지 읺게 만들어야함
			}

			catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}

			System.out.println("\n내가 구매한 목록 -----------------------------------------------------------");
			for (int i = user.getBuyGoodsList().size() - 1; i >= 0; i--) {
				System.out.println(user.getBuyGoodsList().get(i)); // 최신순 출력
			}
			System.out.println("----------------------------------------------------------------------------");

			System.out.println("쇼핑을 계속 하시겠습니까 ? (Y/N)");
			String process = scan.nextLine();
			if (process.equals("N") || process.equals("n")) {
				break;
			} else if (process.equals("Y") || process.equals("y")) {
				sellGoodsListPrint();
			} else {
				System.out.println("잘못입력하셨습니다. main으로 돌아갑니다.");
				break;
			}
		}
	}

	public void sell(/* 유저가들어옴 */) {
		Scanner scan = new Scanner(System.in); // 지역변수로 써서 메소드 호출이후 메모리에서
												// 삭제시키기위함.

		// 자신이 구매한 내역에서 올릴것인지 새로운 것을 올릴 것인지 선택 후
		// 진행하는 방향도 생각중에 있음.

		goodsList.add(new Goods());

		System.out.println("--------------------------------------");
		System.out.println("* 제목을 입력해주세요.");
		String input = scan.nextLine();
		System.out.println("======================================");
		goodsList.get(goodsList.size() - 1).setTitle(input);

		// System.out.println("내용을 입력해주세요.");
		// temp= scan.nextLine();
		// goodsList.get(goodsList.size()-1).setContent(temp);

		// System.out.println("모델명을 입력해주세요.");
		// temp= scan.nextLine();
		// goodsList.get(goodsList.size()-1).setModel(temp);

		goodsList.get(goodsList.size() - 1).setNumber(goodsList.size());

		while (true) {
			try {
				System.out.println("--------------------------------------");
				System.out.println("* 가격을 입력해주세요.");
				input = scan.nextLine();
				System.out.println("======================================");
				goodsList.get(goodsList.size() - 1).setPrice(Integer.parseInt(input));
				break;
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("\n!- 숫자로 입력해주세요.\n");
			}
		}

		System.out.println("--------------------------------------");
		System.out.println("* 판매자 명을 입력해주세요.");
		input = scan.nextLine();
		System.out.println("======================================");
		goodsList.get(goodsList.size() - 1).setSeller(input);
		// goodsList.get(goodsList.size() - 1).setSeller(user.getName 예정);

		// allGoodsListPrint();

	}
}
