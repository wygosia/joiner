package com.wysocka.joiner.getters.integers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.function.Supplier;

@Component
public class DBIntegerGetter implements Supplier<Integer> {
	private final Logger log = LoggerFactory.getLogger(DBIntegerGetter.class);
	private static final String RANDOM_VALUE_SQL = "SELECT value FROM integers ORDER BY RAND() LIMIT 1";
	private final EntityManager entityManager;

	public DBIntegerGetter(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Integer get() {
		Query query = entityManager.createNativeQuery(RANDOM_VALUE_SQL);
		Integer value = Integer.valueOf(query.getSingleResult().toString());
		log.trace("value: {}", value);
		return value;
	}
}
