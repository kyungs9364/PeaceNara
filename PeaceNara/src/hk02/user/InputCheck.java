package hk02.user;

import java.util.Scanner;

public class InputCheck {
	
	// Scanner로 String으로 입력받아서 int반환 (유효성검사: 1, 2, 3)
	public static int input123(){
		Scanner scan = new Scanner(System.in);
		String tmp = null;
		int result = 0;
		while(true) {
			System.out.print("> ");
			tmp = scan.next().trim();
			if(tmp.matches("[1234]")){
				result = Integer.parseInt(tmp);
				break;
			}else{
				System.out.println("잘못 입력하셨습니다.");
				System.out.println("원하는 메뉴의 번호를 입력해주세요.");
				continue;
			}
		}
		return result;
	}
	
	// Scanner로 String으로 입력받아서 int반환 (유효성검사: 1, 2, 3, 4)
	public static int input1234(){
		Scanner scan = new Scanner(System.in);
		String tmp = null;
		int result = 0;
		while(true) {
			System.out.print("> ");
			tmp = scan.next().trim();
			if(tmp.matches("[1234]")){
				result = Integer.parseInt(tmp);
				break;
			}else{
				System.out.println("잘못 입력하셨습니다.");
				System.out.println("원하는 메뉴의 번호를 입력해주세요.");
				continue;
			}
		}
		return result;
	}
}
