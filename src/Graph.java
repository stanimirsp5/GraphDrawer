

public class Graph {
    private int V;
    private int E;
    private Bag[] adj;

    public Graph(int v){
        V = v;
        adj = new Bag[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new Bag();
        }
    }

    public Graph(In in){
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v,w);
        }
    }

    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
    }
    public Bag[] getList(){
        return adj;
    }

    public void printG(){
        for (int i = 0; i < V; i++) {
            System.out.println("vertex " + i + " edge ");
            adj[i].print();
        }
    }
}
