import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static Student[] generujPrzykladowychStudentow(){
        ArrayList<Float> o1 = new ArrayList<>();
        ArrayList<Float> o2 = new ArrayList<>();
        ArrayList<Float> o3 = new ArrayList<>();
        ArrayList<Float> o4 = new ArrayList<>();
        o1.add(4.0f);
        o1.add(3.0f);
        o2.add(2.0f);
        o2.add(3.0f);
        o3.add(5.0f);
        o3.add(2.0f);
        o4.add(3.0f);
        o4.add(5.0f);
        Student s1 = new Student(250001, "Kowal", "Adam", o1);
        Student s2 = new Student(250002, "Wawrzyniec", "Julia", o2);
        Student s3 = new Student(250003, "Zając", "Kacper", o3);
        Student s4 = new Student(250004, "Olejnik", "Damian", o4);
        Student listaStudentów[] = new  Student[4];
        listaStudentów[0] = s1;
        listaStudentów[1] = s2;
        listaStudentów[2] = s3;
        listaStudentów[3] = s4;
        return listaStudentów;
    }

    public static void wyswietlStudentow(Student[] tab){
        ArraytIterator<Student> studentIterator = new ArraytIterator<>(tab);
        while(studentIterator.hasNext()){
            try{
                System.out.println(studentIterator.next());
            } catch (NoSuchElementException e){
                e.printStackTrace();
            }
        }
    }

    public static Student[] wpiszOcene(int nrIndeksu, float ocena, Student[] tab){
        for(int i=0; i<tab.length; i++){
            if (tab[i].getNrIndeksu()==nrIndeksu){
                tab[i].addOcena(ocena);
            }
        }
        return tab;
    }

    public static float obliczSredniaOcenPozytywnych(Student[] tab){
        ArraytIterator<Student> studentIterator = new ArraytIterator<>(tab);
        float suma=0;
        int licznik=0;
        float sredniaJednegoStudenta;
        while(studentIterator.hasNext()){
            try{
                sredniaJednegoStudenta =  studentIterator.next().getSredniaOcen();
                if(sredniaJednegoStudenta>=3){
                    suma+=sredniaJednegoStudenta;
                    licznik++;
                }
            } catch(NoSuchElementException e){
                e.printStackTrace();
            }
        }
        return suma/licznik;
    }

    public static void wyswietlStudentowKtorzyNieZaliczyliKursu(Student[] tab){
        ArraytIterator<Student> studentIterator = new ArraytIterator<>(tab);
        Student pomStudent;
        while(studentIterator.hasNext()){
            pomStudent=studentIterator.next();
            if (pomStudent.getSredniaOcen()<3){
                System.out.println(pomStudent);
            }
        }
    }
    public static void main(String[] args) {
        Student listaStudentów[] = generujPrzykladowychStudentow();
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("1. Wyświetl studentów\n2. Wpisz ocenę\n3. Wyświetl średnią pozytywnych ocen\n4. Wyświetl studentów, którzy nie ukończyli kursu\n5. Zakończ program");
            int menuChoice = scanner.nextInt();
            switch (menuChoice) {
                case 1:
                    wyswietlStudentow(listaStudentów);
                    break;
                case 2:
                    System.out.println("Podaj numer indeksu: ");
                    int nrIndeksu = scanner.nextInt();
                    System.out.println("Podaj ocenę: ");
                    float ocena = scanner.nextFloat();
                    listaStudentów=wpiszOcene(nrIndeksu,ocena,listaStudentów);
                    break;
                case 3:
                    System.out.println(obliczSredniaOcenPozytywnych(listaStudentów));
                    break;
                case 4:
                    wyswietlStudentowKtorzyNieZaliczyliKursu(listaStudentów);
                    break;
                case 5:
                    run=false;
                    break;
            }
        }

    }
}
