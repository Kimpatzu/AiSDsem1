public class InsertSort {
    private int[] array;

    public InsertSort(int[] array){
        this.array = array;
    }

    public long executeAlgorythm(){
        long startTime = System.currentTimeMillis();
        for (int i = 1; i< array.length ; i++){
            int value = array[i];
            int j = i-1;
            while(j>=0 && array[j]>value){
                array[j+1] = array[j];
                j=j-1;
            }
            array[j+1] = value;
        }
        long endTime = System.currentTimeMillis();
        return endTime-startTime;
    }
}
