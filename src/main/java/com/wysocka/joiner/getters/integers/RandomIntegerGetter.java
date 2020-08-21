package com.wysocka.joiner.getters.integers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.function.Supplier;

@Component
public class RandomIntegerGetter implements Supplier<Integer> {
	private final Logger log = LoggerFactory.getLogger(RandomIntegerGetter.class);
	public Integer get() {
		Random rn = new Random();
		Integer value = rn.nextInt();
		log.trace("value: {}", value);
		return value;
	}
}
