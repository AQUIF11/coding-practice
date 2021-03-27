
public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph(5, false);

        graph.addEdge(0, 2, 10);
        graph.addEdge(2, 3, 5);
        graph.addEdge(2, 4, 3);
        graph.addEdge(2, 2, 5);
        graph.addEdge(3, 0, -2);
        graph.addEdge(4, 3, 5);
//        graph.addEdge(0, 1, 3);
//        graph.addEdge(1, 0, 3); Issue here with directed graphs for number of components method

        graph.printGraph();
//        Works for directed and Undirected graphs
        graph.connectivityCheck();
//        Works for undirected graphs only
        graph.numberOfComponents();
    }
}
