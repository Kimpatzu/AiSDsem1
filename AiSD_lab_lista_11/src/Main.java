import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static ArrayList<StringIntValuesClass> convertText(){
        ArrayList<StringIntValuesClass> list = new ArrayList<>();
        try{
            FileInputStream fileInputStream = new FileInputStream("tekst.txt");
            Scanner reader = new Scanner(fileInputStream);
            int lineCounter=0;
            while(reader.hasNextLine()){
                lineCounter++;
                ArrayList<String> dividedStrings = stringDivider(reader.nextLine());
                for (int i = 0; i< dividedStrings.size(); i++){
                    list.add(new StringIntValuesClass(lineCounter, dividedStrings.get(i)));
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return list;
    }
    public static ArrayList<String> stringDivider(String stringLine){
        ArrayList<String> list = new ArrayList<>();
        char[] charArr = stringLine.toCharArray();
        String currentWord = "";
        for (int i =0; i<charArr.length; i++){
            if (charArr[i]>=97 && charArr[i]<=122){
                currentWord+=charArr[i];
            } else {
                if (!currentWord.equals("")) {
                    list.add(currentWord);
                }
                currentWord = "";
            }
        }
        return list;
    }
    public static void main(String[] args) {
        RBTree<String> stringRBTree = new RBTree<String>(new StringComparator());
        //stringRBTree.insert("parasol",1);
        //stringRBTree.insert("noś",1);
        //stringRBTree.insert("i",1);
        //stringRBTree.insert("przy",1);
        //stringRBTree.insert("nie",1);
        //stringRBTree.insert("pogodzie",1);
        //stringRBTree.insert("nie",2);
        //stringRBTree.insert("tylko",2);
        //stringRBTree.insert("gdy",2);
        //stringRBTree.insert("deszcz",2);
        //stringRBTree.insert("pada",2);
        //stringRBTree.insert("choć",2);
        //stringRBTree.insert("dzisiaj",2);
        //stringRBTree.insert("nie",4);
        //stringRBTree.insert("jest",2);
        ArrayList<StringIntValuesClass> list = convertText();
        for (int i=0; i<list.size(); i++){
            stringRBTree.insert(list.get(i).getWyraz(), list.get(i).getWierszwystopienia());
        }
        System.out.println(stringRBTree.traverseInOrder());
        stringRBTree.remove("czesto");
        System.out.println(stringRBTree.traverseInOrder());
    }
}
