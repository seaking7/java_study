package tk.functional.ch8_streamEnding;

import java.util.Optional;
import java.util.stream.Stream;

public class Ch8_3_FindAny {

	public static void main(String[] args) {
		Optional<Integer> anyNegativeInteger = Stream.of(3, 2, -5, 6)
			.filter(x -> x < 0)
			.findAny();
		System.out.println(anyNegativeInteger.get());
		
		Optional<Integer> firstPositiveInteger = Stream.of(3, 2, -5, 6)
			.filter(x -> x > 0)
			.findFirst();
		System.out.println(firstPositiveInteger.get());
	}

}
