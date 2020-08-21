package com.wysocka.joiner.getters.integers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.function.Supplier;

@Component
public class RestIntegerGetter implements Supplier<Integer> {
	private final Logger log = LoggerFactory.getLogger(RestIntegerGetter.class);
	private static final String RANDOM_INTEGERS_URL =
			"https://www.random.org/integers/?num=1&min=1&max=6&col=1&base=10&format=plain&rnd=new";
	@Override
	public Integer get() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response
				= restTemplate.getForEntity(RANDOM_INTEGERS_URL, String.class);
		Integer value = Integer.valueOf(response.getBody().trim());
		log.trace("value: {}", value);
		return value;
	}
}
