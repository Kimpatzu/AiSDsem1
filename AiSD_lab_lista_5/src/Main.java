import java.io.*;
import java.util.ListIterator;
import java.util.Scanner;


public class Main {

    public static L2KCzS<Pracownik> utworzBazeDanych(){
        L2KCzS<Pracownik> bazaPracownikow = new L2KCzS<>();
        bazaPracownikow.add(new Pracownik(72091062265l,"Strzeszewski", "Tobiasz","24-01-1982","dyrektor",5600,15));
        bazaPracownikow.add(new Pracownik(56082326822l,"Tomaszewska", "Anna","12-05-1993","kierowca",4200,7));
        bazaPracownikow.add(new Pracownik(46061294237l,"Dobrodziej", "Karol","07-12-1985","księgowy",3700,11));
        bazaPracownikow.add(new Pracownik(73091062265l,"Kołodziejczyk", "Marek","30-09-1963","sekretarz",2900,23));
        return  bazaPracownikow;
    }
    public static void wyswietl(L2KCzS<Pracownik> bazaPracownikow){
        ListIterator iterator =  bazaPracownikow.listIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    public static L2KCzS<Pracownik> odczytajBazeZPliku(){
        L2KCzS<Pracownik> bazaPracownikow = new L2KCzS<>();
        try{
            FileInputStream fileInputStream = new FileInputStream("Pracownicy.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            bazaPracownikow = (L2KCzS<Pracownik>) objectInputStream.readObject();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return bazaPracownikow;
    }
    public static float obliczSredniaPensji(L2KCzS<Pracownik> bazaPracownikow){
        int counter = 0;
        float suma=0;
        ListIterator iterator = bazaPracownikow.listIterator();
        Pracownik current;
        while(iterator.hasNext()){
            current = (Pracownik) iterator.next();
            suma += current.getPensja();
            counter ++;
        }
        return suma/counter;
    }
    public static int liczbaPracownikowZarabiajacychPonizejSredniej(L2KCzS<Pracownik> bazaPracownikow){
        float srednia = obliczSredniaPensji(bazaPracownikow);
        ListIterator iterator = bazaPracownikow.listIterator();
        int counter = 0;
        Pracownik current;
        while (iterator.hasNext()){
            current = (Pracownik) iterator.next();
            if  (current.getPensja() < srednia){
                counter++;
            }
        }
        return counter;
    }
    public static Pracownik wyswietlDanePracownika(long pesel, L2KCzS<Pracownik> bazaPracownikow){
        ListIterator iterator =  bazaPracownikow.listIterator();
        Pracownik current;
        while (iterator.hasNext()){
            current = (Pracownik) iterator.next();
            if (current.getPesel() == pesel){
                System.out.println(current);
                return current;
            }
        }
        return null;
    }
    public static L2KCzS<Pracownik> usunPracownika(long pesel, L2KCzS<Pracownik> bazaPracownikow){
        ListIterator iterator = bazaPracownikow.listIterator();
        Pracownik current;
        while (iterator.hasNext()){
            current = (Pracownik) iterator.next();
            if( current.getPesel() == pesel){
                iterator.remove();
            }
        }
        return bazaPracownikow;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        int menuChoice = 0;
        L2KCzS<Pracownik> bazaPracownikow = new L2KCzS<>();
        while (running){
            System.out.println("1. Utwórz nową bazę danych\n" +
                    "2. Odczytaj bazę z pliku\n" +
                    "3. Wyświetl wszystkie rekordy\n" +
                    "4. Wyświetle dane pracownika\n" +
                    "5. Dopisz pracownika\n" +
                    "6. Usuń pracownika\n" +
                    "7. Aktualizuj pracownika\n" +
                    "8. Oblicz średnią pensję\n" +
                    "9. Oblicz liczbę pracowników zarabiających poniżej średniej\n" +
                    "10. Zapisz bazę do pliku\n" +
                    "11. Zakończ program");
            menuChoice = scanner.nextInt();
            switch (menuChoice){
                case 1:
                    bazaPracownikow = utworzBazeDanych();
                    break;
                case 2:
                    bazaPracownikow = odczytajBazeZPliku();
                    break;
                case 3:
                    wyswietl(bazaPracownikow);
                    break;
                case 4:
                    System.out.println("Podaj pesel pracownika: ");
                    long pesel = scanner.nextLong();
                    wyswietlDanePracownika(pesel,bazaPracownikow);
                    break;
                case 5:
                    System.out.println("Podaj pesel pracownika: ");
                    long peselAdd = scanner.nextLong();
                    System.out.println("Podaj nazwisko pracownika: ");
                    String nazwiskoAdd = scanner.next();
                    System.out.println("Podaj imie pracownika: ");
                    String imieAdd = scanner.next();
                    System.out.println("Podaj datę urodzenia pracownika: ");
                    String dataurAdd = scanner.next();
                    System.out.println("Podaj stanowisko pracownika: ");
                    String stanowiskoAdd = scanner.next();
                    System.out.println("Podaj pensję pracownika: ");
                    int pensjaAdd = scanner.nextInt();
                    System.out.println("Podaj staż pracownika: ");
                    int stazAdd = scanner.nextInt();
                    bazaPracownikow.add(new Pracownik(peselAdd,nazwiskoAdd,imieAdd,dataurAdd,stanowiskoAdd,pensjaAdd,stazAdd));
                    break;
                case 6:
                    System.out.println("Podaj pesel pracownika: ");
                    long peselDel = scanner.nextLong();
                    bazaPracownikow = usunPracownika(peselDel, bazaPracownikow);
                    break;
                case 7:
                    System.out.println("Podaj pesel pracownika: ");
                    long peselChange = scanner.nextLong();
                    Pracownik pracownik= wyswietlDanePracownika(peselChange, bazaPracownikow);
                    int index = bazaPracownikow.indexOf(pracownik);
                    boolean runningChangeMenu = true;
                    while (runningChangeMenu){
                        System.out.println("1. Zmień Nazwisko\n2. Zmień Imie\n3. Zmień datę urodzenia\n4. Zmień stanowisko\n5. Zmień pensję\n6. Zmień staż\n7. Zakończ zmienianie pracownika");
                        int menuPracownikChangeChoice = scanner.nextInt();
                        switch (menuPracownikChangeChoice){
                            case 1:
                                String nazwkiskoChange = scanner.next();
                                bazaPracownikow.get(index).setNazwisko(nazwkiskoChange);
                                break;
                            case 2:
                                String imieChange = scanner.next();
                                bazaPracownikow.get(index).setImie(imieChange);
                                break;
                            case 3:
                                String dataurChange = scanner.next();
                                bazaPracownikow.get(index).setData_urodzenia(dataurChange);
                                break;
                            case 4:
                                String stanowiskoChange = scanner.next();
                                bazaPracownikow.get(index).setStanowisko(stanowiskoChange);
                                break;
                            case 5:
                                int pensjaChange = scanner.nextInt();
                                bazaPracownikow.get(index).setPensja(pensjaChange);
                                break;
                            case 6:
                                int stazChange = scanner.nextInt();
                                bazaPracownikow.get(index).setStaż(stazChange);
                                break;
                            case 7:
                                runningChangeMenu = false;
                                break;
                        }
                    }
                    break;
                case 8:
                    System.out.println(obliczSredniaPensji(bazaPracownikow));
                    break;
                case 9:
                    System.out.println(liczbaPracownikowZarabiajacychPonizejSredniej(bazaPracownikow));
                    break;
                case 10:
                    try{
                        FileOutputStream fileOutputStream  = new FileOutputStream("Pracownicy.ser");
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                        objectOutputStream.writeObject(bazaPracownikow);
                    } catch (FileNotFoundException e){
                        e.printStackTrace();
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                    break;
                case 11:
                    running = false;
                    break;
            }
        }

    }
}
