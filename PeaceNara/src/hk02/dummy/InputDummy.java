package hk02.dummy;

import hk02.goods.Goods;
import hk02.logSystem.Membership;
import hk02.market.Market;
import hk02.user.User;

public class InputDummy {
	public void inputDummy(){
		
		// 사용자
		Membership.userList.add(new User("skd8668","1234","010-9646-8668"));
		Membership.userList.add(new User("ksw1234","1234","010-0000-0000"));
		Membership.userList.add(new User("yks1234","1234","010-0000-0000"));
		Membership.userList.add(new User("jhrrr","a123123","010-0000-0000"));
		
		// 물품		
		Market.goodsList.add(new Goods("4개월된 V20실버 판매합니다. +베터리세트"	,"작년 11월에 구입한 SKT V20 실버입니다.\n"
				+" 실사용 했고 케이스 없이 사용을 해서\n"
				+" 사용감이 다소 있습니다.\n\n"

				+" 그 외 문제는 일체 없습니다.\n"
				+" 액정도 쭉 스티커 붙이고 사용해와서\n"
				+" 완전 쌔거네요.\n\n\n"


				+" 박스도 있긴 한데, 저희집 개가 물어 뜯어서;;\n"
				+" 상태가 좋지 않습니다. 꼭 필요하시면 드릴게요.\n"

				+" 구성은\n\n"

				+" 휴대폰+ 베터리팩 + 사은품 블루투스 스피커 + 충전기\n\n"

				+" 이렇게입니다. 이어폰도 강아지가 씹어먹었어요..... ㅜ\n"

				+" 선택약정 가능한 기기입니다.\n"
				+" 감사합니다.\n"

				+" 네고 거절하고\n"
				+" 택배거래시 착불로 보내드립니다.\n"

				+" 평일 7시까지는 종각역 종로3가역 거래 가능하고\n"
				+" 그 이외 시간은 중곡역 거래 희망합니다.\n\n\n"


				+" 꼼꼼히 보시고 연락주세요.\n"
				+" 분명하게 말씀드리지만 상태 좋은 편 아닙니다 !\n"
				+" 다만 액정은 완벽하게 깨끗하고(보호필름 부착)\n"
				+" 내부적으로는 아무 문제 없습니다.\n\n"

				+" 합리적인 가격이라고 생각합니다.\n", "LG", 384000, "박상병", "010-0000-0000", "2017/03/27"));	
		
		Market.goodsList.add(new Goods("아이폰6s 64 팝니다","","Apple", 350000, "행불7시간그네", "010-0000-0000", "2017/03/28"));
		Market.goodsList.add(new Goods("G4 화이트,브라운 팝니다","","LG", 90000, "우리모바일x중앙역", "010-0000-0000", "2017/03/28"));
		Market.goodsList.add(new Goods("갤럭시 s7 핑크 블로섬","","삼성", 390000, "베르들레", "010-0000-0000", "2017/03/28"));
		Market.goodsList.add(new Goods("G3 비트 A급","","LG", 60000, "tjqltmrkdlq", "010-0000-0000", "2017/03/28"));
		Market.goodsList.add(new Goods("정상해지 kt g5 티탄팝니다.","","LG", 275000, "폭주토끼", "010-0000-0000", "2017/03/28"));
		Market.goodsList.add(new Goods("갤럭시 노트3 네오 판매합니다. U+","","삼성", 80000, "물먹는하마!", "010-0000-0000", "2017/03/28"));
		Market.goodsList.add(new Goods("미맥스 골드 64기가 팝니다.","","기타", 220000, "코카콜라마시따", "010-0000-0000", "2017/03/28"));
		Market.goodsList.add(new Goods("소니 엑스페리아Z3 32기가 퍼플 - 풀박","","Sony", 180000, "라꼬스떼", "010-0000-0000", "2017/03/28"));
		Market.goodsList.add(new Goods("스카이 im-100 팝니다","","팬택", 100000, "Dopeman", "010-0000-0000", "2017/03/28"));		
		
	}
}
