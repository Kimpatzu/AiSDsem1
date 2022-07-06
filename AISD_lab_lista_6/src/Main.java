import java.util.Scanner;
import java.util.Random;


public class Main {
    public  static void testProgram(){
        Magazyn magazyn1 = new Magazyn();
        Zamowienie z1_1 = new Zamowienie("jajka",10,0.79f);
        Zamowienie z1_2 = new Zamowienie("chleb", 1, 2.89f);
        Zamowienie z1_3 = new Zamowienie("napój", 2, 4.99f);
        OneWayLinkedListWithHeadAndTailQueue<Zamowienie> zamowienia1 = new OneWayLinkedListWithHeadAndTailQueue<>();
        zamowienia1.enqueue(z1_1);
        zamowienia1.enqueue(z1_2);
        zamowienia1.enqueue(z1_3);
        Klient k1 = new Klient(zamowienia1, "Marcin Poniatowski");
        Zamowienie z2_1 = new Zamowienie("pomidor",2,1.34f);
        Zamowienie z2_2 = new Zamowienie("kajzerka", 4, 0.29f);
        Zamowienie z2_3 = new Zamowienie("napój", 1, 4.99f);
        Zamowienie z2_4 = new Zamowienie("ziemniaki", 1, 15.99f);
        OneWayLinkedListWithHeadAndTailQueue<Zamowienie> zamowienia2 = new OneWayLinkedListWithHeadAndTailQueue<>();
        zamowienia2.enqueue(z2_1);
        zamowienia2.enqueue(z2_2);
        zamowienia2.enqueue(z2_3);
        zamowienia2.enqueue(z2_4);
        Klient k2 = new Klient(zamowienia2, "Andrzej Urban");
        magazyn1.enqueue(k1);
        magazyn1.enqueue(k2);
        System.out.println(magazyn1.executeOrder());
        System.out.println(magazyn1.executeOrder());
        System.out.println(magazyn1.executeOrder());
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mainMenuChoice = 0;
        boolean running = true;
        while(running){
            System.out.println("1. Wykonaj program testowy 1 magazynu\n" +
                    "2. Wykonaj program\n" +
                    "3. Zakończ program");
            mainMenuChoice = scanner.nextInt();
            switch (mainMenuChoice){
                case 1:
                    testProgram();
                    break;
                case 2:
                    System.out.println("Podaj liczbę magazynów w Firmie");
                    int n = scanner.nextInt();
                    Firma firma = new Firma(n);
                    firma.firmaRandomizer();
                    System.out.println(firma.work());
                    break;
                case 3:
                    running = false;
                    break;
            }
        }
    }
}
