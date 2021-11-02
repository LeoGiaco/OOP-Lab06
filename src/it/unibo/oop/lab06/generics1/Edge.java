package it.unibo.oop.lab06.generics1;

import java.util.Objects;

public class Edge<N> {

	private final N target;

	public Edge(N target) {
		this.target = target;
	}

	public N getTarget() {
		return target;
	}

	@Override
	public int hashCode() {
		return Objects.hash(target);
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge<N> other = (Edge<N>) obj;
		return Objects.equals(target, other.target);
	}
	
	
}
