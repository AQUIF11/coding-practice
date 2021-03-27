//Algo. only works for undirected Graphs.
//Works even if graph is not connected.

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(5, false);

        graph.addEdge(0, 2, 10);
        graph.addEdge(2, 3, 5);
        graph.addEdge(2, 4, 3);
        graph.addEdge(2, 2, 5);
        graph.addEdge(3, 0, -2);
        graph.addEdge(4, 3, 5);

//        graph.addEdge(0, 0, 5);

        graph.printGraph();

        graph.numberOfComponents();

        System.out.println("Graph has cycle: " + graph.cycleDetection());

    }
}
