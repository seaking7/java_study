package tk.functional.chapter10.service;

import tk.functional.chapter10.model.Price;

public class BasicPriceProcessor implements PriceProcessor {

	@Override
	public Price process(Price price) {
		return price;
	}

}
