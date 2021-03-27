import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {
    private final int nVertices;
    private final boolean directed;
    private final List<List<Integer[]>> adjList;
    private final int[] colour;
    private final boolean[] visited;
    private boolean bipartite;
    private final List<List<Integer>> components;

    public Graph(int nVertices, boolean directed) {
        this.nVertices = nVertices;
        this.directed = directed;
        this.adjList = new ArrayList<List<Integer[]>>(nVertices);
        this.colour = new int[nVertices];
        this.visited = new boolean[nVertices];
        this.components = new ArrayList<List<Integer>>();
        this.bipartite = true;

        for(int i=0; i<nVertices; i++) {
            this.adjList.add(new ArrayList<>());
        }
    }

    public int[] getColour() {
        return colour;
    }

    public void addEdge(int source, int destination, int weight) {
        this.adjList.get(source).add(new Integer[] {destination, weight});
        if(!directed && source!=destination) {
            this.adjList.get(destination).add(new Integer[] {source, weight});
        }
    }

    public void printGraph() {
        System.out.println("Graph:");
        for(int i=0; i<nVertices; i++) {
            System.out.print(i + ": ");
            for(Integer[] j : adjList.get(i)) {
                System.out.print(Arrays.toString(j) + " ");
            }
            System.out.println();
        }
    }

    private void checkBipartite(int nodeIndex) {
        this.visited[nodeIndex] = true;
        components.get(components.size()-1).add(nodeIndex);

        for(Integer[] i : this.adjList.get(nodeIndex)) {
            if(!visited[i[0]]) {
                if(this.colour[nodeIndex] == 0) {
                    this.colour[i[0]] = 1;
                } else if(this.colour[nodeIndex] == 1) {
                    this.colour[i[0]] = 0;
                }
                checkBipartite(i[0]);
            } else {
                if(nodeIndex == i[0]) {
                    continue;
                }

                if(this.colour[nodeIndex]==this.colour[i[0]]) {
                    bipartite = false;
                    return;
                }
            }
        }
    }

    public boolean bipartiteTest() {
        int j;
        for(int i=0; i<nVertices; i++) {
            for(j=0; j<components.size(); j++) {
                if(components.get(j).contains(i)) {
                    break;
                }
            }
            if(j == components.size()) {
                components.add(new ArrayList<Integer>());
                checkBipartite(i);
            }
        }
        return bipartite;
    }
}
