package dev.backend.prac_aysnc.controller;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.backend.prac_aysnc.service.FutureService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class FutureController {

	private final FutureService futureService;


	@GetMapping("/future1")
	public String asyncCall_1() throws ExecutionException, InterruptedException, TimeoutException {
		futureService.future_1();
		return "success";
	}


	@GetMapping("/future2")
	public String asyncCall_2() throws ExecutionException, InterruptedException, TimeoutException {
		futureService.future_2();
		return "success";
	}

	@GetMapping("/future3")
	public String asyncCall_3() throws ExecutionException, InterruptedException, TimeoutException {
		futureService.future_3();
		return "success";
	}

	@GetMapping("/future4")
	public String asyncCall_4() throws ExecutionException, InterruptedException, TimeoutException {
		futureService.future_4();
		return "success";
	}
}
