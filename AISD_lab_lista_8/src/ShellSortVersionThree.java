import java.util.ArrayList;

public class ShellSortVersionThree {
    private int[] array;
    private ArrayList<Integer> gapSequence;

    public ShellSortVersionThree(int[] array, ArrayList<Integer> gapSequence) {
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
                    for (int l=k-h;l<k;l++){
                        int pom2 = array[l];
                        array[l] = array[l+1];
                        array[l+1] = pom2;
                    }
                }
                array[k] = pom;
            }
        }
        BubbleSort bubbleSort = new BubbleSort(array);
        bubbleSort.executeAlgorythm();
        long endTime = System.currentTimeMillis();
        return endTime-startTime;
    }

    public int[] getArray() {
        return array;
    }
}
