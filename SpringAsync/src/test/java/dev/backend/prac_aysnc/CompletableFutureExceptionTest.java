package dev.backend.prac_aysnc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CompletableFutureExceptionTest {

	@ParameterizedTest
	@ValueSource(booleans =  {true, false})
	void exceptionally(boolean doThrow) throws ExecutionException, InterruptedException {
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			if (doThrow) {
				throw new IllegalArgumentException("Invalid Argument");
			}

			return "Thread: " + Thread.currentThread().getName();
		}).exceptionally(e -> {
			return e.getMessage();
		});

		System.out.println(future.get());
	}

	@ParameterizedTest
	@ValueSource(booleans =  {true, false})
	void handle(boolean doThrow) throws ExecutionException, InterruptedException {
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			if (doThrow) {
				throw new IllegalArgumentException("Invalid Argument");
			}

			return "Thread: " + Thread.currentThread().getName();
		}).handle((result, e) -> {
			return e == null
				? result
				: e.getMessage();
		});

		System.out.println(future.get());
	}

}
