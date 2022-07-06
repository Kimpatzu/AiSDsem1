import java.util.Random;
import java.util.Arrays;

public class Main {

    public static int[] createRandomArray(){
        Random random = new Random();
        int[] array = new int[10000];
        for (int i=0; i<array.length; i++){
            array[i] = random.nextInt(50000);
        }
        return array;
    }
    public static int[] createSortedArray(){
        int[] array = createRandomArray();
        Arrays.sort(array);
        return array;
    }
    public static int[] createDescendingSortedArray(){
        int[] array = createSortedArray();
        int[] outputArray = new int[array.length];
        for (int i=0; i< array.length; i++){
            outputArray[i] = array[array.length-1-i];
        }
        return outputArray;
    }
    public static void main(String[] args) {
        InsertSort rinsertSort = new InsertSort(createRandomArray());
        InsertSort sinsertSort = new InsertSort(createSortedArray());
        InsertSort dinsertSort = new InsertSort(createDescendingSortedArray());
        BubbleSort rbubbleSort = new BubbleSort(createRandomArray());
        BubbleSort sbubbleSort = new BubbleSort(createSortedArray());
        BubbleSort dbubbleSort = new BubbleSort(createDescendingSortedArray());
        SelectSort rselectSort = new SelectSort(createRandomArray());
        SelectSort sselectSort = new SelectSort(createSortedArray());
        SelectSort dselectSort = new SelectSort(createDescendingSortedArray());
        QuickSort rquickSort = new QuickSort(createRandomArray());
        QuickSort squickSort = new QuickSort(createSortedArray());
        QuickSort dquickSort = new QuickSort(createDescendingSortedArray());
        HeapSort rheapSort = new HeapSort(createRandomArray());
        HeapSort sheapSort = new HeapSort(createSortedArray());
        HeapSort dheapSort = new HeapSort(createDescendingSortedArray());
        MergeSort rmergeSort = new MergeSort(createRandomArray());
        MergeSort smergeSort = new MergeSort(createSortedArray());
        MergeSort dmergeSort = new MergeSort(createDescendingSortedArray());
        System.out.println("InsertSort: ");
        System.out.println(rinsertSort.executeAlgorythm());
        System.out.println(sinsertSort.executeAlgorythm());
        System.out.println(dinsertSort.executeAlgorythm());
        System.out.println("BubbleSort: ");
        System.out.println(rbubbleSort.executeAlgorythm());
        System.out.println(sbubbleSort.executeAlgorythm());
        System.out.println(dbubbleSort.executeAlgorythm());
        System.out.println("SelectSort: ");
        System.out.println(rselectSort.executeAlgorythm());
        System.out.println(sselectSort.executeAlgorythm());
        System.out.println(dselectSort.executeAlgorythm());
        System.out.println("QuickSort: ");
        System.out.println(rquickSort.executeAlgorythm());
        System.out.println(squickSort.executeAlgorythm());
        System.out.println(dquickSort.executeAlgorythm());
        System.out.println("HeapSort: ");
        System.out.println(rheapSort.executeAlgorythm());
        System.out.println(sheapSort.executeAlgorythm());
        System.out.println(dheapSort.executeAlgorythm());
        System.out.println("MergeSort: ");
        System.out.println(rmergeSort.executeAlgorythm());
        System.out.println(smergeSort.executeAlgorythm());
        System.out.println(dmergeSort.executeAlgorythm());
    }
}
