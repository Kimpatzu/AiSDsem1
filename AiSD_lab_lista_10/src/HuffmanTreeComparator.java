import java.util.Comparator;

public class HuffmanTreeComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        HufffmanTree h1 = (HufffmanTree) o1;
        HufffmanTree h2 = (HufffmanTree) o2;
        if(h1.getRootWeight() > h2.getRootWeight()){
            return 1;
        }
        if(h1.getRootWeight() < h2.getRootWeight()){
            return -1;
        }
        return 0;
    }
}
