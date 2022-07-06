import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static ArrayList<Karta> utworzListe(){
        Random random = new Random();
        int wartosc = random.nextInt(14);
        int kolor = 4;
        ArrayList<Karta> lista = new ArrayList<>();
        boolean dodane = false;
        while(wartosc!=0){
            kolor = random.nextInt(4);
            if(lista.isEmpty()){
                lista.add(new Karta(wartosc,kolor));
            } else {
                int i=0;
                dodane=false;
                while (!dodane){
                    if (lista.get(i).getWartosc()<wartosc){
                        lista.add(i,new Karta(wartosc,kolor));
                        dodane=true;
                    } else if(lista.get(i).getWartosc()==wartosc){
                        if(lista.get(i).getKolor()<= kolor){
                            lista.add(i,new Karta(wartosc,kolor));
                            dodane=true;
                        }
                    }
                    if (i==lista.size()-1){
                        lista.add(new Karta(wartosc,kolor));
                        dodane=true;
                    }
                    i++;
                }
            }
            wartosc = random.nextInt(14);
        }
        return lista;
    }

    public static void wyswietlListe(ArrayList<Karta> lista){
        IteratorKart<Karta> iter = new IteratorKart<>(lista);
        iter.wyswietl();
    }
    public static void wyswietlLiczbeElementow(ArrayList<Karta> lista){
        System.out.println(lista.size());
    }
    public static void wyswietlKartyOWartosci(ArrayList<Karta> lista, int wartosc){
        for (int i=0; i< lista.size(); i++) {
            if (lista.get(i).getWartosc()==wartosc){
                System.out.println(lista.get(i));
            }
        }
    }
    public static void wyswietlKartyOKolorze(ArrayList<Karta> lista, int kolor){
        for (Karta e: lista) {
            if (e.getKolor()==kolor){
                System.out.println(e);
            }
        }
    }
    public static ArrayList<Karta> usunPowtorzenia(ArrayList<Karta> lista){
        int i=1;
        lista.add(0,new Karta(1,0));
        lista.add(0,new Karta(1,0));
        lista.add(0,new Karta(1,0));
        while(i!= lista.size()){
            if (lista.get(i-1).getWartosc()==lista.get(i).getWartosc()){
                if (lista.get(i-1).getKolor()==lista.get(i).getKolor()){
                    lista.remove(i);
                    i--;
                }
            }
            i++;
        }
        return lista;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wybor=0;
        ArrayList<Karta> lista = new ArrayList<>();
        while(true){
            System.out.println("1. Utwórz listę");
            System.out.println("2. Wyświetl listę");
            System.out.println("3. Wyświetl liczbę elementów listy");
            System.out.println("4. Wyświetl karty o podanej wartości");
            System.out.println("5. Wyświetl karty o podanym kolorze");
            System.out.println("6. Usuń powtarzające się karty");
            wybor=scanner.nextInt();
            switch (wybor){
                case 1:
                    lista=utworzListe();
                    break;
                case 2:
                    if (lista.isEmpty()){
                        System.out.println("Najpierw utwórz listę");
                        break;
                    } else {
                        wyswietlListe(lista);
                        break;
                    }
                case 3:
                    if (lista.isEmpty()){
                        System.out.println("Najpierw utwórz listę");
                        break;
                    } else {
                        wyswietlLiczbeElementow(lista);
                        break;
                    }
                case 4:
                    if (lista.isEmpty()){
                        System.out.println("Najpierw utwórz listę");
                        break;
                    } else {
                        System.out.println("podaj wartosc karty: ");
                        int wartosc = scanner.nextInt();
                        wyswietlKartyOWartosci(lista,wartosc);
                        break;
                    }
                case 5:
                    if (lista.isEmpty()){
                        System.out.println("Najpierw utwórz listę");
                        break;
                    } else {
                        System.out.println("podaj kolor karty: ");
                        int kolor = scanner.nextInt();
                        wyswietlKartyOKolorze(lista,kolor);
                        break;
                    }
                case 6:
                    if (lista.isEmpty()){
                        System.out.println("Najpierw utwórz listę");
                        break;
                    } else {
                        lista = usunPowtorzenia(lista);
                        break;
                    }
            }
        }
        //ArrayList<Karta> lista = utworzListe();
        //wyswietlListe(lista);
        //wyswietlLiczbeElementow(lista);
        //wyswietlKartyOWartosci(lista,5);
        //wyswietlKartyOKolorze(lista,1);
        //System.out.println("__");
        //wyswietlListe(usunPowtorzenia(lista));
    }
}
