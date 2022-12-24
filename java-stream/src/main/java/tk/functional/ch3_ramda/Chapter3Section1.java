package tk.functional.ch3_ramda;

import java.util.function.Function;

import tk.functional.ch3_ramda.util.Adder;

public class Chapter3Section1 {

	public static void main(String[] args) {
		Function<Integer, Integer> myAdder = new Adder();
		int result = myAdder.apply(5);
		System.out.println(result);
	}

}
