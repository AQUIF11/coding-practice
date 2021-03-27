import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {
    private final int nVertices;
    private final boolean directed;
    private final List<List<Integer[]>> adjList;
    private final boolean[] visited;
    private final boolean[] visited2;
    private final List<List<Integer>> components;
    private boolean hasCycle;

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

    private void detectCycle(int destination, int source) {
        this.visited[destination] = true;
        components.get(components.size()-1).add(destination);

        for(Integer[] i : this.adjList.get(destination)) {
            if(!this.visited[i[0]]) {
                this.visited[i[0]] = true;
                detectCycle(i[0], destination);
            } else if(i[0]!=source || i[0]==destination) { /*Second condition is for 1 element self loop graph*/
                hasCycle = true;
                System.out.println(i[0] + " " + destination + " " + source);
                return;
            }
        }
    }


    public boolean cycleDetection() {
        this.components.clear();
        int j;
        for(int i=0; i<nVertices; i++) {
            for(j=0; j<components.size(); j++) {
                if(components.get(j).contains(i)) {
                    break;
                }
            }
            if(j == components.size()) {
                components.add(new ArrayList<Integer>());
                detectCycle(i, i);
            }
        }

        return hasCycle;
    }

}
