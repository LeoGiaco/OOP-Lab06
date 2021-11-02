package it.unibo.oop.lab06.generics1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class Node<N> implements Iterable<N> {
	
	private final N element;
	private HashSet<Edge<N>> edges;
	
	public Node(N element) {
		this.element = element;
		this.edges = new HashSet<>();
	}
	
	public N getElement() {
		return element;
	}

	public Set<N> getAllLinkedNodes() {
		HashSet<N> out = new HashSet<>();
		for (Edge<N> edge : this.edges) {
			out.add(edge.getTarget());
		}
		return out;
	}
	
	public int numOfEdges() {
		return this.edges.size();
	}

	public boolean addEdge(N node) {
		return this.edges.add(new Edge<N>(node));
	}
	
	public boolean removeEdge(N node) {
		return this.edges.remove(node);
	}

	@Override
	public int hashCode() {
		return Objects.hash(element);
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
		Node<N> other = (Node<N>) obj;
		return Objects.equals(element, other.element);
	}
	
	public Pair<Node<N>, Iterator<N>> getNodeAndIteratorPair() {
		return new Pair<Node<N>, Iterator<N>>(this, this.getAllLinkedNodes().iterator());
	}

	@Override
	public Iterator<N> iterator() {
		return new EdgeIterator<>(this.edges.iterator());
	}
	
}
