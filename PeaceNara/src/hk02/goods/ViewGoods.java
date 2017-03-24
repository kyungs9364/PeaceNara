package hk02.goods;

public class ViewGoods {
	public void viewGoods(Goods goods){		
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("물품 번호 : "+goods.getNumber());
		System.out.print(" 제    목 : "+goods.getTitle());
		System.out.println("\t\t\t\t 게 시 일 : "+goods.getTime()+" "+goods.getTime2());
		System.out.print(" 게 시 자 : "+goods.getSeller	());
		System.out.println("\t\t\t\t\t 상    태 : "+goods.getStock());		
		System.out.println("----------------------------------------------------------------------------");
		System.out.println(" 내    용 : "+goods.getContent());
		System.out.println("----------------------------------------------------------------------------");
		System.out.print(" 가    격 : "+goods.getPrice());
		System.out.print("\t\t\t 기    종 : "+goods.getModel());
		System.out.println("\t 제 조 사 : "+goods.getCompany());
		System.out.println("----------------------------------------------------------------------------");
		System.out.println();
	}
}
