package tk.functional.ch10_designPattern.price;

import tk.functional.ch10_designPattern.model.Price;

@FunctionalInterface
public interface PriceProcessor {
	Price process(Price price);
	
	default PriceProcessor andThen(PriceProcessor next) {
		return price -> next.process(process(price));
	}
}
