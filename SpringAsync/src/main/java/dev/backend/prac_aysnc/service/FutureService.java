package dev.backend.prac_aysnc.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class FutureService {

	// 비동기 작업은 2초가 걸리나, 1초만 대기하여 Timeout 발생
	public void future_1() throws ExecutionException, InterruptedException, TimeoutException {


		CompletableFuture<String> completableFuture = new CompletableFuture<>();

		Executors.newCachedThreadPool()
			.submit(() -> {
				Thread.sleep(2000);
				completableFuture.complete("Hello");
				return null;
			});


		log.info("before run");
		String result = completableFuture.get(1000L, TimeUnit.MILLISECONDS);		//블로킹 방식으로 동작
		log.info("after run {}", result);
	}


	// 2초 걸리는 작업 수행확인
	public void future_2() throws ExecutionException, InterruptedException, TimeoutException {


		CompletableFuture<String> completableFuture = new CompletableFuture<>();

		Executors.newCachedThreadPool()
			.submit(() -> {
				Thread.sleep(2000);
				completableFuture.complete("Hello");
				return null;
			});

		CompletableFuture<String> modifiedFuture = completableFuture.thenApply( s -> s + "world");	//반환값을 받아 다른 값을 반환

		log.info("before run");
		while( !modifiedFuture.isDone()) {
			Thread.sleep(100);
			log.info("집계중");
		}
		String result = modifiedFuture.get();
		log.info("after run {}", result);
	}

	// 두개의 작업을 async로 실행하고 결과를 조합한다
	public void future_3() throws ExecutionException, InterruptedException, TimeoutException {


		CompletableFuture<String> future1 = new CompletableFuture<>();

		Executors.newCachedThreadPool()
			.submit(() -> {
				Thread.sleep(1000);
				future1.complete("Hello1");
				return null;
			});

		CompletableFuture<String> future2 = new CompletableFuture<>();

		Executors.newCachedThreadPool()
			.submit(() -> {
				Thread.sleep(2000);
				future2.complete("Hello2");
				return null;
			});

		log.info("before run");

		CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2);

		while( !combinedFuture.isDone()) {
			Thread.sleep(100);
			log.info("집계중");
		}
		log.info("after run ");

		String combined = Stream.of(future1, future2).map(CompletableFuture::join)
			.collect(Collectors.joining(" "));
		log.info("after combined {}", combined);
	}


	public void future_4() throws ExecutionException, InterruptedException, TimeoutException {

		CompletableFuture<String> test1 = getPriceAsync("test1");
		CompletableFuture<String> test2 = getRateAsync("test2");

		log.info("before run");

		CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(test1, test2);

		while( !combinedFuture.isDone()) {
			Thread.sleep(100);
			log.info("집계중");
		}
		log.info("after run ");

		String combined = Stream.of(test1, test2).map(CompletableFuture::join)
			.collect(Collectors.joining(" "));
		log.info("after combined {}", combined);
	}

	//팩토리 메서드 supplyAsync 활용
	private CompletableFuture<String> getPriceAsync(String product) {
		return CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			return product + " price process";
		});
	}

	private CompletableFuture<String> getRateAsync(String product) {
		return CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			return product + " rate process";
		});
	}

}
