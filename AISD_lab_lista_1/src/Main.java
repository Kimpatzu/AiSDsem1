import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbę pracowników: ");
        int liczba_pracowników_do_pobrania = scanner.nextInt();
        Pracownik[] pracownicyScanner = new Pracownik[liczba_pracowników_do_pobrania];
        int wybórEtatotowyGodzinowy=0;
        String nazwisko = "";
        String imie = "";
        long pesel = 0;
        String stanowisko = "";
        int staż = 0;
        for (int i=0; i<liczba_pracowników_do_pobrania; i++){
            System.out.println("Wpisz 1 jeśli chcesz dodać pracownika etatowego lub wpisz 2 dla pracownika Godzinowego");
            wybórEtatotowyGodzinowy = scanner.nextInt();
            System.out.println("Podaj nazwisko: ");
            nazwisko = scanner.next();
            System.out.println("Podaj imie: ");
            imie = scanner.next();
            System.out.println("Podaj pesel: ");
            pesel = scanner.nextLong();
            System.out.println("Podaj stanowisko: ");
            stanowisko = scanner.next();
            System.out.println("Podaj staż: ");
            staż = scanner.nextInt();
            if (wybórEtatotowyGodzinowy == 1){
                System.out.println("Podaj etat: ");
                float etat = scanner.nextFloat();
                System.out.println("Podaj stawkę: ");
                double stawka = scanner.nextDouble();
                pracownicyScanner[i] = new PracownikEtatowy(nazwisko,imie,pesel,stanowisko,staż,etat,stawka);
            } else {
                System.out.println("Podaj stawkę:  ");
                double stawka = scanner.nextDouble();
                System.out.println("Podaj liczbę godzin: ");
                int liczba_godzin = scanner.nextInt();
                pracownicyScanner[i] = new PracownikGodzinowy(nazwisko,imie,pesel,stanowisko,staż,stawka,liczba_godzin);
            }
        }
        IteratorPracownikow iterScanner = new IteratorPracownikow(pracownicyScanner);
        iterScanner.wyswietl();
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("pracownicy.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.write(pracownicyScanner.length);
            for (int i=0; i<pracownicyScanner.length; i++){
                objectOutputStream.writeObject(pracownicyScanner[i]);
            }
            objectOutputStream.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        int liczba_pracowników =0;
        try{
            FileInputStream fileInputStream = new FileInputStream("pracownicy.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            try {
               liczba_pracowników = objectInputStream.read();
               Pracownik[] pracowniks = new Pracownik[liczba_pracowników];
               for (int i=0; i<liczba_pracowników; i++){
                   pracowniks[i] = (Pracownik) objectInputStream.readObject();
               }
               IteratorPracownikow iter = new IteratorPracownikow(pracowniks);
               iter.wyswietl();
            } catch (ClassNotFoundException e){
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
