import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Graph {
    private Vertice[] vertices;
    private OneWayLinkedListWithHead<Edge>[] edges;
    private int[] p;
    private int[] d;

    public Graph(Vertice[] vertices, Edge[] edges) {
        this.vertices = vertices;
        this.edges = convertToNeighborhoodList(edges);
        this.p = new int[vertices.length];
        this.d = new int[vertices.length];
    }

    public Vertice[] getVertices() {
        return vertices;
    }

    public void setVertices(Vertice[] vertices) {
        this.vertices = vertices;
    }

    private OneWayLinkedListWithHead<Edge>[] convertToNeighborhoodList(Edge[] edges){
        OneWayLinkedListWithHead<Edge>[] edgesNeighborhoodList = new OneWayLinkedListWithHead[vertices.length];
        for (int i=0; i< vertices.length; i++){
            edgesNeighborhoodList[i] = new OneWayLinkedListWithHead<>();
        }
        for(int i=0; i<edges.length; i++) {
                edgesNeighborhoodList[edges[i].getTail()].add(edges[i]);        //dla listy o indexie w tablicy równemu początkowi krawędzi, dodaj krawędź
        }
        return edgesNeighborhoodList;
    }

    public OneWayLinkedListWithHead<Edge>[] getEdges() {
        return edges;
    }

    public void setEdges(OneWayLinkedListWithHead<Edge>[] edges) {
        this.edges = edges;
    }

    public String toString(){
        String output = "List of vertices:\n";
        for (int i=0; i<vertices.length; i++){
            output += vertices[i] + "\n";
        }
        output += "List of edges:\n";
        for (int i=0; i<edges.length; i++){
            Iterator iterator = edges[i].listiterator();
            while (iterator.hasNext()){
                output+= iterator.next() + "\n";
            }
        }
        //for(int i=0; i<this.edges.length; i++){
        //   for (int j=0; j<this.edges[i].size(); j++){
        //        output += this.edges[i].get(j) + "\n";
        //    }
        //}
        return output;
    }


    public void BFS(Graph G, Vertice s){
        int[] d = new int[G.vertices.length];
        int[] p = new int[G.vertices.length];
        int[] colour = new int[G.vertices.length];      //0 - white , 1 - grey, 2 - black
        int intMaxValue = 2147483600;
        int indexOfS = -1;
        for (int i=0 ; i<G.vertices.length; i++){
            if (G.vertices[i]!=s){
                colour[i] = 0;
                d[i] = intMaxValue;
                p[i] = -1;
            } else {
                indexOfS = i;
            }
        }
        colour[indexOfS] = 1;
        d[indexOfS] = 0;
        p[indexOfS] = -1;
        ArrayQueue<Vertice> Q = new ArrayQueue<>();
        try{
            Q.enqueue(s);
            while(!Q.isEmpty()){
                Vertice u = Q.dequeue();
                int indexOfU = -1;
                for (int i=0; i<G.vertices.length; i++){
                    if(G.vertices[i]==u){
                        indexOfU = i;
                        break;
                    }
                }
                Iterator uIterator = edges[indexOfU].listiterator();
                while(uIterator.hasNext()){
                    Vertice v = (Vertice) uIterator.next();
                    int indexOfV = -1;
                    for (int i=0; i<G.vertices.length; i++){
                        if(G.vertices[i]==v){
                            indexOfV = i;
                            break;
                        }
                    }
                    if(colour[indexOfV] == 0){  //colour == 0 -> WHITE
                        colour[indexOfV] = 1;   //colour == 1 -> GREY
                        d[indexOfV] = d[indexOfU] + 1;
                        p[indexOfV] = indexOfU;
                        Q.enqueue(v);
                    }
                }
            }
        } catch (FullQueueException e){
            e.printStackTrace();
        } catch (EmptyQueueException e){
            e.printStackTrace();
        }
    }

    public DataStorageClass DFS(Graph G){
        int[] t = new int[G.vertices.length];
        int[] p = new int[G.vertices.length];
        int[] colour = new int[G.vertices.length];
        for(int i=0; i< G.vertices.length; i++){
            colour[i] = 0;                              //colour 0 == WHITE
            p[i] = -1;
        }
        int time = 0;
        for (int i=0; i< G.vertices.length; i++){
            if(colour[i]==0){                           // if colour == WHITE
                DataStorageClass data = DFS_Visit(G, i , colour, p, t, time);
                colour = data.getColour();
                p = data.getP();
                t = data.getT();
                time = data.getTime();
            }
        }
        return new DataStorageClass(colour, p, t, time);
    }

    public DataStorageClass DFS_Visit(Graph G, int indexOfU, int[] colour, int[] p, int[] t, int time){
        colour[indexOfU] = 1;                           // colour = 1 = GREY
        time = time + 1;
        t[indexOfU] = time;
        Iterator uIterator = edges[indexOfU].listiterator();
        while(uIterator.hasNext()){
            Vertice v = (Vertice) uIterator.next();
            int indexOfV = -1;
            for (int i=0; i<G.vertices.length; i++){
                if(G.vertices[i]==v){
                    indexOfV = i;
                    break;
                }
            }
            if(colour[indexOfV] == 0){          //if colour is white
                p[indexOfV] = indexOfU;
                DataStorageClass data = DFS_Visit(G, indexOfV , colour, p, t, time);
                colour = data.getColour();
                p = data.getP();
                t = data.getT();
                time = data.getTime();
            }
        }
        colour[indexOfU] = 2;                                       //colour  = 2 = black
        time = time +1;
        t[indexOfU] = time;
        return new DataStorageClass(colour, p, t, time);
    }
}
