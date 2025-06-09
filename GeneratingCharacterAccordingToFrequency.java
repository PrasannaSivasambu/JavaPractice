import java.util.Stack;

public class GeneratingCharacterAccordingToFrequency {
    public static void main(String[] args) {
        String s="a1b3c2"; //abbbcc
      StringBuilder s1=new StringBuilder();
      Stack<Character> stack= new Stack<>();
      
      for(int i=0; i<s.length(); i++){
          if(Character.isDigit(s.charAt(i))){
              for(int j=0; j<Integer.parseInt(Character.toString(s.charAt(i))); j++){
                  s1.append(stack.peek());
              }
              while(!stack.isEmpty()){
                  stack.pop();
              }
          }
          else{
              stack.push(s.charAt(i));
          }
      }
      System.out.println(s1);
    }
}
