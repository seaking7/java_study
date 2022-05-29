package tk.functional.ch10_designPattern.price;

import tk.functional.ch10_designPattern.model.Price;

public class BasicPriceProcessor implements PriceProcessor {

	@Override
	public Price process(Price price) {
		return price;
	}

}
