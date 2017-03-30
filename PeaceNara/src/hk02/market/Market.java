package hk02.market;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import hk02.goods.Goods;
import hk02.goods.ViewGoods;
import hk02.logSystem.Membership;
import hk02.user.User;

public class Market {
	public static ArrayList<Goods> goodsList = new ArrayList<Goods>();; // 총 상품리스트
	Menu menu = new Menu();
	ViewGoods vg = new ViewGoods();

	public Market() { // 마켓 생성시 더미 항목들 입력.
		int cnt = 1;
		goodsList.add(new Goods("V20 판매합니다", "가개통", "LG", 1, 500000, "skd123", "2017/03/23"));
		goodsList.add(new Goods("갤럭시 S7사실분?", "6개월 사용", "삼성", 2, 450000, "ksw123", "2017/03/20"));
		goodsList.add(new Goods("G5 초저가 땡처리!", "1년 사용", "LG", 3, 300000, "skd123", "2017/03/19"));
		goodsList.add(new Goods("iphone 7는 진리.", "3개월 사용", "Apple", 4, 600000, "skd123", "2017/03/23"));

	}

	public void helloMarket(User user) {
		System.out.println("\n*-PeaceNara에 오신걸 환영합니다.-*");
		menu.marketMenuEvent(this, user);

	}

	public void buyMenuOpen(User user) {
		sellGoodsListPrint(user);
		menu.buyMenu(this, user);

	}
	
	public void searchGoods(User user){
		Scanner scan = new Scanner(System.in); // 지역변수로 써서 메소드 호출이후 메모리에서
		// 삭제시키기위함.

		System.out.println("검색하실 제조사를 선택해주세요.");
		System.out.println("1. 삼성 / 2. Apple / 3. LG / 4. 팬택 / 5. Sony / 6. 이외 기타 제조사");
		int num = 0;
		
		
		try {
			num = scan.nextInt();
			
			System.out.println("--물품 목록--------------------------------------------------------------------");
			System.out.println(" No\t게시글명\t  가격\t    판매자\t\t   날짜\t\t 상태");
			System.out.println("===============================================================================");
			
			if(num == 1){
				for (int i = 0; i < goodsList.size(); i++) {
					if ("삼성".equals(goodsList.get(i).getCompany())) {  // 제조사가 같으면.
						System.out.println(goodsList.get(i));
					}
				}
			} else if(num == 2){
				for (int i = 0; i < goodsList.size(); i++) {
					if ("Apple".equals(goodsList.get(i).getCompany())) {  // 제조사가 같으면.
						System.out.println(goodsList.get(i));
					}
				}
			} else if(num == 3){
				for (int i = 0; i < goodsList.size(); i++) {
					if ("LG".equals(goodsList.get(i).getCompany())) {  // 제조사가 같으면.
						System.out.println(goodsList.get(i));
					}
				}
			} else if(num == 4){
				for (int i = 0; i < goodsList.size(); i++) {
					if ("팬택".equals(goodsList.get(i).getCompany())) {  // 제조사가 같으면.
						System.out.println(goodsList.get(i));
					}
				}
			} else if(num == 5){
				for (int i = 0; i < goodsList.size(); i++) {
					if ("Sony".equals(goodsList.get(i).getCompany())) {  // 제조사가 같으면.
						System.out.println(goodsList.get(i));
					}
				}
			} else if(num == 6){
				for (int i = 0; i < goodsList.size(); i++) {
					if ("기타".equals(goodsList.get(i).getCompany())) {  // 제조사가 같으면.
						System.out.println(goodsList.get(i));
					}
				}
			} else{
				System.out.println("표시된 범위 내에서 선택해주세요.");
			}
		} catch (InputMismatchException e) {
			// TODO: handle exception
			System.out.println("번호로 선택해주세요.");					
		}
		System.out.println("-------------------------------------------------------------------------------");
		

	}

	public void buy(User user) {

		Scanner scan = new Scanner(System.in); // 지역변수로 써서 메소드 호출이후 메모리에서
												// 삭제시키기위함.

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
					System.out.println("물품번호를 다시 확인하여 주십시오.\n"); 

				} else if (goodsList.get(goodsNum - 1).getStock().equals("판매완료")) {
					System.out.println("판매가 완료된 제품입니다.\n");

				} else if (user.getBalance() < goodsList.get(goodsNum - 1).getPrice()) {
					System.out.println(goodsList.get(goodsNum - 1).getTitle() + "을 구매하시기에 소지하신 금액이 "
							+ (goodsList.get(goodsNum - 1).getPrice() - user.getBalance()) + " 원 만큼 부족합니다.\n");
				}

				System.out.println("소지하신 금액은 " + user.getBalance() + " 원 입니다.\n");
				
