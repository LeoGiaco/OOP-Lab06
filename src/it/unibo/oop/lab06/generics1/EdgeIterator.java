package it.unibo.oop.lab06.generics1;

import java.util.Iterator;

public class EdgeIterator<N> implements Iterator<N> {
	
	private final Iterator<Edge<N>> iterator;

	public EdgeIterator(Iterator<Edge<N>> iterator) {
		this.iterator = iterator;
	}

	@Override
	public boolean hasNext() {
		return this.iterator.hasNext();
	}

	@Override
	public N next() {
		return this.iterator.next().getTarget();
	}
}
