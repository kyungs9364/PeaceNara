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
					market.allGoodsListPrint();
					goodsMenu(market);
					break;
				case 2:
					market.buyMenuOpen();
					break;
				case 3:
					market.sell();
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
	
	public void buyMenu(Market market){
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("\t1.구매하실 물품 번호 입력\t2.물품상세정보\t\t3.Main");
		System.out.println("------------------------------------------------------------------------------");
		buyMenuEvent(market);
	}
	
	public void buyMenuEvent(Market market){
		Scanner scan = new Scanner(System.in);
		
		try {
			int input = scan.nextInt();
			switch (input) {
			case 1: // 아래 상황을 buy를 오버로딩해서 사용하고 case 1: 메소드명. 만 적을 계획.
				market.buy();
				break;
			case 2: 
				market.viewGoodsDetails();
				break;
			case 3:
				market.helloMarket();
				break;

			default:
				System.out.println("번호는 1~3까지만 있습니다.. 다시입력해주세요.");
				buyMenu(market);
				break;
			}
		} catch (InputMismatchException e) {
			scan.nextLine();
			System.out.println("숫자만 입력해주세요.\n");
			buyMenu(market);
		}
	}
	
	public void goodsMenu(Market market){
		System.out.println("------------------------------------------------------------------------");
		System.out.println("\t1.물품상세정보열람\t2.Main");
		System.out.println("------------------------------------------------------------------------");

		goodsMenuEvent(market);
	}
	
	public void goodsMenuEvent(Market market){
		Scanner scan = new Scanner(System.in);
		
		try {
			int input = scan.nextInt();
			switch (input) {
			case 1: 
				market.allViewGoodsDetails();;
			case 2:
				market.helloMarket();
				break;

			default:
				System.out.println("번호는 1~2까지만 있습니다.. 다시입력해주세요.");
				market.buy();
				break;
			}
		} catch (InputMismatchException e) {
			scan.nextLine();
			System.out.println("숫자만 입력해주세요.\n");
			market.buy();
		}
	}

}
