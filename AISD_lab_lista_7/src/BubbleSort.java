public class BubbleSort {
    private int[] array;

    public BubbleSort(int[] array){
        this.array = array;
    }

    public long executeAlgorythm(){
        long startTime = System.currentTimeMillis();
        for (int i=0; i<array.length; i++){
            for (int j=0; j<array.length-1; j++){
                if (array[j]>array[j+1]){
                    int pom = array[j];
                    array[j] = array[j+1];
                    array[j+1] = pom;
                }
            }
        }
        long endTime = System.currentTimeMillis();
        return endTime-startTime;
    }
}