				for (int i = 0; i < Membership.userList.size(); i++) {
					if(goodsList.get(goodsNum-1).getSeller().equals(Membership.userList.get(i).getId())){
						Membership.userList.get(i).setBalance(Membership.userList.get(i).getBalance() +goodsList.get(goodsNum-1).getPrice());
					}
				} // 판매가 되면 판매자에게 돈을 준다.
				
				scan.nextLine(); // 다음 scanner 사용을 위해 다음커서 이동

			} catch (InputMismatchException e) {
				scan.nextLine();
				System.out.println("숫자만 입력해주세요.");
			}

			catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}

			user.printBuyList();
			
			System.out.println("쇼핑을 계속 하시겠습니까 ? (Y/N)");
			String process = scan.nextLine();
			if (process.equals("N") || process.equals("n")) {
				break;
			} else if (process.equals("Y") || process.equals("y")) {
				sellGoodsListPrint(user);
			} else {
				System.out.println("잘못입력하셨습니다. main으로 돌아갑니다.");
				break;
			}
		}
	}
	
	public void directBuy(User user, int goodsNum){ 
		
		if (goodsList.get(goodsNum).getStock().equals("판매중") &&
				user.getBalance() >= goodsList.get(goodsNum).getPrice()) {

			user.setBalance(user.getBalance() - goodsList.get(goodsNum).getPrice());
			user.setBuyGoodsList(goodsList, (goodsNum));
			goodsList.get(goodsNum).setStock(false);
			System.out.println("구매해주셔서 감사합니다.");
			
			for (int i = 0; i < Membership.userList.size(); i++) {
				if(goodsList.get(goodsNum).getSeller().equals(Membership.userList.get(i).getId())){
					Membership.userList.get(i).setBalance(Membership.userList.get(i).getBalance() +goodsList.get(goodsNum).getPrice());
				}
			} // 판매가 되면 판매자에게 돈을 준다.

		} else if (goodsList.get(goodsNum).getStock().equals("판매완료")) {
			System.out.println("판매가 완료된 제품입니다.\n");

		} else if (user.getBalance() < goodsList.get(goodsNum).getPrice()) {
			System.out.println(goodsList.get(goodsNum).getTitle() + "을 구매하시기에 소지하신 금액이 "
					+ (goodsList.get(goodsNum).getPrice() - user.getBalance()) + " 원 만큼 부족합니다.\n");
		}

		System.out.println("소지하신 금액은 " + user.getBalance() + " 원 입니다.\n");
		
		menu.goodsMenu(this,user);
	}

	public void sell(User user) {
		Scanner scan = new Scanner(System.in); // 지역변수로 써서 메소드 호출이후 메모리에서
												// 삭제시키기위함.
		ArrayList<String> textTmp = new ArrayList<String>();
		int cnt = 0;  // 내용입력도우미 변수
		int num =0; // 제품사 입력 변수.
		
		goodsList.add(new Goods());
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("* 제목을 입력해주세요.");
		String input = scan.nextLine();
		System.out.println("============================================================================");
		goodsList.get(goodsList.size() - 1).setTitle(input);

		System.out.println("* 내용을 입력해 주세요");
		while (true) {
			System.out.println();
			System.out.println((cnt + 1) + "번째 행입니다.");
			System.out.print("xx = 입력 완료");
			System.out.print(" // yy = 이전 행 삭제");
			System.out.println(" // zz = 내용 전체 삭제 후 새로 입력");

			textTmp.add(scan.nextLine());
			if (textTmp.get(cnt).toLowerCase().equals("xx")) {
				textTmp.remove(cnt);
				System.out.println();
				for (int i = 0; i < textTmp.size(); i++) {
					System.out.println(textTmp.get(i));
				}
				System.out.println("입력하신 내용으로 저장하시려면 Y를 입력해주세요.");
				if (scan.nextLine().toLowerCase().equals("y")) {
					break;
				} else {
					continue;
				}
			} else if (textTmp.get(cnt).toLowerCase().equals("yy")) {
				try {
					textTmp.remove(cnt);
					textTmp.remove(--cnt);
					continue;
				} catch (ArrayIndexOutOfBoundsException aioobe) {
					// TODO: handle exception
					System.out.println("삭제할 내용이 없습니다.");
					cnt = 0;
					continue;
				}
			} else if (textTmp.get(cnt).toLowerCase().equals("zz")) {
				textTmp.clear();
				cnt = 0;
				continue;
			}
			cnt++;
		}
		goodsList.get(goodsList.size() - 1).setContent(textTmp);
		
		while (true) {
			System.out.println("판매하실 기기의 제조사를 선택해주세요.");
			System.out.println("1. 삼성 / 2. Apple / 3. LG / 4. 팬택 / 5. Sony / 6. 이외 기타 제조사");
			try {
				num = scan.nextInt();
				if(num == 1){
					goodsList.get(goodsList.size()-1).setCompany("삼성");
					break;
				}else if(num == 2){
					goodsList.get(goodsList.size()-1).setCompany("Apple");
					break;
				}else if(num == 3){
					goodsList.get(goodsList.size()-1).setCompany("LG");
					break;
				}else if(num == 4){
					goodsList.get(goodsList.size()-1).setCompany("팬택");
					break;
				}else if(num == 5){
					goodsList.get(goodsList.size()-1).setCompany("Sony");
					break;
				}else if(num == 6){
					goodsList.get(goodsList.size()-1).setCompany("기타");
					break;
				}else{
					System.out.println("표시된 범위 내에서 선택해주세요.");
				}
			} catch (InputMismatchException e) {
				// TODO: handle exception
				System.out.println("번호로 선택해주세요.");	
				scan.nextLine();					
			}
		}		
		
		goodsList.get(goodsList.size() - 1).setNumber(goodsList.size());
		scan.nextLine();  // 다음입력을 위해 커서이동.
		
		while (true) {
			try {
				System.out.println("----------------------------------------------------------------------------");
				System.out.println("* 가격을 입력해주세요.");
				input = scan.nextLine();
				System.out.println("============================================================================\n");
				goodsList.get(goodsList.size() - 1).setPrice(Integer.parseInt(input));
				break;
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("!- 숫자로 입력해주세요.\n");
			}
		}
		goodsList.get(goodsList.size() - 1).setSeller(user.getId());
		user.setSellGoodsList(goodsList, goodsList.size() - 1);

	}

	public void allGoodsListPrint() {
		System.out.println("--물품 목록--------------------------------------------------------------------");
		System.out.println(" No\t게시글명\t  가격\t    판매자\t\t   날짜\t\t 상태");
		System.out.println("===============================================================================");
		for (int i = goodsList.size() - 1; i >= 0; i--) { // 역순으로 게시글을 보이게함.(최신글
															// 순.)
			System.out.println(goodsList.get(i));
		}
		System.out.println("-------------------------------------------------------------------------------");

	}

	public void sellGoodsListPrint(User user) {
		System.out.println("--물품 목록--------------------------------------------------------------------");
		System.out.println(" No\t게시글명\t  가격\t    판매자\t\t   날짜\t\t 상태");
		System.out.println("===============================================================================");
		for (int i = goodsList.size() - 1; i >= 0; i--) { // 역순으로 게시글을 보이게함.(최신글
															// 순.)
			if (goodsList.get(i).getStock().equals("판매중")) {
				System.out.println(goodsList.get(i));
			}
		}
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++\t소지한 금액 : "+user.getBalance()+" 원");
		System.out.println("-------------------------------------------------------------------------------");
	}

	public void viewGoodsDetails(User user) {
		Scanner scan = new Scanner(System.in); // 지역변수로 써서 메소드 호출이후 메모리에서
												// 삭제시키기위함.
		System.out.println("--판매중인 물품의 상세정보를 보실 물품번호를 입력해주세요.------------------------------------");

		try {
			int goodsNum = scan.nextInt();
			if (goodsList.get(goodsNum - 1).getStock().equals("판매완료")) {
				System.out.println("판매가 되어 정보를 열람할수 없는 번호입니다.");
				System.out.println("정보를 열람하시려면 모든 물품정보 항목으로 들어가주세요.\n");
				menu.buyMenu(this, user);
			}
			vg.viewGoods(goodsList.get(goodsNum - 1));
			menu.buyMenu(this, user);

		} catch (InputMismatchException e) {
			scan.nextLine();
			System.out.println("숫자만 입력해주세요.\n");
			viewGoodsDetails(user);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("\n물품의 정보가 존재하지 않습니다.. 돌아갑니다.-\n");
			menu.buyMenu(this, user);
		}

		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

	public void allViewGoodsDetails(User user) {
		Scanner scan = new Scanner(System.in); // 지역변수로 써서 메소드 호출이후 메모리에서
												// 삭제시키기위함.
		System.out.println("--상세정보를 보실 물품번호를 입력해주세요.--------------------------------------");


		try {
			int goodsNum = scan.nextInt();
			vg.viewGoods(goodsList.get(goodsNum - 1));
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++\t소지한 금액 : "+user.getBalance()+" 원");
			menu.goodsMenuDetailsBuy(this, user, goodsNum-1);

		} catch (InputMismatchException e) {
			scan.nextLine();
			System.out.println("숫자만 입력해주세요.\n");
			allViewGoodsDetails(user);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("\n물품의 정보가 존재하지 않습니다.. 돌아갑니다.-\n"); // 물품이 없을 경우를 대비.
			menu.goodsMenu(this, user);
		}

		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}
