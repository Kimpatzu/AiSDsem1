import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("250001", "Kowal", "Adam", 0);
        Student s2 = new Student("250002", "Wawrzyniec", "Julia", 4);
        Student s3 = new Student("250003", "Zając", "Kacper", 0);
        Student s4 = new Student("250004", "Olejnik", "Damian", 5);
        Student listaStudentów[] = new  Student[4];
        listaStudentów[0] = s1;
        listaStudentów[1] = s2;
        listaStudentów[2] = s3;
        listaStudentów[3] = s4;
        StudentIterator iter = new StudentIterator(listaStudentów);
        System.out.println(iter.wyswietlTabele());
        iter.wpiszOcene("250003",3.5f);
        System.out.println(iter.getSredniaPozytywnychOcen());
        System.out.println(iter.wyswietlListaNieZaliczeni());

    }
}
