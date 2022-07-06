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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj numer miasta, by sprawdzić, które miasta dla niego są osiągalne \n" +
                "Podaj -1 by zakończyć");
        int nrMiasta = scanner.nextInt();
        while (nrMiasta!=-1){
            Vertice[] possibleVerticies = cityGraph.getAllVerticiesPossibleToTravelTo(vertices[nrMiasta]);
            System.out.println("Osiągalne miasta dla " + vertices[nrMiasta] + " : ");
            for(int i=0; i< possibleVerticies.length; i++){
                System.out.println(possibleVerticies[i]);
            }
            System.out.println("Podaj numer miasta, by sprawdzić, które miasta dla niego są osiągalne \n" +
                    "Podaj -1 by zakończyć");
            nrMiasta = scanner.nextInt();
        }
        System.out.println("Podaj najpierw numer 1 miasta, a potem numer 2 miasta, by sprawdzić najkrótszą odległość między nimi\n" +
                "Podaj -1 by pominąć");
        int nrMiasta1 = scanner.nextInt();
        int nrMiasta2 = scanner.nextInt();
        while(nrMiasta1!=-1 || nrMiasta2 !=-1){
            System.out.println("Odległość pomiędzy " + vertices[nrMiasta1].getName() + " oraz " + vertices[nrMiasta2].getName() + " wynosi " + cityGraph.Dijkstra(vertices[nrMiasta1], vertices[nrMiasta2]));
            nrMiasta1 = scanner.nextInt();
            nrMiasta2 = scanner.nextInt();
        }
        System.out.println("DFS: \n");
        System.out.println(cityGraph.DFS());
    }
}
