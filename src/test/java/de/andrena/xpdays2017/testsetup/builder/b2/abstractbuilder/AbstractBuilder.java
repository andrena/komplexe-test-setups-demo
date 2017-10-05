package de.andrena.xpdays2017.testsetup.builder.b2.abstractbuilder;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;

public class AbstractBuilder<ENTITY> {

	protected ENTITY entity;

	protected AbstractBuilder() {
		entity = createEntityInstance();
	}

	@SuppressWarnings("unchecked")
	private ENTITY createEntityInstance() {
		ParameterizedType abstractDaoType = (ParameterizedType) getClass().getGenericSuperclass();
		Class<ENTITY> entityClass = (Class<ENTITY>) abstractDaoType.getActualTypeArguments()[0];
		try {
			return entityClass.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public ENTITY build() {
		return entity;
	}

	public List<ENTITY> buildAsList() {
		return Arrays.asList(entity);
	}

}
