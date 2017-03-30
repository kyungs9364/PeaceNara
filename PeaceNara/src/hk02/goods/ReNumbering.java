package hk02.goods;

import static hk02.market.Market.goodsList;

public class ReNumbering {
	public void reNumbering() {
		for (int i = 0; i < goodsList.size(); i++) {
			goodsList.get(i).setNumber(i+1);			
		}
	}
}
