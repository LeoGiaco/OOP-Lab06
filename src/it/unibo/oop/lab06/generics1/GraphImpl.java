package it.unibo.oop.lab06.generics1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

public class GraphImpl<N> implements Graph<N> {

	HashSet<Node<N>> nodes;
	
	public GraphImpl() {
		this.nodes = new HashSet<>();
	}

	@Override
	public void addNode(N node) {
		if(node != null && !this.nodes.contains(node)) {			
			this.nodes.add(new Node<>(node));
		}
	}

	private Node<N> getNode(N node) {
		for (Node<N> n : this.nodes) {
			if (n.getElement() == node || Objects.equals(n.getElement(), node)) {
				return n;
			}
		}
		return null;
	}
	
	@Override
	public void addEdge(N source, N target) {
		if(source != null && target != null) {
			Node<N> nodeSource = this.getNode(source);
			Node<N> nodeTarget = this.getNode(target);
			if(nodeSource != null && nodeTarget != null) {
				nodeSource.addEdge(target);
			}
		}
	}

	@Override
	public Set<N> nodeSet() {
		Set<N> out = new HashSet<>();
		for (Node<N> node : this.nodes) {
			out.add(node.getElement());
		}
		return out;
	}

	@Override
	public Set<N> linkedNodes(N node) {
		Node<N> n = this.getNode(node);
		if(n != null) {
			return n.getAllLinkedNodes();
		}
		return Set.of();
	}

	@Override
	public List<N> getPath(N source, N target) {
		Stack<Pair<Node<N>, Iterator<N>>> nodeStack = new Stack<>();
		Collection<N> visited = new ArrayList<>(this.nodes.size());
		nodeStack.add(this.getNode(source).getNodeAndIteratorPair());
		while(true) {
			var current = nodeStack.peek();					// Gets the element that has to be searched.
			visited.add(current.getFirst().getElement());	// Already searched elements must not be searched again if they reappear.
			Iterator<N> nodeIterator = current.getSecond();
			if(nodeIterator.hasNext()) {
				N childNode = nodeIterator.next();
				if(visited.contains(childNode)) {					
					continue;								// Already searched elements are skipped.
				} 
				if(childNode == target) {					// If the elements is the correct one, returns the stack (the path).
					List<N> out = new ArrayList<>();
					for (var node : nodeStack) {
						out.add(node.getFirst().getElement());
					}
					out.add(childNode);
					return out;
				} 
				if(!visited.contains(childNode)) {
					nodeStack.add(this.getNode(childNode).getNodeAndIteratorPair());	// Not already visited children are added
				}																		// to the stack so they can be visited next.
			} else {
				nodeStack.pop();							// If an element has no more linked elements then it gets removed.
				if(nodeStack.size() == 0)					// If the stack is empty that means that all paths have been crossed.
					return List.of();
			}
		}
	}
}
