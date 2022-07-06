public class QuickSort {
    private int[] array;

    public QuickSort(int[] array) {
        this.array = array;
    }

    public long executeAlgorythm(){
        long startTime = System.currentTimeMillis();
        quickSort(array,0,array.length-1);
        long endTime = System.currentTimeMillis();
        return endTime-startTime;
    }
    private void swap(int[] arr, int i, int j){
        int pom  = arr[i];
        arr[i]=arr[j];
        arr[j]=pom;
    }
    private int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i= low-1;

        for (int j =low; j<=high-1; j++){
            if(arr[j]<pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr, i+1, high);
        return i+1;
    }
    private void quickSort(int[] arr, int low, int high){
        if (low < high)
        {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
}
