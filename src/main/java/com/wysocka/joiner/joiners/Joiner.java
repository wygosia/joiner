package com.wysocka.joiner.joiners;

import java.util.Collection;

public interface Joiner<IN, OUT> {
	OUT join(Collection<IN> elements);
}
