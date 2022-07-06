import java.util.Scanner;
import java.util.Random;

public class Main {

    public static boolean[] updateDeckControler (boolean[] deckCotroler, Karta karta){
        if (karta.isZnacznik()){
            deckCotroler[karta.getWartosc()-1+(13* karta.getKolor())] = true;
        }
        return deckCotroler;
    }
    public static boolean checkDeckControler(boolean[] deckControler, Karta karta){
        if (!karta.isZnacznik()){
            return false;
        }
        return deckControler[karta.getWartosc()-1+(13* karta.getKolor())];
    }
    public static OneWayLinkedListWithHead<Karta> utworzListe(){
        Random random = new Random();
        int wartosc = random.nextInt(15);
        int kolor = 4;
        OneWayLinkedListWithHead<Karta> cardDeck = new OneWayLinkedListWithHead<>();
        boolean[] deckControler = new boolean[52];
        boolean dodane = false;
        while(wartosc!=0){
            kolor = random.nextInt(4);
            if (!checkDeckControler(deckControler,new Karta(wartosc,kolor))) {
                int i = 0;
                dodane = false;
                while (!dodane) {
                    System.out.println(cardDeck.get(i));
                    System.out.println(i);
                    if (cardDeck.get(i) == null) {
                        cardDeck.add(i, new Karta(wartosc, kolor));
                        dodane = true;
                        deckControler = updateDeckControler(deckControler, new Karta(wartosc, kolor));
                    } else if (cardDeck.get(i).compareTo(new Karta(wartosc, kolor)) < 0) {
                        cardDeck.add(i, new Karta(wartosc, kolor));
                        dodane = true;
                        deckControler = updateDeckControler(deckControler, new Karta(wartosc, kolor));
                    }
                    i++;
                }
            }
            wartosc = random.nextInt(15);
        }
        return cardDeck;
    }
    public static void wyswietl(OneWayLinkedListWithHead<Karta> cardDeck){
        int i  = 0;
        while(cardDeck.get(i)!=null){
            System.out.println(cardDeck.get(i));
            i++;
        }
    }
    public static void wyswieltLiczbeElementow(OneWayLinkedListWithHead<Karta> cardDeck){
        System.out.println("Liczba elementów: " + cardDeck.size());
        int i=0;
        int odkryteCounter = 0;
        int zakryteCounter = 0;
        while(cardDeck.get(i)!=null){
            if (cardDeck.get(i).isZnacznik()){
                odkryteCounter++;
            } else {
                zakryteCounter ++;
            }
            i++;
        }
        System.out.println("Liczba odkrytych kart: " + odkryteCounter);
        System.out.println("Liczba zakrytych kart: " + zakryteCounter);
    }
    public static void wyswietlKartyOWartosci(OneWayLinkedListWithHead<Karta> cardDeck, int wartosc){
        int i=0;
        while(cardDeck.get(i)!=null){
            if(cardDeck.get(i).getWartosc()==wartosc){
                System.out.println(cardDeck.get(i));
            }
            i++;
        }
    }
    public static void wyswietlKartyOKolorze(OneWayLinkedListWithHead<Karta> cardDeck, int kolor){
        int i=0;
        while(cardDeck.get(i)!=null){
            if(cardDeck.get(i).getKolor()==kolor){
                System.out.println(cardDeck.get(i));
            }
            i++;
        }
    }
    public static OneWayLinkedListWithHead<Karta> usunZakryteKarty (OneWayLinkedListWithHead<Karta> cardDeck){
        int i=0;
        while(cardDeck.get(i)!=null){
            if (!cardDeck.get(i).isZnacznik()){
                cardDeck.remove(i);
            }
            i++;
        }
        return cardDeck;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        OneWayLinkedListWithHead<Karta> cardDeck = new OneWayLinkedListWithHead<>();
        boolean endprogram = false;
        while(!endprogram) {
            System.out.println("1. Utwórz listę\n" +
                    "2. Wyświetl listę\n" +
                    "3. Wyświetl liczbę elementów listy\n" +
                    "4. Wyświetl karty o podanej wielkości\n" +
                    "5. Wyświetl karty o podanym kolorze\n" +
                    "6. Usuń zakryte karty\n" +
                    "7. Zakończ program");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    cardDeck = utworzListe();
                    break;
                case 2:
                    if(cardDeck.isEmpty()){
                        System.out.println("Najpierw utwórz listę");
                        break;
                    } else {
                        wyswietl(cardDeck);
                        break;
                    }
                case 3:
                    if(cardDeck.isEmpty()){
                        System.out.println("Najpierw utwórz listę");
                        break;
                    } else {
                        wyswieltLiczbeElementow(cardDeck);
                        break;
                    }
                case 4:
                    if(cardDeck.isEmpty()){
                        System.out.println("Najpierw utwórz listę");
                        break;
                    } else {
                        System.out.println("Podaj wartość: ");
                        int choice_2 = scanner.nextInt();
                        wyswietlKartyOWartosci(cardDeck,choice_2);
                        break;
                    }
                case 5:
                    if(cardDeck.isEmpty()){
                        System.out.println("Najpierw utwórz listę");
                        break;
                    } else {
                        System.out.println("Podaj kolor: ");
                        int choice_2 = scanner.nextInt();
                        wyswietlKartyOKolorze(cardDeck, choice_2);
                        break;
                    }
                case 6:
                    if(cardDeck.isEmpty()){
                        System.out.println("Najpierw utwórz listę");
                        break;
                    } else {
                        cardDeck = usunZakryteKarty(cardDeck);
                        break;
                    }
                case 7:
                    endprogram=true;
                    break;
            }
        }

    }
}
