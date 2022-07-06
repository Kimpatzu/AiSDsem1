import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static int[] createRandomArray(int n){
        Random random = new Random();
        int[] array = new int[n];
        for (int i=0; i<array.length; i++){
            array[i] = random.nextInt(50000);
        }
        return array;
    }
    public static ArrayList<Integer> gapSequenceOne(int n){
        ArrayList<Integer> arrayList = new ArrayList<>();
        int h = 4;
        while(h<n){
            arrayList.add(h);
            h= 3*h + 1;
        }
        return arrayList;
    }
    public static ArrayList<Integer> gapSequenceTwo(int n){
        ArrayList<Integer> arrayList = new ArrayList<>();
        int h = 3;
        int k=2;
        while(h<n){
            arrayList.add(h);
            k++;
            h = (2^k) - 1;
        }
        return arrayList;
    }
    public static ArrayList<Integer> gapSequenceThree(int n){
        ArrayList<Integer> arrayList = new ArrayList<>();
        int h = 3;
        int k=2;
        while(h<n){
            arrayList.add(h);
            k++;
            h = (2^k) + 1;
        }
        return arrayList;
    }
    public static ArrayList<Integer> gapSequenceFour(int n){
        ArrayList<Integer> arrayList = new ArrayList<>();
        int h1 = 1;
        int h2=2;
        while(h2<n){
            arrayList.add(h2);
            int pom = h1;
            h1 = h2;
            h2 = pom+h2;
        }
        return arrayList;
    }
    public static ArrayList<Integer> gapSequenceFive(int n){
        ArrayList<Integer> arrayList = new ArrayList<>();
        int h=2;
        int k=4;
        while(h<n){
            arrayList.add(h);
            h = k/2;
            k++;
        }
        return arrayList;
    }
    public static ArrayList<Integer> gapSequenceSix(int n){
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        int h = 5;
        while(h<n){
            arrayList.add(h);
            h = (int)(4*h)/3;
        }
        return arrayList;
    }
    public static void main(String[] args) {
        int n = 10000;
        ArrayList<Integer> arrayList = gapSequenceOne(n);
        for (int i=0; i< arrayList.size(); i++){
            System.out.println(arrayList.get(i));
        }
        ArrayList<Integer> gap1 = gapSequenceOne(n);
        ArrayList<Integer> gap2 = gapSequenceTwo(n);
        ArrayList<Integer> gap3 = gapSequenceThree(n);
        ArrayList<Integer> gap4 = gapSequenceFour(n);
        ArrayList<Integer> gap5 = gapSequenceFive(n);
        ArrayList<Integer> gap6 = gapSequenceSix(n);
        System.out.println("Ciąg 1: ");
        System.out.println("Wersja 1: " + new ShellSortVersionOne(createRandomArray(n),gap1).executeAlgorythm());
        System.out.println("Wersja 2: " + new ShellSortVersionTwo(createRandomArray(n),gap1).executeAlgorythm());
        System.out.println("Wersja 3: " + new ShellSortVersionThree(createRandomArray(n),gap1).executeAlgorythm());
        System.out.println("Ciąg 2: ");
        System.out.println("Wersja 1: " + new ShellSortVersionOne(createRandomArray(n),gap2).executeAlgorythm());
        System.out.println("Wersja 2: " + new ShellSortVersionTwo(createRandomArray(n),gap2).executeAlgorythm());
        System.out.println("Wersja 3: " + new ShellSortVersionThree(createRandomArray(n),gap2).executeAlgorythm());
        System.out.println("Ciąg 3: ");
        System.out.println("Wersja 1: " + new ShellSortVersionOne(createRandomArray(n),gap3).executeAlgorythm());
        System.out.println("Wersja 2: " + new ShellSortVersionTwo(createRandomArray(n),gap3).executeAlgorythm());
        System.out.println("Wersja 3: " + new ShellSortVersionThree(createRandomArray(n),gap3).executeAlgorythm());
        System.out.println("Ciąg 4: ");
        System.out.println("Wersja 1: " + new ShellSortVersionOne(createRandomArray(n),gap4).executeAlgorythm());
        System.out.println("Wersja 2: " + new ShellSortVersionTwo(createRandomArray(n),gap4).executeAlgorythm());
        System.out.println("Wersja 3: " + new ShellSortVersionThree(createRandomArray(n),gap4).executeAlgorythm());
        System.out.println("Ciąg 5: ");
        System.out.println("Wersja 1: " + new ShellSortVersionOne(createRandomArray(n),gap5).executeAlgorythm());
        System.out.println("Wersja 2: " + new ShellSortVersionTwo(createRandomArray(n),gap5).executeAlgorythm());
        System.out.println("Wersja 3: " + new ShellSortVersionThree(createRandomArray(n),gap5).executeAlgorythm());
        System.out.println("Ciąg 6: ");
        System.out.println("Wersja 1: " + new ShellSortVersionOne(createRandomArray(n),gap6).executeAlgorythm());
        System.out.println("Wersja 2: " + new ShellSortVersionTwo(createRandomArray(n),gap6).executeAlgorythm());
        System.out.println("Wersja 3: " + new ShellSortVersionThree(createRandomArray(n),gap6).executeAlgorythm());
    }
}
