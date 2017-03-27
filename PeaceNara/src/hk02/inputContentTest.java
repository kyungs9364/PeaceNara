package hk02;

import java.util.ArrayList;
import java.util.Scanner;

import hk02.goods.Goods;
import hk02.goods.ViewGoods;



public class inputContentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Goods> goodsList = new ArrayList<Goods>();
		ArrayList<String> textTmp = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		ViewGoods vg = new ViewGoods();
		
		int cnt = 0;

		goodsList.add(new Goods());

		goodsList.get(0).setTitle("팝니다");
		goodsList.get(0).setModel("LG V20");
		goodsList.get(0).setNumber(1);
		goodsList.get(0).setPrice(500000);
		goodsList.get(0).setSeller("송금동");
		goodsList.get(0).setCompany("LG");
		
		System.out.println("내용을 입력해 주세요");
		while (true) {
			System.out.println();
			System.out.println((cnt+1)+"번째 줄입니다.");
			System.out.print("xx = 입력 완료");
			System.out.print(" // yy = 이전 행 삭제");
			System.out.println(" // zz = 내용 전체 삭제 후 새로 입력");
			
			textTmp.add(sc.nextLine());
			if(textTmp.get(cnt).toLowerCase().equals("xx")){
				textTmp.remove(cnt);
				System.out.println();
				for(int i=0;i<textTmp.size();i++){
					System.out.println(textTmp.get(i));
				}
				System.out.println("입력하신 내용으로 저장하시려면 Y를 입력해주세요.");
				if(sc.nextLine().toLowerCase().equals("y")){
					break;			
				}else{
					continue;
				}
			}else if(textTmp.get(cnt).toLowerCase().equals("yy")){
				try {
					textTmp.remove(cnt);
					textTmp.remove(--cnt);
					continue;
				} catch (ArrayIndexOutOfBoundsException aioobe) {
					// TODO: handle exception
					System.out.println("삭제할 내용이 없습니다.");
					cnt=0;					
					continue;
				}				
			}else if(textTmp.get(cnt).toLowerCase().equals("zz")){
				textTmp.clear();
				cnt=0;
				continue;
			}
			cnt++;			
		}
		goodsList.get(0).setContent(textTmp);
		
		vg.viewGoods(goodsList.get(0));
	}

}
