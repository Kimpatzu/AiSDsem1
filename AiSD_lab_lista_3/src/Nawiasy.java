public class Nawiasy {
    private ArrayStack<Character> stack;

    public Nawiasy(){
    }

    public boolean nawiasyZrownowazone(String wyrazenie){
        stack = new ArrayStack<>(wyrazenie.length());
        for (int i=0; i<wyrazenie.length(); i++){
            if(nawiasOtwierajacy(wyrazenie.charAt(i))){
                try {
                    stack.push(wyrazenie.charAt(i));
                } catch (FullStackException e){
                    e.printStackTrace();
                }
            }
            if(nawiasZamykajacy(wyrazenie.charAt(i))){
                if(stack.isEmpty()){
                    return false;
                } else {
                    char ch;
                    try{
                        ch = stack.pop();
                        if (ch=='('){
                            if (wyrazenie.charAt(i)!=')'){
                                return false;
                            }
                        } if (ch=='{'){
                            if (wyrazenie.charAt(i)!='}'){
                                return false;
                            }
                        } if (ch=='['){
                            if (wyrazenie.charAt(i)!=']'){
                                return false;
                            }
                        }
                    } catch (EmptyStackException e){
                        e.printStackTrace();
                    }
                }
            }
        }
        if (!stack.isEmpty()){
            return false;
        } else {
            return true;
        }
    }

    private boolean nawiasOtwierajacy(char ch){
        if (ch=='(' || ch=='{' || ch=='['){
            return true;
        } else {
            return false;
        }
    }

    private boolean nawiasZamykajacy(char ch){
        if (ch==')' || ch=='}' || ch==']'){
            return true;
        } else {
            return false;
        }
    }
}
