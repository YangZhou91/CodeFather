import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ProblemAS {

	static final String START = "F";
	static String END = "";
	static int NUMBER_OF_ROUTE = 0;
	static int LENGTH_SHORTEST_ROUTE = Integer.MAX_VALUE;
	static LinkedList<String> SHORTEST_ROUTE;

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);

		Graph graph = new Graph();
		if (stdin.hasNext()) {
			END = stdin.next();
		}

		stdin.nextLine();
		String tempString = "";
		while (stdin.hasNextLine()) {
			tempString = stdin.nextLine();
			String[] nodes = tempString.split("\\s+");

			String nodeA = nodes[0];
			String nodeB = nodes[1];
			graph.addTwoWayVertex(nodeA, nodeB);
		}

		LinkedList<String> visited = new LinkedList();
		visited.add(START);
		breadthFirst(graph, visited);
		if(NUMBER_OF_ROUTE == 0){
			System.out.println("No Route Available from " + START + " to " + END);
		}
		else{
		System.out.println("Total Routes: " + NUMBER_OF_ROUTE);
		System.out.println("Shortest Route Length: " + LENGTH_SHORTEST_ROUTE);
		System.out.print("Shortest Route after Sorting of Routes of length "
				+ LENGTH_SHORTEST_ROUTE + ":");
		for (String node : SHORTEST_ROUTE) {
			System.out.print(" " + node );
		}
		System.out.println();
		}
		stdin.close();
	}

	private static void breadthFirst(Graph graph, LinkedList<String> visited) {

		LinkedList<String> nodes = graph.adjacentNodes(visited.getLast());
		for (String node : nodes) {
			if (visited.contains(node)) {
				continue;
			}
			if (node.equals(END)) {
				visited.add(node);
				printPath(visited);
				visited.removeLast();
				break;
			}
		}
		for (String node : nodes) {
			if (visited.contains(node) || node.equals(END)) {
				continue;
			}
			visited.addLast(node);
			breadthFirst(graph, visited);
			visited.removeLast();

		}
	}

	private static void printPath(LinkedList<String> visited) {
		NUMBER_OF_ROUTE++;
		if (visited.size() < LENGTH_SHORTEST_ROUTE) {
			LENGTH_SHORTEST_ROUTE = visited.size();
			SHORTEST_ROUTE = new LinkedList();
			SHORTEST_ROUTE = (LinkedList<String>) visited.clone();
			/*
			 * for(String node: SHORTEST_ROUTE){ System.out.println(node); }
			 */
		}

		/*
		 * for (String node : visited) { System.out.println(node);
		 * System.out.print(" "); }
		 * 
		 * System.out.println();
		 */
	}
}

class Graph {

	private Map<String, LinkedHashSet<String>> map = new HashMap();

	public void addEdge(String node1, String node2) {
		LinkedHashSet<String> adjacent = map.get(node1);
		if (adjacent == null) {
			adjacent = new LinkedHashSet();
			map.put(node1, adjacent);
		}
		adjacent.add(node2);
	}

	public void addTwoWayVertex(String node1, String node2) {
		addEdge(node1, node2);
		addEdge(node2, node1);
	}

	public boolean isConnected(String node1, String node2) {
		Set adjacent = map.get(node1);
		if (adjacent == null) {
			return false;
		}
		return adjacent.contains(node2);
	}

	public LinkedList<String> adjacentNodes(String last) {
		LinkedHashSet<String> adjacent = map.get(last);
		if (adjacent == null) {
			return new LinkedList();
		}
		return new LinkedList<String>(adjacent);
	}

}
