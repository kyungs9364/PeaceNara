package hk02.market;

import java.util.InputMismatchException;
import java.util.Scanner;

import hk02.logSystem.Membership;
import hk02.user.MyPage;
import hk02.user.User;

public class Menu {
	MyPage page = new MyPage();
	Membership mbs = new Membership();  // 여기서 한번 더 객체를 생성하는데 괜찮은지 생각해보기.
	
	
	public void marketMenuEvent(Market market, User user){
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("*----------------------------------------=PeaceNara=-----------------------------------------*");
			System.out.println("\t1.모든 물품정보     2.물품사기     3.물품판매     4.MyPage     5.Logout");
			System.out.println("*--------------------------------------------------------------------------------------------*");
			
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
					if(!(page.myPage(user))){
						mbs.memberMenu(market);
					}
					break;
				case 5:
					System.out.println("->'"+user.getId() +"' 님은 로그아웃되셨습니다..\n"); 
					mbs.memberMenu(market);
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
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("\t1.구매하실 물품 번호 입력     2.물품상세정보     3.이전 메뉴");
		System.out.println("----------------------------------------------------------------------------------------------");
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
		
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("\t1.물품상세정보 열람     2.제조사 검색     3.이전 메뉴");
		System.out.println("----------------------------------------------------------------------------------------------");

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
				market.searchGoods(user);
			case 3:
				market.helloMarket(user);
				break;

			default:
				System.out.println("번호는 1~3까지만 있습니다.. 다시입력해주세요.");
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
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("\t1.물품 바로구매     2.취소");
		System.out.println("----------------------------------------------------------------------------------------------");

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
