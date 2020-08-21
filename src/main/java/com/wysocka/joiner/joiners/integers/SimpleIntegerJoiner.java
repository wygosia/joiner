package com.wysocka.joiner.joiners.integers;

import com.wysocka.joiner.joiners.Joiner;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class SimpleIntegerJoiner implements Joiner<Integer, Integer> {
	@Override
	public Integer join(Collection<Integer> elements) {
		return elements.stream()
				.mapToInt(Integer::intValue)
				.sum();
	}
}
