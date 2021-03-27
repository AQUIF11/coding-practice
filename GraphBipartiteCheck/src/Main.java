// Algo works for undirected graphs only.
// Algo works even if graph is not connected.


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(7, false);

//        graph.addEdge(0, 2, 10);
//        graph.addEdge(2, 3, 5);
//        graph.addEdge(2, 4, 3);
//        graph.addEdge(2, 2, 5);
//        graph.addEdge(3, 0, -2);
//        graph.addEdge(4, 3, 5);

//        graph.addEdge(1, 0, 3); Issue here with directed graphs.

        graph.addEdge(0, 1, 1);
        graph.addEdge(1, 2, 3);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 0, 5);

        graph.addEdge(4, 5, 6);
        graph.addEdge(5, 6, 7);
        graph.addEdge(6, 4, 8);

        graph.printGraph();

        System.out.println("Graph is bipartite: " + graph.bipartiteTest());
        System.out.println("Colours: " + Arrays.toString(graph.getColour()));
    }
}
