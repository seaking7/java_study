package tk.functional.chapter10.deco;

import tk.functional.chapter10.model.Price;

@FunctionalInterface
public interface PriceProcessor {
	Price process(Price price);
	
	default PriceProcessor andThen(PriceProcessor next) {
		return price -> next.process(process(price));
	}
}
