import java.util.ArrayList;

public class Graph {
    private Edge[] edges;
    private int nunberOfVertices;

    public Graph(Edge[] edges, int nunberOfVertices) {
        this.edges = edges;
        this.nunberOfVertices = nunberOfVertices;
    }

    public Edge[] getEdges() {
        return edges;
    }

    public void setEdges(Edge[] edges) {
        this.edges = edges;
    }

    public int getNunberOfVertices() {
        return nunberOfVertices;
    }

    public void setNunberOfVertices(int nunberOfVertices) {
        this.nunberOfVertices = nunberOfVertices;
    }

    public int Kruskal(){
        ArrayList<Integer>[] connections = new ArrayList[nunberOfVertices];
        for (int i=0; i<nunberOfVertices; i++){                             //inicjalizacji list przechowujących aktualne połączenia
            connections[i] = new ArrayList<>();
            connections[i].add(i);                                          //w liście połączeń kazdy wierzchołek ma jużsamego siebie
        }
        int lenght = 0;
        Edge[] S = sort(edges);
        for (int i=0; i<S.length; i++){
            Edge currEdge = S[i];
            boolean connectsTwoDiffrent = true;
            int firstVertice = currEdge.getFirstVerticeNumber();
            int secondVertice = currEdge.getSecondVerticeNumber();
            for (int j=0; j<connections[firstVertice].size(); j++){         //przechodzi po liście wierzchołków pierwszego wierzchołka krawędzi i sprawdza czy zawiera już numer drugiego wierzchołka
                if(connections[firstVertice].contains(secondVertice)){
                    connectsTwoDiffrent = false;
                }
            }
            if(connectsTwoDiffrent){        //jeżeli obecna krawędź łączy wierzchołki które nie są jeszcze połączone
                lenght += currEdge.getWieght();
                connections[firstVertice].add(secondVertice);           //drugi wierzchołek znajduje się w liście połączeń pierwszego wierzchołka
                connections[secondVertice].add(firstVertice);           //to samo tylko na odwrót
                for(int j=0; j<connections[secondVertice].size(); j++){     //dodanie pozostałych elementów z listy drugiego do listy pierwszego
                    if(!connections[firstVertice].contains(connections[secondVertice].get(j))){     //jeżeli w liście pierwszego nie ma jakiegoś wierzchołka, to go kopiuje i przekazuje do swoich pozostałych
                        connections[firstVertice].add(connections[secondVertice].get(j));
                    }
                }
                for (int j=0; j<connections[firstVertice].size(); j++){
                    connections[connections[firstVertice].get(j)] = connections[firstVertice];          // dla każdego z wierzchołków kopiowana jest lista połączeń
                }
            }
        }
        return lenght;
    }


    public Edge[] sort(Edge[] edges){
        Edge[] edgesClone = clone(edges);
        for (int i = 1; i<edgesClone.length ; i++){
            Edge key = edgesClone[i];
            int j = i - 1;
            while (j>=0 && edgesClone[j].getWieght() > key.getWieght()){
                edgesClone[j+1]  = edgesClone[j];
                j = j - 1;
            }
            edgesClone[j + 1] = key;
        }
        return edgesClone;
    }

    public Edge[] clone(Edge[] edges){
        Edge[] edgesClone = new Edge[edges.length];
        for (int i=0; i< edges.length; i++){
            edgesClone[i] = new Edge(edges[i].getFirstVerticeNumber(), edges[i].getSecondVerticeNumber(), edges[i].getWieght());
        }
        return edgesClone;
    }
}
