package tk.functional.ch10_designPattern.price;

import tk.functional.ch10_designPattern.model.Price;

public class DiscountPriceProcessor implements PriceProcessor {

	@Override
	public Price process(Price price) {
		return new Price(price.getPrice() + ", then applied discount");
	}

}
