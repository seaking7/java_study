package tk.functional.chapter10.deco;

import tk.functional.chapter10.model.Price;

public class BasicPriceProcessor implements PriceProcessor {

	@Override
	public Price process(Price price) {
		return price;
	}

}
