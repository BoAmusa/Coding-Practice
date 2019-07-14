package graph.search.algos;

import java.util.Iterator;
import java.util.LinkedList;

public class BreadthFirstSearch {

	int V;
	LinkedList<Integer> adjacentList[];

	public BreadthFirstSearch(int V) {
		this.V = V;
		this.adjacentList = new LinkedList[V];

		// Creating new adjacent list for every vertex(node) passed in the BFS
		// Graph
		for (int i = 0; i < V; i++) {
			adjacentList[i] = new LinkedList<Integer>();
		}
	}

	// Adding edge to vertex(node)
	void addEdge(int vertex, int edge) {
		adjacentList[vertex].add(edge);
	}

	// Performing BFS search based on vertex node
	void BFS(int vertex) {
		System.out.println("Following is Breadth First Traversal " + "(starting from vertex " + vertex);
		// Setting new array with automatically false visited vertices
		boolean[] visited = new boolean[V];

		// Creating Queue as Linked List Array
		LinkedList<Integer> queue = new LinkedList<Integer>();

		// Marking vertex as visiting then adding to Queue
		visited[vertex] = true;
		queue.add(vertex);

		// Base Check if Queue is not empty
		while (!queue.isEmpty()) {
			// Polling the first element
			int source = queue.poll();
			System.out.print(source + " ");
			// Searching the current vertex's edges
			Iterator<Integer> it = adjacentList[source].iterator();
			while (it.hasNext()) {
				// Checking to see all none visited links
				int n = it.next();
				// If not visited add to queue
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}

			}

		}

	}

	void printBFS() {

		for (int i = 0; i < V; i++) {
			System.out.println("Adjacency Matrix List");
			System.out.println("Head ");
			Iterator<Integer> it = adjacentList[i].iterator();
			while (it.hasNext()) {
				System.out.println("~>" + it.next());
			}
		}
	}

	public static void main(String[] args) {
		BreadthFirstSearch bfs = new BreadthFirstSearch(4);
		bfs.addEdge(0, 1);
		bfs.addEdge(0, 2);
		bfs.addEdge(1, 2);
		bfs.addEdge(2, 0);
		bfs.addEdge(2, 3);
		bfs.addEdge(3, 3);

		bfs.BFS(1);

	}

}
