import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int[] getCharFrequencyArray(String text){
        int[] frequencyArr = new int[128];
        char[] textCharArr = text.toCharArray();
        for (int i=0;  i< textCharArr.length; i++){
            frequencyArr[textCharArr[i]]++;
        }
        return frequencyArr;
    }
    static int[][] getReducedFrequencyArray(int[] freqArr){
        int numberOfSymbols = 0;
        for (int i=0; i<freqArr.length; i++){
            if (freqArr[i]!=0){
                numberOfSymbols++;
            }
        }
        int [][] redFreqArr = new int[numberOfSymbols][2];
        int j=0;
        for (int i=0; i<freqArr.length; i++){
            if (freqArr[i]!=0){
                redFreqArr[j][0] = i;                  //wartość znaku Ascii
                redFreqArr[j][1] = freqArr[i];         //ilość znaku Ascii w tekstcie
                j++;
            }
        }
        return freqArrSort(redFreqArr);
    }
    static int[][] freqArrSort(int[][] redFreqArr){
        int n = redFreqArr.length;
        for (int i=0; i<n-1; i++){
            int minIndex = i;
            for(int j = i+1; j<n; j++){
                if(redFreqArr[j][1] < redFreqArr[minIndex][1]){
                    minIndex = j;
                }
            }
            int pom1 = redFreqArr[minIndex][0];
            int pom2 = redFreqArr[minIndex][1];
            redFreqArr[minIndex][0] = redFreqArr[i][0];
            redFreqArr[minIndex][1] = redFreqArr[i][1];
            redFreqArr[i][0] = pom1;
            redFreqArr[i][1] = pom2;
        }
        return redFreqArr;
    }
    static ArrayList<HufffmanTree> forester(int[][] redFreqArr){
        ArrayList<HufffmanTree> forest = new ArrayList<>();
        for (int i=0; i< redFreqArr.length; i++){
            forest.add(new HufffmanTree(redFreqArr[i][0], redFreqArr[i][1]));
        }
        forest.sort(new HuffmanTreeComparator());
        return forest;
    }
    static HufffmanTree createHuffmanTree(ArrayList<HufffmanTree> forest){
        while(forest.size()!=1){
            HufffmanTree hT1 = forest.get(0);
            HufffmanTree hT2 = forest.get(1);
            forest.remove(0);
            forest.remove(0);
            HufffmanTree newHT = new HufffmanTree(hT1,hT2);
            forest.add(newHT);
            forest.sort(new HuffmanTreeComparator());
        }
        return forest.get(0);
    }
    static String[][] convertToCodeTable(HufffmanTree hT){
        String text = hT.getCode();
        char[] textCharArr = text.toCharArray();
        int codeTableSize = 0;
        for(int i=0; i< textCharArr.length; i++){
            if (textCharArr[i] == 10){
                codeTableSize++;
            }
        }
        String[][] codeTable = new String[codeTableSize][2];
        int j=1;
        codeTable[0][0] = "" + textCharArr[0];
        for (int i=0; i< textCharArr.length; i++){
            if (textCharArr[i]==10){                //gdy znak nowej linii
                int k=1;
                String s = "";
                while(textCharArr[i-k]!=' '){        //cofamy się tak długo jak nie spacja
                    s = textCharArr[i-k]+s;
                    k++;
                }
                codeTable[j-1][1] = s;
                if(i+1 != textCharArr.length) {
                    codeTable[j][0] = "" + textCharArr[i + 1];
                }
                j++;
            }
        }
        return codeTable;
    }
    static String getCodedString(String[][] codeTable, String text){
        String codedString = "";
        char[] textCharArr = text.toCharArray();
        for(int i=0; i< textCharArr.length; i++){
            for (int j=0; j< codeTable.length; j++){
                char currentSymbol = codeTable[j][0].toCharArray()[0];
                if(currentSymbol == textCharArr[i]){
                    codedString += codeTable[j][1];
                }
            }
        }
        return codedString;
    }
    public static void main(String[] args) {
        String nazwaPlikuTekstowego = "LoremIpsum.txt";                 //LoremIpsum.txt
        String nazwaPlikuZakodowanego = "LoremIpsumZakodowany.txt";     //LoremIpsumZakodowany.txt
        String przykladczyt = "";
        try{
            FileInputStream fileInputStream = new FileInputStream(nazwaPlikuTekstowego);
            Scanner reader = new Scanner(fileInputStream);
            while (reader.hasNextLine()){
                przykladczyt += reader.nextLine();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("Wczytany teks: ");
        System.out.println(przykladczyt);
        int[][] redFreqArr = getReducedFrequencyArray(getCharFrequencyArray(przykladczyt));
        System.out.println("Tabela częstotliwości występowania: ");
        for(int i=0; i< redFreqArr.length; i++){
            System.out.println(redFreqArr[i][0] + ": " + (char)redFreqArr[i][0] + "    " + redFreqArr[i][1]);
        }
        System.out.println("Tabela kodów: ");
        HufffmanTree finalHT = createHuffmanTree(forester(redFreqArr));
        String[][] codeTable = convertToCodeTable(finalHT);
        for(int i =0; i< codeTable.length; i++){
            System.out.println(codeTable[i][0] + " " + codeTable[i][1]);
        }
        String codedString = getCodedString(codeTable,przykladczyt);
        System.out.println("Zakodowany tekst: ");
        System.out.println(codedString);
        try{
            FileWriter fileWriter = new FileWriter(nazwaPlikuZakodowanego);
            fileWriter.write(codedString);
            fileWriter.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("Odczytywanie zakodowanego pliku: ");
        String czytzakod = "";
        try{
            FileInputStream fileInputStream = new FileInputStream(nazwaPlikuZakodowanego);
            Scanner reader = new Scanner(fileInputStream);
            while (reader.hasNextLine()){
                czytzakod += reader.nextLine();
                if (reader.hasNextLine()){
                    czytzakod += "\n";
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(czytzakod);
        System.out.println("Zdekodowany tekst: ");
        System.out.println(finalHT.decodeString(czytzakod));

    }
}
