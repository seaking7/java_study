package tk.functional.ch10_designPattern;

import tk.functional.ch10_designPattern.model.Price;
import tk.functional.ch10_designPattern.price.BasicPriceProcessor;
import tk.functional.ch10_designPattern.price.DiscountPriceProcessor;
import tk.functional.ch10_designPattern.price.PriceProcessor;
import tk.functional.ch10_designPattern.price.TaxPriceProcessor;

public class Ch10_2_DecoratorPattern {

	public static void main(String[] args) {
		Price unprocessedPrice = new Price("Original Price");
		
		PriceProcessor basicPriceProcessor = new BasicPriceProcessor();
		PriceProcessor discountPriceProcessor = new DiscountPriceProcessor();
		PriceProcessor taxPriceProcessor = new TaxPriceProcessor();
		
		PriceProcessor decoratedPriceProcessor = basicPriceProcessor
			.andThen(discountPriceProcessor)
			.andThen(taxPriceProcessor);
		Price processedPrice = decoratedPriceProcessor.process(unprocessedPrice);
		System.out.println(processedPrice.getPrice());
		
		PriceProcessor decoratedPriceProcessor2 = basicPriceProcessor
				.andThen(taxPriceProcessor)
				.andThen(price -> new Price(price.getPrice() + ", then apply another procedure"));
		Price processedPrice2 = decoratedPriceProcessor2.process(unprocessedPrice);
		System.out.println(processedPrice2.getPrice());
	}

}
