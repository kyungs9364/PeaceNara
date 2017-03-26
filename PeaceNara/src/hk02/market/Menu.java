package hk02.market;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	
	public void marketMenu(Market market){
		System.out.println("------------------------------------------------------------------------");
		System.out.println("\t1.물품정보\t2.물품사기\t3.물품판매\t4.MyPage\t5.Logout");
		System.out.println("------------------------------------------------------------------------");
		marketMenuEvent(market);
	}
	
	public void marketMenuEvent(Market market){
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("\n>> 보고싶거나 하고싶은 번호를 입력해주세요.");
			try {
				int input = scan.nextInt();
				switch (input) {
				case 1:
					market.allGoodsListPrint();
					break;
				case 2:
					market.buyMenuOpen();
					break;
				case 3:
					market.sell();
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
	
	public void buyMenu(Market market){
		System.out.println("------------------------------------------------------------------------");
		System.out.println("\t1.구매하실 물품 번호 입력\t2.Main");
		System.out.println("------------------------------------------------------------------------");
		buyMenuEvent(market);
	}
	
	public void buyMenuEvent(Market market){
		Scanner scan = new Scanner(System.in);
		
		try {
			int input = scan.nextInt();
			switch (input) {
			case 1: // 아래 상황을 buy를 오버로딩해서 사용하고 case 1: 메소드명. 만 적을 계획.
				market.buy();
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
