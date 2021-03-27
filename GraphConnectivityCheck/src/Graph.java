import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {
    private final int nVertices;
    private final boolean directed;
    private final List<List<Integer[]>> adjList;
    private int count;
    private final boolean[] visited;
    private final boolean[] visited2;
    private final List<List<Integer>> components;

    public Graph(int nVertices, boolean directed) {
        this.nVertices = nVertices;
        this.directed = directed;
        this.adjList = new ArrayList<List<Integer[]>>(nVertices);
        this.visited = new boolean[nVertices];
        this.visited2 = new boolean[nVertices];
        this.components = new ArrayList<List<Integer>>();

        for(int i=0; i<nVertices; i++) {
            this.adjList.add(new ArrayList<>());
        }
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

    private void cCheckDfs(int nodeIndex) {
        if(this.visited[nodeIndex]) {
            return;
        }
        this.visited[nodeIndex] = true;
        count++;
        for(Integer[] i : this.adjList.get(nodeIndex)) {
            cCheckDfs(i[0]);
        }
    }

    public void connectivityCheck() {
        this.count=0;
        cCheckDfs(0);

        if(count == this.nVertices) {
            System.out.println("Graph is Connected " + this.count);
        } else {
            System.out.println("Graph is not Connected " + this.count);
        }
    }

    private void createComponentDfs(int nodeIndex) {
        if(this.visited2[nodeIndex]) {
            return;
        }
        this.visited2[nodeIndex] = true;
        components.get(components.size()-1).add(nodeIndex);
        for(Integer[] i : this.adjList.get(nodeIndex)) {
            createComponentDfs(i[0]);
        }
    }

    public void numberOfComponents() {
        int j;
        for(int i=0; i<nVertices; i++) {
            for(j=0; j<nVertices; j++) {
                this.visited2[j] = false;
            }
            for(j=0; j<components.size(); j++) {
                if(components.get(j).contains(i)) {
                    break;
                }
            }
            if(j == components.size()) {
                components.add(new ArrayList<Integer>());
                createComponentDfs(i);
            }
        }

        System.out.println("Total number of Components: " + components.size());
        for(int i=0; i<components.size(); i++) {
            System.out.print("Component " + (i+1) + ": ");
            for(Integer k : components.get(i)) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
    }
}
