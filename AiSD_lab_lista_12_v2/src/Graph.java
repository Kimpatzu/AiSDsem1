import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Graph {
    private Vertice[] vertices;
    private OneWayLinkedListWithHead<ListLink>[] neighborhoodList;

    public Graph(Vertice[] vertices, Edge[] edges){
        this.vertices = vertices;
        this.neighborhoodList = createNeighborhoodList(edges);
    }

    private OneWayLinkedListWithHead<ListLink>[] createNeighborhoodList(Edge[] edges){
        OneWayLinkedListWithHead<ListLink>[] nList = new OneWayLinkedListWithHead[vertices.length];
        for (int i=0; i< vertices.length; i++){                             //inicjalizacja tablicy
            nList[i] = new OneWayLinkedListWithHead<ListLink>();
        }
        for(int i=0; i< edges.length; i++){                                                             //do odpowiedniej listy o indeksie początkowego wierzchołka krawędzi
            nList[edges[i].getTail()].add(new ListLink(edges[i].getHead(), edges[i].getWeight()));      //dodaj element składający się z drugiego wierzchołka i wagi krawędzi
        }
        return nList;
    }

    public Vertice[] getAllVerticiesPossibleToTravelTo(Vertice v){
        int[] possibleVerticies = new int[vertices.length];
        int[] verticiesChecked = new int[vertices.length];
        ArrayQueue<Vertice> queue = new ArrayQueue<>();
        try {
            queue.enqueue(v);                                   //dodaj pierwszy wierzchołek do kolejki
        } catch (FullQueueException e){
            e.printStackTrace();
        }
        while(!queue.isEmpty()){                                //tak długo, jak kolejka nie jest pusta
            try {
                Vertice u = queue.dequeue();                                            //pobierz wierzchołek z kolejki
                verticiesChecked[u.getNumber()] = 1;                                    //zaznacz, że wierzchołek został sprawzdzony
                Iterator iterator = neighborhoodList[u.getNumber()].listiterator();     //iterator po wierzchołkach, do których ma dostęp u
                while(iterator.hasNext()){
                    ListLink currLink = (ListLink) iterator.next();
                    possibleVerticies[currLink.getHead()] = 1;                          //podróż do obecnego przeglądanego wierzchołka jest możliwa
                    if (verticiesChecked[currLink.getHead()] != 1){                     //jeżeli ten wierzchołek nie był jeszcze sprawdzany
                        try {
                            queue.enqueue(vertices[currLink.getHead()]);                //dodaj go do kolejki
                        } catch (FullQueueException e ){
                            e.printStackTrace();
                        }
                    }
                }
            } catch (EmptyQueueException e){
                e.printStackTrace();
            }
        }
        int possibleVerticiesCounter = 0;
        for (int i=0; i<possibleVerticies.length; i++){
            if (possibleVerticies[i]==1){
                possibleVerticiesCounter++;
            }
        }
        Vertice[] possibleVerticiesArray = new Vertice[possibleVerticiesCounter];
        int j=0;
        for(int i =0; i<possibleVerticies.length; i++){
            if (possibleVerticies[i]==1){
                possibleVerticiesArray[j] = vertices[i];
                j++;
            }
        }
        return  possibleVerticiesArray;
    }

    public int Dijkstra(Vertice source, Vertice target){
        PriorityQueue<ListLink> queue= new PriorityQueue<>(20, new ListLinkVerticeWeightComparator());      //tym razem ListLink przechowuje numer wierzchołka, i wartość drogi do niego
        int[] d = new int[vertices.length];
        int[] p = new int[vertices.length];
        for (int i=0; i< vertices.length; i++){
            d[i] = Integer.MAX_VALUE;
            p[i] = -1;
            queue.add(new ListLink(i, d[i]));
        }
        d[source.getNumber()] = 0;
        while(!queue.isEmpty()){
            ListLink u = queue.remove();
            Iterator iterator = neighborhoodList[u.getHead()].listiterator();           //dla sąsiadów u
            while(iterator.hasNext()){
                ListLink currNeighbourOfU = (ListLink) iterator.next();
                ListLink[] arr =queue.toArray(new ListLink[0]);
                boolean isinQ = false;
                for (int i=0; i< arr.length; i++){
                    if (arr[i].getHead() == currNeighbourOfU.getHead()){
                        isinQ = true;
                        break;
                    }
                }
                if (isinQ){
               // if(queue.contains(new ListLink(currNeighbourOfU.getHead(), d[currNeighbourOfU.getHead()]))){
                    int alt = d[u.getHead()] + currNeighbourOfU.getWeight();
                    if(alt < d[currNeighbourOfU.getHead()]){
                        d[currNeighbourOfU.getHead()] = alt;
                        p[currNeighbourOfU.getHead()] = u.getHead();
                    }
                }
            }
        }
        return d[target.getNumber()];

    }

    public String DFS(){
        String output = "";
        int[] t = new int[vertices.length];
        int[] colour = new int[vertices.length];
        int[] p = new int[vertices.length];
        for (int i=0; i< vertices.length; i++){
            colour[i] = 0;
            p[i] = -1;
        }
        int time = 0;
        for (int i=0; i< vertices.length; i++){
            if (colour[i] == 0){
                DataStorageClass data = DFS_Visit(i, colour, p ,t, time, output);
                colour = data.getColour();
                p = data.getP();
                t = data.getT();
                time = data.getTime();
                output += data.getOutput();
            }
        }
        return output;
    }

    public DataStorageClass DFS_Visit(int indexOfU, int[] colour, int[] p, int[] t, int time, String output){
        colour[indexOfU] = 1;
        time ++;
        t[indexOfU]  = time;
        Iterator iterator = neighborhoodList[indexOfU].listiterator();
        while (iterator.hasNext()){
            ListLink currLink = (ListLink) iterator.next();
            if (colour[currLink.getHead()] == 0){
                p[currLink.getHead()] = indexOfU;
                DataStorageClass data = DFS_Visit(currLink.getHead(), colour, p, t, time, output);
                colour = data.getColour();
                p = data.getP();
                t = data.getT();
                time = data.getTime();
                output += data.getOutput();
            }
        }
        colour[indexOfU] = 2;
        time ++;
        t[indexOfU] = time;
        output += "Obecnie odwiedzany: " + indexOfU + " Kolor: " + colour[indexOfU] + " t: " + t[indexOfU] + "\n";
        return new DataStorageClass(colour,p,t,time,output);
    }

    public String toString(){
        String output = "Lista wierzchołków: \n";
        for (int i=0; i< vertices.length; i++){
            output += vertices[i].toString() + "\n";
        }
        output += "Lista krawędzi: \n";
        for (int i=0; i< neighborhoodList.length; i++){
            Iterator iterator = neighborhoodList[i].listiterator();
            while(iterator.hasNext()){
                ListLink currLink = (ListLink) iterator.next();
                output += "("+i + "," + currLink.getHead() + ") ; " + currLink.getWeight() + "\n";
            }
        }
        return output;
    }
}
