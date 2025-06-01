import java.util.Stack;

public class ValidParanthesis {

    public static boolean checkValidness(String s){
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){

            if(s.charAt(i)==')'){

                if (stack.contains('(')) {
                    stack.pop();
                }
            }
            if(s.charAt(i)=='('){
                    stack.push('(');
            }
        }
        
        if(stack.isEmpty()) return true;

        return false;

       }

    public static void main(String[] args) {
        String s="{[(()]}";
        System.out.println( checkValidness(s) );

    }
}




