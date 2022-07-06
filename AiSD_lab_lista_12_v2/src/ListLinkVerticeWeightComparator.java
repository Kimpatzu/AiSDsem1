import java.util.Comparator;

public class ListLinkVerticeWeightComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        ListLink ll1 = (ListLink)o1;
        ListLink ll2 = (ListLink)o2;
        if(ll1.getWeight()>ll2.getWeight()){
            return -1;
        } else if (ll1.getWeight()< ll2.getWeight()){
            return 1;
        } else {
            return 0;
        }
    }
}
