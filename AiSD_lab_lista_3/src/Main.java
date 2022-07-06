import java.util.Scanner;

public class Main {

    public static boolean isPalindrome(String wyrazenie){
        ArrayStack<Character> array1 = new ArrayStack<>(wyrazenie.length());
        for (int i=0; i<wyrazenie.length(); i++){
            try{
                array1.push(wyrazenie.charAt(i));
            } catch (FullStackException e){
                e.printStackTrace();
            }
        }
        array1.reverseStack();
        for(int i=wyrazenie.length()-1; i>=(wyrazenie.length()+1)/2; i--){
            try{
                char ch = array1.pop();
                if(ch!=wyrazenie.charAt(i)){
                    return false;
                }
            } catch (EmptyStackException e){
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj wyrażenie: ");
        String wyrazenie = scanner.nextLine();
        Nawiasy nawiasy = new Nawiasy();
        if (nawiasy.nawiasyZrownowazone(wyrazenie)){
            System.out.println("Nawiasy są poprawnie zrównoważone");
        } else {
            System.out.println("Nawiasy nie są poprawnie zrównoważone");
        }
        if (isPalindrome(wyrazenie)){
            System.out.println("Wprowadzone wyrażenie jest palindromem");
        } else {
            System.out.println("Wprowadzone wyrażenie nie jest palindromem");
        }
    }
}
