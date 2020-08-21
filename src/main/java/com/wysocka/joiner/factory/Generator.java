package com.wysocka.joiner.factory;

import com.wysocka.joiner.joiners.Joiner;

import java.util.Collection;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Generator<IN, OUT> implements Supplier<OUT> {

	private Collection<Supplier<IN>> getters;
	private Joiner<IN, OUT> joiner;

	public Generator(Collection<Supplier<IN>> getters, Joiner<IN, OUT> joiner) {
		this.getters = getters;
		this.joiner = joiner;
	}

	public OUT get(){
		return joiner.join(
				getters.stream()
						.map(Supplier::get)
						.collect(Collectors.toList()));
	}
}
