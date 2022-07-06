import java.util.Random;

public class Firma {
    private Magazyn[] magazyny;
    private int liczbaMagazynów;
    private float businessProfit;

    public Firma(int n) {
        this.liczbaMagazynów = n;
        this.magazyny = new Magazyn[n];
        this.businessProfit = 0;
    }

    public String work(){
        String output = "";
        for (int i=0; i<liczbaMagazynów; i++){
            output += "\n" + "Magazyn nr. " + i + ": \n";
            String magazynWorkOrder = "";
            magazynWorkOrder = magazyny[i].executeOrder();
            while(magazynWorkOrder!=null){
                magazynWorkOrder = magazyny[i].executeOrder();
            }
            output += magazyny[i].rozliczMagazyn();
            output += "Przychody z magazynu: " + magazyny[i].getAllProfits() + "\n";
            businessProfit += magazyny[i].getAllProfits();
        }
        return output + "Przychody ze wszystkich magazynow: " + businessProfit;
    }
    public void firmaRandomizer(){
        for (int i=0; i<liczbaMagazynów; i++){
            magazyny[i] = magazynRandomizer();
        }
    }
    private Magazyn magazynRandomizer(){
        Random random = new Random();
        int liczbaKlientow = random.nextInt(5)+5;
        Magazyn magazyn = new Magazyn();
        for (int i=0; i<liczbaKlientow; i++){
            magazyn.enqueue(klientRandomizer());
        }
        return magazyn;
    }
    private Zamowienie zamowienieRandomizer(){
        Random random = new Random();
        String[] nazwyPrzedmiotow = {"jajka","chleb", "pomidor","napój","ziemniaki", "kajzerka","margaryna", "makaron"};
        float[] cenyPrzedmiotow = {0.79f,2.89f,1.34f,4.99f,15.99f,0.29f,4.19f,2.79f};
        int actPrzedmiot = random.nextInt(7);
        int iloscSztuk = random.nextInt(9)+1;
        return new Zamowienie(nazwyPrzedmiotow[actPrzedmiot],iloscSztuk,cenyPrzedmiotow[actPrzedmiot]);
    }

    private Klient klientRandomizer(){
        Random random = new Random();
        OneWayLinkedListWithHeadAndTailQueue<Zamowienie> zamowienia = new OneWayLinkedListWithHeadAndTailQueue<>();
        String[] bazaNazwKlientów = {"Andrzej Urban", "Marcin Poniatowski", "Bożena Cybulak", "Władysław Chrobry", "Wiktoria Hnatek", "Jakub Nocoń", "Klaudia Pieszczek", "Kacper Sobowiec", "Julia Korólczyk", "Michał Znamirowski", "Alicja Watral"};
        int liczbaZamowien = random.nextInt(3)+2;
        //size baz danych klienta 11, max index 10
        for (int i=0; i<liczbaZamowien; i++){
            zamowienia.enqueue(zamowienieRandomizer());
        }
        return new Klient(zamowienia,bazaNazwKlientów[random.nextInt(bazaNazwKlientów.length-1)]);
    }
}
