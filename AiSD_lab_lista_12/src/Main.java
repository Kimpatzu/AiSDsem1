import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Vertice[] loadingVertices(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();
        System.out.println("Jeżeli chcesz wprowadzić miasto - wpisz jego nazwę\n" +
                "Jeżeli chcesz zakończyć wpisywanie - wpisz KONIEC\n");
        String name = scanner.nextLine();
        int i =0;
        while(!name.equals("KONIEC")){
            if (names.contains(name)){
                System.out.println("To miasto już zostało wpisane");
            } else {
                names.add(name);
                i++;
            }
            name = scanner.nextLine();
        }
        Vertice[] vertices = new Vertice[names.size()];
        for (int j=0; j<names.size(); j++){
            vertices[j] = new Vertice(j,names.get(j));
        }
        return vertices;
    }
    public static Edge[] loadingEdges(int numberOfVertices){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Edge> edges = new ArrayList<>();
        System.out.println("Żeby przerwać wpisywanie krawędzi, jako początek krawędzi wprowadź -1");
        System.out.println("Podaj początek krawędzi\n");
        int tail = scanner.nextInt();
        System.out.println("Podaj koniec krawędzi\n");
        int head = scanner.nextInt();
        System.out.println("Podaj wagę krawędzi\n");
        int weight = scanner.nextInt();
        while(tail != -1){
            if (tail>=numberOfVertices || head>=numberOfVertices || tail == head || weight<=0){
                System.out.println("Podany w krawędzi wierzchołek nie istnieje");
            } else if (edges.contains(new Edge(tail,head,weight))){
                System.out.println("Ta krawędź została już wprowadzona");
            } else {
               edges.add(new Edge(tail, head,weight));
            }
            System.out.println("Podaj początek krawędzi\n");
            tail = scanner.nextInt();
            System.out.println("Podaj koniec krawędzi\n");
            head = scanner.nextInt();
            System.out.println("Podaj wagę krawędzi\n");
            weight = scanner.nextInt();
        }
        return edges.toArray(Edge[]::new);
    }
    public static void main(String[] args) {
        Vertice[] vertices = loadingVertices();
        Edge[] edges = loadingEdges(vertices.length);
        for(int i=0; i< vertices.length; i++){
            System.out.println(vertices[i]);
        }
        for(int i=0; i< edges.length; i++){
            if(edges[i]==null){
            }
            System.out.println(edges[i]);
        }
        Graph cityGraph = new Graph(vertices,edges);
        System.out.println(cityGraph);
        DataStorageClass data = cityGraph.DFS(cityGraph);
        int[] colour = data.getColour();
        int[] p = data.getP();
        int[] t = data.getT();
        int time = data.getTime();
        for (int i=0; i< colour.length; i++){
            System.out.println("Colour: " + colour[i]);
        }
        for (int i=0; i< p.length; i++){
            System.out.println("p: " + p[i]);
        }
        for (int i=0; i< t.length; i++){
            System.out.println("t: " + t[i]);
        }
        System.out.println("Time: " + time);

    }
}
