public class SelectSort {
    private int[] array;

    public SelectSort(int[] array){
        this.array = array;
    }

    public long executeAlgorythm(){
        long startTime = System.currentTimeMillis();
        for (int i=0; i<array.length-1; i++){
            int minIndex = i;
            for(int j= i+1; j<array.length; j++){
                if(array[j]<array[minIndex]){
                    minIndex = j;
                }
            }
            int pom = array[minIndex];
            array[minIndex] = array[i];
            array[i] = pom;
        }
        long endTime = System.currentTimeMillis();
        return endTime-startTime;
    }
}
