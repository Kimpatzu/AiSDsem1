import java.util.Comparator;

public class EdgeComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Edge e1 = (Edge) o1;
        Edge e2 = (Edge) o2;
        if(e1.getWieght()>e2.getWieght()){
            return 1;
        } else if (e1.getWieght()<e2.getWieght()){
            return -1;
        } else {
            return 0;
        }
    }
}
