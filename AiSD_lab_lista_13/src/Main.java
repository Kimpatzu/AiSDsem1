import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("da7.txt");
            Scanner scanner = new Scanner(fileInputStream);
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            System.out.println(n + " " + m);
            fileInputStream.close();
            Edge[] edges = new Edge[m];
            for(int i=0; i<m; i++){
                int firstVertice = scanner.nextInt() -1 ;
                int secondVertice = scanner.nextInt() -1 ;
                int lenght = scanner.nextInt();
                edges[i] = new Edge(firstVertice,secondVertice,lenght);
            }
            System.out.println("Zawartość pliku: \n");
            for(int i=0; i<m; i++){
                System.out.println(edges[i]);
            }
            Graph graph = new Graph(edges,n);
            Edge[] edges2 = graph.sort(edges);
            System.out.println("Posortowane krawędzie: \n");
            for(int i=0; i<m; i++){
                System.out.println(edges2[i]);
            }
            System.out.println(graph.Kruskal());
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
