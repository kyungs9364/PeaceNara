package hk02.goods;

public class ViewGoods {
	public void viewGoods(Goods goods) { 
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println(" 물품번호 : " + goods.getNumber());
		System.out.println(" 제    목 : " + goods.getTitle());
		System.out.print(" 게 시 자 : " + goods.getSeller());
		System.out.println("\t\t\t\t\t 게 시 일 : " + goods.getTime() + " " + goods.getTime2());
		System.out.print(" 연 락 처 : " + goods.getCellPhone());
		System.out.println("\t\t\t\t 상    태 : " + goods.getStock());
		System.out.println("----------------------------------------------------------------------------------------------");
		for (int i = 0; i < goods.content.size(); i++) {
			System.out.println(" "+goods.content.get(i));
		}
		System.out.println();
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.print(" 가    격 : " + goods.getPrice()+" 원");		
		System.out.println("\t\t\t\t\t 제 조 사 : " + goods.getCompany());
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println();
	}
}
