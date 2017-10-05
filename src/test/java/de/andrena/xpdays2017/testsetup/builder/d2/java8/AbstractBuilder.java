package de.andrena.xpdays2017.testsetup.builder.d2.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public abstract class AbstractBuilder<T, BUILDER extends AbstractBuilder<T, BUILDER>> implements Cloneable {

	private List<Consumer<T>> entityModifiers = new ArrayList<>();

	@SuppressWarnings("unchecked")
	protected <U> BUILDER with(BiConsumer<T, U> setter, U value) {
		Consumer<T> entityModifier = entity -> setter.accept(entity, value);
		entityModifiers.add(entityModifier);
		return (BUILDER) this;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object clone() {
		try {
			AbstractBuilder<T, BUILDER> clone = (AbstractBuilder<T, BUILDER>) super.clone();
			clone.entityModifiers = new ArrayList<>(entityModifiers); 
			return clone;
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public BUILDER but() {
		return (BUILDER) clone();
	}

	public T build(Supplier<T> instantiator) {
		T value = instantiator.get();
		entityModifiers.forEach(modifier -> modifier.accept(value));
		return value;
	}

	public T build(T value) {
		entityModifiers.forEach(modifier -> modifier.accept(value));
		return value;
	}
}