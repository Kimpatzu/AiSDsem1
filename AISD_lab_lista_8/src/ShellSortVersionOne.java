import java.util.ArrayList;

public class ShellSortVersionOne {
    private int[] array;
    private ArrayList<Integer> gapSequence;

    public ShellSortVersionOne(int[] array, ArrayList<Integer> gapSequence) {
        this.array = array;
        this.gapSequence = gapSequence;
    }

    public long executeAlgorythm(){
        long startTime = System.currentTimeMillis();
        for (int i = gapSequence.size()-1; i>=0; i--){
            int h = gapSequence.get(i);
            for (int j = h; j<array.length; j++){
                int pom = array[j];
                int k;
                for (k=j; k>=h && array[k-h]> pom;  k-=h){
                    array[k] = array[k-h];
                }
                array[k] = pom;
            }
        }
        InsertSort insertSort = new InsertSort(array);
        insertSort.executeAlgorythm();
        long endTime = System.currentTimeMillis();
        return endTime-startTime;
    }

    public int[] getArray() {
        return array;
    }
}
