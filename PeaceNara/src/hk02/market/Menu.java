package hk02.market;

import java.util.InputMismatchException;
import java.util.Scanner;

import hk02.user.MyPage;
import hk02.user.User;

public class Menu {
	MyPage page = new MyPage();
	
	
	public void marketMenuEvent(Market market, User user){
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("*-------------------------------------=PeaceNara=--------------------------------------*");
			System.out.println("\t1.모든 물품정보\t2.물품사기\t3.물품판매\t4.MyPage\t5.Logout");
			System.out.println("*--------------------------------------------------------------------------------------*");
			
			System.out.println("\n>> 보고싶거나 하고싶은 번호를 입력해주세요.");
			try {
				int input = scan.nextInt();
				switch (input) {
				case 1:
					goodsMenu(market,user);
					break;
				case 2:
					market.buyMenuOpen(user);
					break;
				case 3:
					market.sell(user);
					break;
				case 4:
					page.myPage(user);
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
	
	public void buyMenu(Market market, User user){
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("\t1.구매하실 물품 번호 입력\t2.물품상세정보\t\t3.Main");
		System.out.println("-------------------------------------------------------------------------------");
		buyMenuEvent(market,user);
	}
	
	public void buyMenuEvent(Market market, User user){
		Scanner scan = new Scanner(System.in);
		
		try {
			int input = scan.nextInt();
			switch (input) {
			case 1: // 아래 상황을 buy를 오버로딩해서 사용하고 case 1: 메소드명. 만 적을 계획.
				market.buy(user);
				break;
			case 2: 
				market.viewGoodsDetails(user);
				break;
			case 3:
				market.helloMarket(user);
				break;

			default:
				System.out.println("번호는 1~3까지만 있습니다.. 다시입력해주세요.");
				buyMenu(market,user);
				break;
			}
		} catch (InputMismatchException e) {
			scan.nextLine();
			System.out.println("숫자만 입력해주세요.\n");
			buyMenu(market,user);
		}
	}
	
	public void goodsMenu(Market market,User user){
		market.allGoodsListPrint();
		
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("\t1.물품상세정보열람\t2.Main");
		System.out.println("-------------------------------------------------------------------------------");

		goodsMenuEvent(market,user);
	}
	
	public void goodsMenuEvent(Market market, User user){
		Scanner scan = new Scanner(System.in);
		
		try {
			int input = scan.nextInt();
			switch (input) {
			case 1: 
				market.allViewGoodsDetails(user);
			case 2:
				market.helloMarket(user);
				break;

			default:
				System.out.println("번호는 1~2까지만 있습니다.. 다시입력해주세요.");
				goodsMenu(market,user);
				break;
			}
		} catch (InputMismatchException e) {
			scan.nextLine();
			System.out.println("숫자만 입력해주세요.\n");
			market.buy(user);
		}
	}
	
	public void goodsMenuDetailsBuy(Market market,User user,int num){
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("\t1.상품 바로구매\t2.취소");
		System.out.println("-------------------------------------------------------------------------------");

		goodsMenuDetailsBuyEvent(market,user,num);
	}
	public void goodsMenuDetailsBuyEvent(Market market, User user, int num){
		Scanner scan = new Scanner(System.in);
		
		try {
			int input = scan.nextInt();
			switch (input) {
			case 1: 
				market.directBuy(user,num);
			case 2:
				goodsMenu(market,user);
				break;

			default:
				System.out.println("번호는 1~2까지만 있습니다.. 다시입력해주세요.");
				goodsMenuDetailsBuy(market,user,num);
				break;
			}
		} catch (InputMismatchException e) {
			scan.nextLine();
			System.out.println("숫자만 입력해주세요.\n");
			goodsMenuDetailsBuy(market,user,num);
		}
	}

}
