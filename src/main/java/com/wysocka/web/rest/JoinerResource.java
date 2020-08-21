package com.wysocka.web.rest;

import com.wysocka.joiner.factory.integers.IntegerGeneratorFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Supplier;

@RestController
@RequestMapping("/api/joiner")
public class JoinerResource {

	private final Supplier<Integer> generator;

	public JoinerResource(IntegerGeneratorFactory integerGeneratorFactory) {
		generator = integerGeneratorFactory.getGenerator();
	}

	@GetMapping("integer")
	public Integer getInteger() {
		return generator.get();
	}
}
