package com.wysocka.joiner.factory.integers;

import com.wysocka.joiner.factory.Generator;
import com.wysocka.joiner.getters.integers.DBIntegerGetter;
import com.wysocka.joiner.getters.integers.RandomIntegerGetter;
import com.wysocka.joiner.getters.integers.RestIntegerGetter;
import com.wysocka.joiner.joiners.integers.SimpleIntegerJoiner;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;

@Component
public class IntegerGeneratorFactory {
	private final DBIntegerGetter dbGetter;
	private final RandomIntegerGetter randomGetter;
	private final RestIntegerGetter restGetter;
	private final SimpleIntegerJoiner joiner;


	public IntegerGeneratorFactory(DBIntegerGetter dbGetter, RandomIntegerGetter randomGetter,
								   RestIntegerGetter restGetter, SimpleIntegerJoiner joiner) {
		this.dbGetter = dbGetter;
		this.randomGetter = randomGetter;
		this.restGetter = restGetter;
		this.joiner = joiner;
	}

	public Supplier<Integer> getGenerator(){
		List<Supplier<Integer>> getters = Stream.of(dbGetter, randomGetter, restGetter)
				.collect(collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
		return new Generator<>(getters, joiner);
	}
}
