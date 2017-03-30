package hk02.main;

import hk02.dummy.InputDummy;
import hk02.goods.Goods;
import hk02.logSystem.Membership;
import hk02.market.Market;
import hk02.user.User;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InputDummy dummy = new InputDummy();
			
		Market market = new Market();
		Membership mbs = new Membership();	
		
		
		dummy.inputDummy();
		mbs.memberMenu(market);
		
	}

}
